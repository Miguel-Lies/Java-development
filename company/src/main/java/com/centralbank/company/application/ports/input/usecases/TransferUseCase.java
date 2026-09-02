package com.centralbank.company.application.ports.input.usecases;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.centralbank.company.application.ports.output.persistence.repository.BankAccountRepository;
import com.centralbank.company.application.ports.output.persistence.repository.TransferRepository;
import com.centralbank.company.application.ports.output.persistence.repository.UserRepository;
import com.centralbank.company.domain.model.user.BankAccount;
import com.centralbank.company.domain.model.user.Transfers;
import com.centralbank.company.domain.model.user.User;
import com.centralbank.company.shared.enums.TransferEnum;
import com.centralbank.company.shared.exceptions.InsufficientBalanceException;
import com.centralbank.company.shared.exceptions.NotFoundAccountException;
import com.centralbank.company.shared.exceptions.UserNotFoundException;

public class TransferUseCase {
    private final TransferRepository transferRepository;
    private final UserRepository userRepository;
    private final BankAccountRepository bankRepository;

    public TransferUseCase(TransferRepository transferRepository, UserRepository userRepository,
            BankAccountRepository bankRepository) {
        this.transferRepository = transferRepository;
        this.userRepository = userRepository;
        this.bankRepository = bankRepository;
    }

    public TransferEnum transferByEmail(Long senderId, String email, BigDecimal amount) {
        User receiver = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return executeTransfer(senderId, receiver, amount);
    }

    private TransferEnum executeTransfer(Long senderId, User receiver, BigDecimal amount) {
        BankAccount senderAccount = bankRepository.findById(senderId)
                .orElseThrow(() -> new NotFoundAccountException("Not found account for user"));

        if (amount.compareTo(senderAccount.getBalance()) > 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        BankAccount receiverAccount = bankRepository.findById(receiver.getId())
                .orElseThrow(() -> new NotFoundAccountException("Not found account for user"));

        senderAccount.setBalance(senderAccount.getBalance().subtract(amount));
        receiverAccount.setBalance(receiverAccount.getBalance().add(amount));

        bankRepository.save(senderAccount);
        bankRepository.save(receiverAccount);

        Transfers transfer = new Transfers(
                null,
                amount,
                senderAccount.getUserId(),
                receiverAccount.getUserId(),
                LocalDateTime.now());
        transferRepository.save(transfer);

        return TransferEnum.SUCCESS;
    }
}