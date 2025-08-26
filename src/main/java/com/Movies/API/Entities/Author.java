package com.Movies.API.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;

    @Column(name = "first_name")
    private String firstName;

    private String lastName;
    private String language;

    @OneToOne(mappedBy = "writer")
    @JsonBackReference   // Prevents infinite loop (backward side)
    private Movies movies;

    public Author() {}

    public Author(int authorId, String firstName, String lastName, String language) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
    }

    // getters & setters
    public int getAuthorId() { return authorId; }
    public void setAuthorId(int authorId) { this.authorId = authorId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public Movies getMovies() { return movies; }
    public void setMovies(Movies movies) { this.movies = movies; }
}
