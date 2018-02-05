package cn.merryyou.jpa.repository;

import cn.merryyou.jpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
}
