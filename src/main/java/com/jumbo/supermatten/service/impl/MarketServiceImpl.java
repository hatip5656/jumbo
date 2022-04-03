package com.jumbo.supermatten.service.impl;

import com.jumbo.supermatten.mapper.MarketMapper;
import com.jumbo.supermatten.model.dto.MarketDTO;
import com.jumbo.supermatten.repository.MarketRepository;
import com.jumbo.supermatten.service.HaversineService;
import com.jumbo.supermatten.service.MarketService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames={"market"})
public class MarketServiceImpl implements MarketService {

    private final MarketRepository marketRepository;
    private final MarketMapper mapper;
    private final HaversineService haversineService;
    private static final int HOTEL_COUNT = 5;

    @Override
    @Cacheable(value="markets", key="'markets'")
    public List<MarketDTO> getAll() {
        return mapper.toListDTO(marketRepository.findAll());
    }

    @Override
    @CacheEvict(value="markets", key="'markets'")
    public MarketDTO createMarket(MarketDTO market) {
        return mapper.toDTO(marketRepository.save(mapper.toEntity(market)));
    }
    @Override
    @CacheEvict(value="markets", key="'markets'")
    public List<MarketDTO> createMarkets(List<MarketDTO> markets) {
        return markets.stream()
            .map(this::createMarket)
            .collect(Collectors.toList());
    }
    @Override
    @Cacheable(value="market", key="#id")
    public MarketDTO getMarket(Long id) {
        return mapper.toDTO(marketRepository.getById(id));
    }

    @Override
    @Caching(evict = {@CacheEvict(value="markets", key="'markets'"), @CacheEvict(value="market", key="#id") })
    public void deleteById(Long id) {
        marketRepository.deleteById(id);
    }

    @Override
    public List<MarketDTO> findNearMarkets(Double latitude, Double longitude) {
        final List<MarketDTO> sortedMarkets = getAll().stream()
            .sorted((market1, market2) ->
                compareByDistance(latitude, longitude, market1, market2))
            .collect(Collectors.toList());
        if (sortedMarkets.size() > 5) {
            return sortedMarkets.subList(0, HOTEL_COUNT);
        } else {
            return sortedMarkets;
        }
    }

    private int compareByDistance(Double latitude, Double longitude, MarketDTO market1, MarketDTO market2) {
        final Integer distance1 = haversineService.getDistance(market1.getLatitude(), market1.getLongitude(), latitude,
            longitude);
        final Integer distance2 = haversineService.getDistance(market2.getLatitude(), market2.getLongitude(), latitude,
            longitude);
        return distance1.compareTo(distance2);
    }


}
