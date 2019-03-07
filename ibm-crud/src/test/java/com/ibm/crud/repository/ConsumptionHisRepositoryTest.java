package com.ibm.crud.repository;

import com.ibm.crud.domain.ConsumptionHis;
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
public class ConsumptionHisRepositoryTest {

    @Autowired
    private ConsumptionHisRepository consumptionHisRepository;

    /**
     * find by all  Banking Advisors by Consumption history id
     * @throws Exception
     */
    @Test
    public void findOneTest() throws Exception {
        ConsumptionHis consumptionHis = consumptionHisRepository.findOne(1);
        log.info(consumptionHis.toString());
        Assert.assertNotNull(consumptionHis);
        Assert.assertTrue(1 == consumptionHis.getId());
    }

}