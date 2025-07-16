package com.luce.catalog.controller;

import com.luce.catalog.model.CatalogItem;
import com.luce.catalog.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) {

        this.service = service;
    }

    @GetMapping("/search")
    public List<CatalogItem> search(@RequestParam String q) {

        return service.search(q);
    }
}
