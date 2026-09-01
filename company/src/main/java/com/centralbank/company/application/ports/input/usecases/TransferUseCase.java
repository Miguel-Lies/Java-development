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
    private final BankAccount bankAccount;

    public TransferUseCase(TransferRepository transferRepository, UserRepository userRepository,
            BankAccountRepository bankRepository, BankAccount bankAccount) {
        this.transferRepository = transferRepository;
        this.userRepository = userRepository;
        this.bankRepository = bankRepository;
        this.bankAccount = bankAccount;
    }

    public TransferEnum transferByEmail(String email, BigDecimal amount) {
        User receiver = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return executeTransfer(receiver, amount);
    }

    public TransferEnum transferByNumber(String phone, BigDecimal amount) {
        User receiver = userRepository.findByPhone(phone)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return executeTransfer(receiver, amount);
    }

    public TransferEnum transferByCpf(String cpf, BigDecimal amount) {
        User receiver = userRepository.findByCpf(cpf)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return executeTransfer(receiver, amount);
    }

    public TransferEnum transferByRandomKey(String randomKey, BigDecimal amount) {
        User receiver = userRepository.findByRandomKey(randomKey)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return executeTransfer(receiver, amount);
    }

    private TransferEnum executeTransfer(User receiver, BigDecimal amount) {
        if (amount.compareTo(bankAccount.getBalance()) > 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        BankAccount receiverAccount = bankRepository.findByUserId(receiver.getId())
                .orElseThrow(() -> new NotFoundAccountException("Not found account for user"));

        bankAccount.setBalance(bankAccount.getBalance().subtract(amount));
        receiverAccount.setBalance(receiverAccount.getBalance().add(amount));

        bankRepository.save(bankAccount);
        bankRepository.save(receiverAccount);

        Transfers transfer = new Transfers(
                null,
                amount,
                bankAccount.getUserId(),
                receiverAccount.getUserId(),
                LocalDateTime.now());
        transferRepository.save(transfer);

        return TransferEnum.SUCCESS;
    }
}