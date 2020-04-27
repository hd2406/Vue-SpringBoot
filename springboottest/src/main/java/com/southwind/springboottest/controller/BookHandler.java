package com.southwind.springboottest.controller;

import com.southwind.springboottest.entity.Book;
import com.southwind.springboottest.entity.CountCate;
import com.southwind.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/countAll")
    public long countAll(){
        return bookRepository.count();
    }

    @GetMapping("/countCategory")
    public long countDistinctCategory(){
        return bookRepository.findDistinctCategory();
    }

    @GetMapping("/findHighestRating")
    public float findHighestRating(){
        return bookRepository.findHighestRating();
    }

    @GetMapping("/cat")
    public  List<Object> findCategoryCount(){
        List<List> l = bookRepository.findCategoryCount();
        List<Object> temp = new ArrayList<Object>();
        for (int i = 0; i < l.size(); i++){
            CountCate a = new CountCate();
            List t = l.get(i);
            Object b = t.get(0);
            Object c = t.get(1);

            a.setName(b);
            a.setValue(c);

            temp.add(a);
        }

        return temp;
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return bookRepository.findAll(request);
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }
}
