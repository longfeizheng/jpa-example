package cn.merryyou.jpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
@Entity
@Data
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_detail_id")
//    @Lazy(false)
    private BookDetail bookDetail;

    public Book() {
    }

    public Book(String name, BookDetail bookDetail) {
        this.name = name;
        this.bookDetail = bookDetail;
    }
}
