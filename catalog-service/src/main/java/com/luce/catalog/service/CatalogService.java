package main.java.com.luce.catalog.service;

import com.luce.catalog.model.CatalogItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogService {
    private final List<CatalogItem> catalog = List.of(
        new CatalogItem("A Origem", "Sci-Fi"),
        new CatalogItem("O Rei Leão", "Animação"),
        new CatalogItem("Batman", "Ação")
    );

    public List<CatalogItem> search(String query) {
        return catalog.stream()
                .filter(item -> item.getTitle().toLowerCase().contains(query.toLowerCase())
                             || item.getGenre().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
