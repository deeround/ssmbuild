package com.wang.dao;

import com.wang.pojo.Books;

import java.util.List;

public interface BookMapper {

    int addBook(Books book);

    int deleteBookById(int id);

    int updateBook(Books book);

    Books queryBookById(int id);

    List<Books> queryBooks();

}
