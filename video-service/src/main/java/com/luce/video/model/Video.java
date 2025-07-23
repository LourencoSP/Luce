package com.luce.video.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // 1. Diz ao JPA que esta classe é uma tabela
@Getter
@Setter
@NoArgsConstructor // 2. JPA precisa de um construtor sem argumentos
@AllArgsConstructor
public class Video {

    @Id // 3. Define a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Define que o ID será gerado automaticamente
    private Long id;

    private String title;
    private String genre;

    // Construtor para facilitar a criação sem ID
    public Video(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
}