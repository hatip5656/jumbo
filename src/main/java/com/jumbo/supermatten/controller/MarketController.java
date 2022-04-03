package com.jumbo.supermatten.controller;

import com.jumbo.supermatten.model.dto.MarketDTO;
import com.jumbo.supermatten.service.MarketService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/market")
public class MarketController {

    private final MarketService marketService;

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<MarketDTO> getMarkets() {
        return marketService.getAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MarketDTO createMarket(@RequestBody MarketDTO market) {
        return marketService.createMarket(market);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MarketDTO getMarket(@PathVariable("id") Long id) {
        return marketService.getMarket(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMarket(@PathVariable("id") Long id) {
        marketService.deleteById(id);
    }

    @GetMapping("/find-near-markets")
    @ResponseStatus(HttpStatus.OK)
    public List<MarketDTO> findNearMarkets(@RequestParam("latitude") Double latitude,
        @RequestParam("longitude") Double longitude) {
        return marketService.findNearMarkets(latitude, longitude);
    }

    @PostMapping("/create-markets")
    @ResponseStatus(HttpStatus.CREATED)
    public List<MarketDTO> createMarkets(@RequestBody List<MarketDTO> markets) {
        return marketService.createMarkets(markets);
    }
}
