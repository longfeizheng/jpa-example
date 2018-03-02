package cn.merryyou.jpa.repository;

import cn.merryyou.jpa.domain.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created on 2018/3/2.
 *
 * @author zlf
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testSave(){
        Address address = new Address();
        address.setCity("beijing");
        address.setState("02");
        address.setStreet("street");
        address.setZip("aa.zip");
        Address result = addressRepository.save(address);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getId());
        Assert.assertTrue(result.getId()>=1000);
    }
}