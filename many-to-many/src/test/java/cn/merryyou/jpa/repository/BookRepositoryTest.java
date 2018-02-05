package cn.merryyou.jpa.repository;

import cn.merryyou.jpa.domain.Book;
import cn.merryyou.jpa.domain.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

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

        Publisher publisherA = new Publisher("Publisher One");
        Publisher publisherB = new Publisher("Publisher Two");

        Book bookA = new Book("Book One");
        bookA.setPublishers(new HashSet<Publisher>() {{
            add(publisherA);
            add(publisherB);
        }});

        bookRepository.save(bookA);

    }

    @Test
    public void findAllTest() throws Exception {
        for (Book book : bookRepository.findAll()) {
            log.info(book.toString());
        }
    }
}