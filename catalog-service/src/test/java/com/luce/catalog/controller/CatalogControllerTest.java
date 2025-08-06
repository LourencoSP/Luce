package com.luce.catalog.controller;

import com.luce.catalog.model.Item;
import com.luce.catalog.service.CatalogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CatalogController.class)
class CatalogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CatalogService catalogService;

    @Test
    void deveRetornarResultadoDaBuscaComStatusOK() throws Exception {
        // Arrange
        String query = "Rei";
        when(catalogService.search(query)).thenReturn(List.of(new Item(1L, "O Rei Leão", "Animação")));

        // Act & Assert
        mockMvc.perform(get("/catalog/search").param("q", query))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("O Rei Leão"));
    }
}