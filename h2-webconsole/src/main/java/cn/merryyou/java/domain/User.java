package cn.merryyou.java.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created on 2018/3/23.
 *
 * @author zlf
 * @since 1.0
 */
@Entity
@Table(name = "t_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
