package com.jumbo.supermatten.service;

import com.jumbo.supermatten.model.dto.MarketDTO;
import java.util.List;

public interface MarketService {

    List<MarketDTO> getAll();

    MarketDTO createMarket(MarketDTO market);

    MarketDTO getMarket(Long id);

    void deleteById(Long id);

    List<MarketDTO> findNearMarkets(Double latitude, Double longitude);

    List<MarketDTO> createMarkets(List<MarketDTO> markets);
}
