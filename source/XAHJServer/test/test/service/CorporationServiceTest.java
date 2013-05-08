package test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.evalley.service.CorporationService;

/**
 * Description of this file.
 * User: Xiong Neng
 * Date: 12-9-14
 * Time: 下午3:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CorporationServiceTest {
    @Autowired
    private CorporationService corporationService;

    @Test
    public void selectCorporation() throws Exception {
        corporationService.selectCorporation("f20be4bec1d746fb986a7c78a2387684");
    }

}
