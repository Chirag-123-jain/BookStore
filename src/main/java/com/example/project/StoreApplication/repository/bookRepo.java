package com.example.project.StoreApplication.repository;

import com.example.project.StoreApplication.model.BookCategory;
import com.example.project.StoreApplication.model.book;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface bookRepo extends JpaRepository<book,Integer> {

    @Query("SELECT b.total_count FROM book b WHERE b.id = :id")
    public int getNumberOfbook(@Param("id") int id);
    @Query("SELECT b.title FROM book AS b WHERE b.category= :category AND b.author= :keyword")
    public String getBookByCategoryandandTitle(@Param("keyword") String keyword,@Param("category") BookCategory category);
    @Query("SELECT b.total_count FROM book AS b WHERE b.category= :category AND b.author= :keyword")
    public Integer getNumberOfBookByCategoryandandTitle(@Param("keyword") String keyword, @Param("category") BookCategory category);
}

