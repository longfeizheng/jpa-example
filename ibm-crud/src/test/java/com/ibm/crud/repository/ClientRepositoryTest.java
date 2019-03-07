package com.ibm.crud.repository;

import com.ibm.crud.domain.Client;
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
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;


    /**
     * find by all cards and Consumption history by client id
     * @throws Exception
     */
    @Test
    public void findOneTest() throws Exception {
        Client client = clientRepository.findOne(1);
        log.info(client.toString());
        Assert.assertNotNull(client);
        Assert.assertTrue(1 == client.getId());
    }
}