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


@PostMapping("/add-new-product")
    public String newproduct(@RequestBody book p )
{
    return service.newbookadd(p);
}
 @PutMapping("/add-book")
 public String addbook(@RequestBody book p )
    {
        return service.addbook(p);
    }
    @GetMapping("/book/{id}")
    public book getBookById(@PathVariable int id){
         return service.getById(id);
    }
    @GetMapping("/book-list")
    public List<book> booklist(){
    return service.list();
    }
    @GetMapping("/number-of-books/{id}")
    public int numberOfBooks(@PathVariable int id){

    return service.countOfbooks(id);
    }
    @PutMapping("/books/{id}")
   public void Update(@PathVariable int id,@RequestBody book BooktoD){
    service.update(id,BooktoD);
}
    @PutMapping("/sell-book/{id}")
    public void sellbook(@PathVariable int id){
        service.sellbook(id);
    }
    @PostMapping("/sell-books")
        public void sellbook(@RequestBody SellDto sellDto){
          service.sellcopies(sellDto);
    }
    @PostMapping("/books")
    public String bookByCategory(@RequestParam String keyword,@RequestParam BookCategory category){
    return service.search(keyword,category);
}
    @PostMapping("/number-of-books")
    public int NoOfBooksByCategory(@RequestParam String keyword,@RequestParam BookCategory category){
        return service.NumberofBooksBySearch(keyword,category);
    }
}
