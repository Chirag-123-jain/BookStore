package com.example.project.StoreApplication.service;

import com.example.project.StoreApplication.model.BookCategory;
import com.example.project.StoreApplication.model.SellDto;
import com.example.project.StoreApplication.model.book;
import com.example.project.StoreApplication.repository.bookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookService {

    @Autowired
    bookRepo repo;

    public String newbookadd(book p){
        repo.save(p);
        return "book added";
    }
    public String addbook(book p){
        repo.save(p);
        return "Book Quantity updated";
    }

    public book getById(int id) {
    return repo.findById(id).orElse(new book());
    }

    public List<book> list() {
    return repo.findAll();
    }

    public int countOfbooks(int id) {

    return repo.getNumberOfbook(id);
    }

    public void update(int id, book booktoD) {

        book existingId=repo.findById(id).orElseThrow(()->new RuntimeException());
        System.out.println(existingId);
        System.out.println(booktoD);
        if(booktoD.getAuthor()!=null){
            existingId.setAuthor(booktoD.getAuthor());
        }
        if (booktoD.getTitle()!=null){
            existingId.setTitle(booktoD.getTitle());
        }
        if(booktoD.getCategory()!=null){
            existingId.setCategory(booktoD.getCategory());
        }
        if(booktoD.getPrice()>=0){
            existingId.setPrice(booktoD.getPrice());
        }
        if(booktoD.getTotal_count()>=0){
            existingId.setTotal_count(booktoD.getTotal_count());
        }
        if(booktoD.getSold()>=0){
            existingId.setSold(booktoD.getSold());
        }
        repo.save(existingId);
    }

    public void sellbook(int id) {
        book existingId=repo.findById(id).orElseThrow(()->new RuntimeException());
        if (existingId.getTotal_count()!=0) {
            existingId.setSold(existingId.getSold() + 1);
            existingId.setTotal_count(existingId.getTotal_count() - 1);
        }else {
            System.out.println("Out of Stock");
        }
        repo.save(existingId);
    }

    public void sellcopies(SellDto sellDto) {
        int id=sellDto.getId();
        int copies=sellDto.getCopies();
        book existingId=repo.findById(id).orElseThrow(()->new RuntimeException());
        if(existingId.getTotal_count()>=copies){
          existingId.setSold(existingId.getSold()+copies);
          existingId.setTotal_count(existingId.getTotal_count()-copies);
          repo.save(existingId);
        }else {
            System.out.println("Out of stock");
        }

    }

    public String search(String keyword, BookCategory category) {
return repo.getBookByCategoryandandTitle(keyword,category);

    }

    public Integer NumberofBooksBySearch(String keyword, BookCategory category) {
    return repo.getNumberOfBookByCategoryandandTitle(keyword,category);
    }
}
//String author;
//String title;
//String category;
//int price;
//int total_count;
//int sold;

