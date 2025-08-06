package com.luce.catalog.service;

import com.luce.catalog.model.Item;
import com.luce.catalog.repository.ItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogService {

    private final ItemRepository itemRepository;

    public CatalogService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> search(String query) {
        // Agora a pesquisa é feita diretamente na base de dados
        return itemRepository.findByTitleContainingIgnoreCaseOrGenreContainingIgnoreCase(query, query);
    }
}