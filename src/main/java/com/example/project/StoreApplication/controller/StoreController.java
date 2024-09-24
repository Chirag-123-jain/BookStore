package com.example.project.StoreApplication.controller;

import com.example.project.StoreApplication.model.BookCategory;
import com.example.project.StoreApplication.model.SellDto;
import com.example.project.StoreApplication.model.book;
import com.example.project.StoreApplication.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

@Autowired
bookService service;


@PostMapping("/api/add-new-book")
    public String newproduct(@RequestBody book p )
{
    return service.newbookadd(p);
}
 @PutMapping("api/add-book")
 public String addbook(@RequestBody book p )
    {
        return service.addbook(p);
    }
    @GetMapping("/api/book/{id}")
    public book getBookById(@PathVariable int id){
         return service.getById(id);
    }
    @GetMapping("/api/book-list")
    public List<book> booklist(){
    return service.list();
    }
    @GetMapping("/api/number-of-books/{id}")
    public int numberOfBooks(@PathVariable int id){

    return service.countOfbooks(id);
    }
    @PutMapping("/api/books/{id}")
   public void Update(@PathVariable int id,@RequestBody book BooktoD){
    service.update(id,BooktoD);
}
    @PutMapping("/api/sell-book/{id}")
    public void sellbook(@PathVariable int id){
        service.sellbook(id);
    }
    @PostMapping("/api/sell-books")
        public void sellbook(@RequestBody SellDto sellDto){
          service.sellcopies(sellDto);
    }
    @PostMapping("/api/books")
    public String bookByCategory(@RequestParam String keyword,@RequestParam BookCategory category){
    return service.search(keyword,category);
}
    @PostMapping("/api/number-of-books")
    public int NoOfBooksByCategory(@RequestParam String keyword,@RequestParam BookCategory category){
        return service.NumberofBooksBySearch(keyword,category);
    }
}
