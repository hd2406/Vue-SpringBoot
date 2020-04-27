package com.southwind.springboottest.repository;

import com.southwind.springboottest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    long count();

    @Query("SELECT COUNT(DISTINCT category) FROM Book")
    long findDistinctCategory();

    @Query("SELECT MAX(rating) FROM Book")
    float findHighestRating();

    @Query("SELECT b.category, count(*) FROM Book b GROUP BY b.category")
    List<List> findCategoryCount();

}

