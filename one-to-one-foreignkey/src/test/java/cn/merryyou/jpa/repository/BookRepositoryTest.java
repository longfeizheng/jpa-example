package cn.merryyou.jpa.repository;

import cn.merryyou.jpa.domain.Book;
import cn.merryyou.jpa.domain.BookDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveTest() throws Exception {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Book one", new BookDetail(1)));
        books.add(new Book("Book two", new BookDetail(2)));
        books.add(new Book("Book three", new BookDetail(3)));
        List<Book> bookList = bookRepository.save(books);
        Assert.assertNotNull(bookList);
        Assert.assertEquals(3, bookList.size());
    }

    @Test
    public void findBooksTest() throws Exception{
        List<Book> books = bookRepository.findAll();
        for (Book book: books) {
            log.info(book.toString());
        }
    }

}