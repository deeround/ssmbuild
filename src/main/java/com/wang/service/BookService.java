package com.wang.service;

import com.wang.pojo.Books;

import java.util.List;

public interface BookService {

    int addBook(Books book);

    int deleteBookById(int id);

    int updateBook(Books book);

    Books queryBookById(int id);

    List<Books> queryBooks();

}
