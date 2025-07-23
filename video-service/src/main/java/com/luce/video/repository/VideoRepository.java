package com.luce.video.repository;

import com.luce.video.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    // O Spring Data JPA irá implementar todos os métodos CRUD por nós!
}