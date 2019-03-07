package com.ibm.crud.repository;

import com.ibm.crud.domain.Card;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;


    @Test
    public void findOneTest() throws Exception {
        Card card = cardRepository.findOne(1);
        log.info(card.toString());
        Assert.assertNotNull(card);
        Assert.assertTrue(1 == card.getId());
    }

}