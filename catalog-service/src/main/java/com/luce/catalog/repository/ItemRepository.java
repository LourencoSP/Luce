package com.luce.catalog.repository;

import com.luce.catalog.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByTitleContainingIgnoreCaseOrGenreContainingIgnoreCase(String title, String genre);
}