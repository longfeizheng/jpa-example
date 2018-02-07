package cn.merryyou.jpa.repository;

import cn.merryyou.jpa.domain.Book;
import cn.merryyou.jpa.domain.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

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
    public void saveTest1() throws Exception{

    }

    @Test
    public void findPublisherTest() throws Exception{
        Publisher publisher = publisherRepository.findOne(24);
        Set<Book> books = publisher.getBooks();
        for(Book book: books){
            log.info(book.getName()+"..."+book.getId());
        }
        Assert.assertNotNull(publisher);
        Assert.assertNotNull(publisher.getName());
    }

    @Test
    public void findAllTest() throws Exception {
        for (Book book : bookRepository.findAll()) {
            log.info(book.toString());
        }
    }

    @Test
    public void findBookTest() throws Exception{
        Book book = bookRepository.findOne(16);
        Set<Publisher> publishers = book.getPublishers();
        for(Publisher publisher: publishers){
            log.info(publisher.getName()+"..."+publisher.getId());
        }
        Assert.assertNotNull(book);
        Assert.assertNotNull(book.getName());
    }
}