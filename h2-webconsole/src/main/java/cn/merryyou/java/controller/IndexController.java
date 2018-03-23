package cn.merryyou.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/3/23.
 *
 * @author zlf
 * @since 1.0
 */
@RestController
public class IndexController {

    @GetMapping("/")
    String index() {
        return "Spring Boot - Spring Data JPA - H2 Web Console";
    }
}
