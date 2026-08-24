package com.centralbank.company.adapters.output.linking;

import org.springframework.stereotype.Component;

import com.centralbank.company.adapters.output.entity.TransferEntity;
import com.centralbank.company.adapters.output.entity.UserEntity;
import com.centralbank.company.adapters.output.repository.TransferEntityRepository;
import com.centralbank.company.adapters.output.repository.UserEntityRepository;
import com.centralbank.company.application.ports.output.persistence.repository.TransferRepository;
import com.centralbank.company.domain.model.user.Transfers;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TransferAdapter implements TransferRepository {

    private final TransferEntityRepository transferRepository;
    private final UserEntityRepository userRepository;

    @Override
    public Transfers save(Transfers transfer) {
        UserEntity senderEntity = userRepository.getReferenceById(transfer.getSender());
        UserEntity receiverEntity = userRepository.getReferenceById(transfer.getReceiver());

        TransferEntity entity = new TransferEntity(
                transfer.getId(),
                transfer.getAmount(),
                senderEntity,
                receiverEntity,
                transfer.getDate());

        TransferEntity savedTransfer = transferRepository.save(entity);

        return new Transfers(
                savedTransfer.getId(),
                savedTransfer.getAmount(),
                savedTransfer.getSenderId().getId(),
                savedTransfer.getReceiverId().getId(),
                savedTransfer.getDate());
    }

    @Override
    public void delete(Transfers transfer) {
        UserEntity senderEntity = userRepository.getReferenceById(transfer.getSender());
        UserEntity receiverEntity = userRepository.getReferenceById(transfer.getReceiver());

        TransferEntity entity = new TransferEntity(
                transfer.getId(),
                transfer.getAmount(),
                senderEntity,
                receiverEntity,
                transfer.getDate());

        transferRepository.delete(entity);
    }
}
