package com.luce.catalog.model;

public class CatalogItem {
    private String title;
    private String genre;

    public CatalogItem() {}

    public CatalogItem(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
