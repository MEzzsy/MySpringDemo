package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mezzsy on 2019-11-17
 * Describe:
 */
//通过扩展JpaRepository，ReadingListRepository直接继承了18个执行常用持久化操作的方法。
//两个范型参数表示仓库操作的领域对象类型以及ID属性
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
}
