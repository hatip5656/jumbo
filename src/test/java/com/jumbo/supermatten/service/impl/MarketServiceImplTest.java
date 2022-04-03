package com.jumbo.supermatten.service.impl;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.jumbo.supermatten.mapper.MarketMapper;
import com.jumbo.supermatten.model.dto.MarketDTO;
import com.jumbo.supermatten.model.entity.Market;
import com.jumbo.supermatten.repository.MarketRepository;
import com.jumbo.supermatten.service.HaversineService;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MarketServiceImplTest {

    @Mock
    MarketRepository marketRepository;
    @Mock
    MarketMapper mapper;
    @Mock
    HaversineService haversineService;
    @InjectMocks
    MarketServiceImpl marketServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() throws Exception {
        when(mapper.toListDTO(any())).thenReturn(List.<MarketDTO>of(new MarketDTO()));

        List<MarketDTO> result = marketServiceImpl.getAll();
        Assert.assertEquals(List.<MarketDTO>of(new MarketDTO()), result);
    }

    @Test
    public void testCreateMarket() throws Exception {
        when(mapper.toEntity(any())).thenReturn(new Market());
        when(mapper.toDTO(any())).thenReturn(new MarketDTO());

        MarketDTO result = marketServiceImpl.createMarket(new MarketDTO());
        Assert.assertEquals(new MarketDTO(), result);
    }

    @Test
    public void testCreateMarkets() throws Exception {
        List<MarketDTO> result = marketServiceImpl.createMarkets(List.<MarketDTO>of(new MarketDTO()));
        verify(marketRepository, times(1)).save(any());
    }

    @Test
    public void testGetMarket() throws Exception {
        when(mapper.toDTO(any())).thenReturn(new MarketDTO());

        MarketDTO result = marketServiceImpl.getMarket(1L);
        Assert.assertEquals(new MarketDTO(), result);
        verify(marketRepository, times(1)).getById(any());

    }

    @Test
    public void testDeleteById() throws Exception {
        marketServiceImpl.deleteById(1L);
    }

    @Test
    public void testFindNearMarkets() throws Exception {
        MarketDTO market1 = new MarketDTO();
        market1.setLatitude(1.65650);
        market1.setLongitude(6.54363);
        MarketDTO market2 = new MarketDTO();
        market2.setLatitude(5.3748);
        market2.setLongitude(6.54363);
        when(mapper.toListDTO(any())).thenReturn(Arrays.<MarketDTO>asList(market1, market2));
        when(haversineService.getDistance(anyDouble(), anyDouble(), anyDouble(), anyDouble())).thenReturn(
            0);

        List<MarketDTO> result = marketServiceImpl.findNearMarkets((double) 1.65650, (double) 6.54363);
        Assert.assertEquals(List.<MarketDTO>of(market1, market2), result);
    }
}

