package com.wang.controller;

import com.wang.pojo.Books;
import com.wang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/book/list")
    public String list(Model model){

        model.addAttribute("list",bookService.queryBooks());

        return "list";
    }

    @RequestMapping("/book/toAddBook")
    public String toAddBook(int bookId, Model model){
        Books book = new Books();
        if(bookId!=0){
            book = bookService.queryBookById(bookId);
        }
        model.addAttribute("book",book);
        return "toAddBook";
    }

    @RequestMapping(value = "/book/addBook",method = RequestMethod.POST)
    public String addBook(Books book){
        if(book.getBookID() == 0){
            bookService.addBook(book);
        }
        else{
            bookService.updateBook(book);
        }

        return "redirect:/book/list";
    }

    @RequestMapping("/book/deleteBook/{bookId}")
    public String deleteBook(@PathVariable int bookId){
        bookService.deleteBookById(bookId);
        return "redirect:/book/list";
    }

    @RequestMapping("/book/toUploadBookImg")
    public String toUploadBookImg(){
        return "toUploadBookImg";
    }

    @RequestMapping(value = "/book/uploadBookImg",method = RequestMethod.POST)
    public String uploadBookImg(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

        System.out.println("uploadBookImg");

        //获取文件名
        String uploadFileName = file.getOriginalFilename();
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if(!realPath.exists()){
            realPath.mkdirs();
        }

        InputStream is = file.getInputStream();//文件输入流
        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName));

        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();

        return "redirect:/book/list";
    }

}
