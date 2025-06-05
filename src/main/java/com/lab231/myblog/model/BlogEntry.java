package com.lab231.myblog.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "blog_entry")
public class BlogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "image_url")
    private String imageUrl;
    private String content;
    @Column(name = "published_date")
    private LocalDate publishedDate;

    public BlogEntry() {
    }

    public BlogEntry(String title, String imageUrl, String content, LocalDate publishedDate) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.content = content;
        this.publishedDate = publishedDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
