package com.ton_corgi_site.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Roman Manko
 * @version 1.0
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String anons;
    private String fullText;
    private Long views;

    public Post(String title, String anons, String fullText) {
    }
}
