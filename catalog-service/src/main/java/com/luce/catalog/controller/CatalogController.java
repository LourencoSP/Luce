package com.luce.catalog.controller;

import com.luce.catalog.model.Item; // Alterado de CatalogItem para Item
import com.luce.catalog.service.CatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public List<Item> search(@RequestParam String q) { // Alterado de CatalogItem para Item
        return service.search(q);
    }
}