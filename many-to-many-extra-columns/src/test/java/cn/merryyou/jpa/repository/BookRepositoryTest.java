package cn.merryyou.jpa.repository;

import cn.merryyou.jpa.domain.Book;
import cn.merryyou.jpa.domain.BookPublisher;
import cn.merryyou.jpa.domain.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

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

    @Autowired
    private PublisherRepository publisherRepository;


    @Test
    @Transactional
    public void manyToManyExtraColumnsTest() throws Exception{
        Book bookA = new Book("Book One");

        Publisher publisherA = new Publisher("Publisher One");

        BookPublisher bookPublisher = new BookPublisher();
        bookPublisher.setBook(bookA);
        bookPublisher.setPublisher(publisherA);
        bookPublisher.setPublishedDate(new Date());
        bookA.getBookPublishers().add(bookPublisher);

        publisherRepository.save(publisherA);
        bookRepository.save(bookA);

        // test
        System.out.println(bookA.getBookPublishers().size());

        // update
        bookA.getBookPublishers().remove(bookPublisher);
        bookRepository.save(bookA);

        // test
        System.out.println(bookA.getBookPublishers().size());
    }

}