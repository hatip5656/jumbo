package com.jumbo.supermatten.service.impl;

import com.jumbo.supermatten.mapper.MarketMapper;
import com.jumbo.supermatten.model.dto.MarketDTO;
import com.jumbo.supermatten.repository.MarketRepository;
import com.jumbo.supermatten.service.HaversineService;
import com.jumbo.supermatten.service.MarketService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketServiceImpl implements MarketService {

    private final MarketRepository marketRepository;
    private final MarketMapper mapper;
    private final HaversineService haversineService;
    private static final int HOTEL_COUNT = 5;

    @Override
    public List<MarketDTO> getAll() {
        return mapper.toListDTO(marketRepository.findAll());
    }

    @Override
    public MarketDTO createMarket(MarketDTO market) {
        return mapper.toDTO(marketRepository.save(mapper.toEntity(market)));
    }
    @Override
    public List<MarketDTO> createMarkets(List<MarketDTO> markets) {
        return markets.stream()
            .map(this::createMarket)
            .collect(Collectors.toList());
    }
    @Override
    public MarketDTO getMarket(Long id) {
        return mapper.toDTO(marketRepository.getById(id));
    }

    @Override
    public void deleteById(Long id) {
        marketRepository.deleteById(id);
    }

    @Override
    public List<MarketDTO> findNearMarkets(Double latitude, Double longitude) {
        final List<MarketDTO> sortedMarkets = getAll().stream()
            .sorted((market1, market2) ->
                compareByDistance(latitude, longitude, market1, market2))
            .collect(Collectors.toList());
        return sortedMarkets.subList(0, HOTEL_COUNT);
    }

    private int compareByDistance(Double latitude, Double longitude, MarketDTO market1, MarketDTO market2) {
        final Integer distance1 = haversineService.getDistance(market1.getLatitude(), market1.getLongitude(), latitude,
            longitude);
        final Integer distance2 = haversineService.getDistance(market2.getLatitude(), market2.getLongitude(), latitude,
            longitude);
        return distance1.compareTo(distance2);
    }


}
