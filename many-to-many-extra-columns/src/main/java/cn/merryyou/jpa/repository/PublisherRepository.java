package cn.merryyou.jpa.repository;

import cn.merryyou.jpa.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
}
