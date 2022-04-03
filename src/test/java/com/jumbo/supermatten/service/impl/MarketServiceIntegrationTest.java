package com.jumbo.supermatten.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.jumbo.supermatten.IntegrationTestBase;
import com.jumbo.supermatten.model.dto.MarketDTO;
import com.jumbo.supermatten.service.MarketService;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketServiceIntegrationTest extends IntegrationTestBase {
    @Autowired
    MarketService marketService;

    @Test
    public  void  testCreate() {
        MarketDTO marketDTO = new MarketDTO();
        marketDTO.setLatitude(1.65650);
        marketDTO.setLongitude(6.54363);
        final MarketDTO created = marketService.createMarket(marketDTO);
        assertEquals(marketDTO.getLatitude(),created.getLatitude());
    }
    @Test
    public  void  testGetAll() {
        MarketDTO marketDTO = new MarketDTO();
        marketDTO.setLatitude(1.65650);
        marketDTO.setLongitude(6.54363);
        final MarketDTO created = marketService.createMarket(marketDTO);
        final List<MarketDTO> all = marketService.getAll();
        assertTrue(all.size()>0);
    }

}
