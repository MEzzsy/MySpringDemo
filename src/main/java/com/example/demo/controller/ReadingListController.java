package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by mezzsy on 2019-11-17
 * Describe:
 */
@Controller//组件扫描会自动将其注册为Spring应用程序上下文里的一个Bean
@RequestMapping("/book")//将处理器的方法映射到/book找个路径上
public class ReadingListController {
    private ReadingListRepository mReadingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        mReadingListRepository = readingListRepository;
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public List<Book> findBooksByAuthor(HttpServletRequest request) {
        String author = request.getParameter("author");
        return mReadingListRepository.findByAuthor(author);
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public String addBook(Book book) {
        mReadingListRepository.save(book);
        return "添加成功";
    }
}
