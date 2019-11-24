package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.log.MyLog;
import com.example.demo.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by mezzsy on 2019-11-17
 * Describe:
 */
@RestController//组件扫描会自动将其注册为Spring应用程序上下文里的一个Bean
//@Controller//使用Controller出现404，无法访问，这里换成RestController
@RequestMapping("/book")//将处理器的方法映射到/book找个路径上
@ConfigurationProperties(prefix = "zzsy")//属性注入
public class ReadingListController {
    private static final String TAG = "ReadingListController";
    private ReadingListRepository mReadingListRepository;

    private String word;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        mReadingListRepository = readingListRepository;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "Book Demo";
    }

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say() {
        return "zzsy say " + word;
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<Book> findAllBooks() {
        return mReadingListRepository.findAll();
    }

    @RequestMapping(value = "/findbyauthor", method = RequestMethod.GET)
    public List<Book> findBooksByAuthor(HttpServletRequest request) {
        String author = request.getParameter("author");
        MyLog.d(TAG, "author = " + author);
        return mReadingListRepository.findByAuthor(author);
    }

    /**
     * 这里不使用@RequestBody会无法自动根据Json数据创建Book对象
     *
     * @param book
     * @return
     */
    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public String addBook(@RequestBody Book book) {
        MyLog.d(TAG, book.toString());
        mReadingListRepository.save(book);
        return "添加成功";
    }

    /**
     * 设置属性
     * @param word
     */
    public void setWord(String word) {
        this.word = word;
    }
}
