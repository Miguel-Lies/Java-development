package com.studies.hexagonal.Adapters.output.linking;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.studies.hexagonal.Adapters.output.entity.ItemEntity;
import com.studies.hexagonal.Adapters.output.entity.SellerEntity;
import com.studies.hexagonal.Adapters.output.mapper.ItemMapper;
import com.studies.hexagonal.Adapters.output.repository.ItemEntityRepository;
import com.studies.hexagonal.Adapters.output.repository.SellerEntityRepository;
import com.studies.hexagonal.Application.port.output.persistence.repository.ItemRepository;
import com.studies.hexagonal.Domain.model.Item;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ItemAdapter implements ItemRepository{

    private final ItemEntityRepository repository;
    private final SellerEntityRepository sellerRepository;

    @Override
    public Item add(Item item) {
        SellerEntity seller = sellerRepository.getReferenceById(item.getSeller());

        ItemEntity entity = new ItemEntity(
            item.getId(),
            seller,
            item.getName(),
            item.getQuantity(),
            item.getPrice());

            ItemEntity itemSaved = repository.save(entity);

            return new Item(
    
                itemSaved.getId(),
                itemSaved.getSeller().getId(),
                itemSaved.getName(),
                itemSaved.getQuantity(),
                itemSaved.getPrice());
            }
    
            @Override
            public Item delete(Item item){
                SellerEntity seller = sellerRepository.getReferenceById(item.getSeller());
                ItemEntity entity = new ItemEntity(
                    item.getId(),
                    seller,
                    item.getName(),
                    item.getQuantity(),
                    item.getPrice());
                    repository.delete(entity);
                    
                    return item;
                }

                @Override
                public Optional<Item> findById(UUID id){
                    return repository.findById(id)
                    .map(entity -> new Item(
                        entity.getId(),
                        entity.getSeller().getId(),
                        entity.getName(),
                        entity.getQuantity(),
                        entity.getPrice()
                    ));
                }

                @Override
                public List<Item> findByName(String name) {
                    return repository.findByName(name)
                    .stream()
                    .map(ItemMapper::toDomain)
                    .toList();
            }
        }
