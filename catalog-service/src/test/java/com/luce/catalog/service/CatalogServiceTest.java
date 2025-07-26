package com.luce.catalog.service;

import com.luce.catalog.model.Item;
import com.luce.catalog.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatalogServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private CatalogService catalogService;

    @Test
    void deveRetornarItensQuandoBuscaEncontraResultados() {
        // Arrange
        String query = "Ação";
        when(itemRepository.findByTitleContainingIgnoreCaseOrGenreContainingIgnoreCase(query, query))
                .thenReturn(List.of(new Item(1L, "Batman", "Ação")));

        // Act
        List<Item> resultado = catalogService.search(query);

        // Assert
        assertEquals(1, resultado.size());
        assertEquals("Batman", resultado.get(0).getTitle());
    }
}