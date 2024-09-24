package com.example.project.StoreApplication.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String author;
    String title;
  @Enumerated(EnumType.STRING) // Stores enum as string in the database
    BookCategory category;
    int price;
    int total_count;
    int sold;
}
