package com.jumbo.supermatten.mapper;

import com.jumbo.supermatten.model.dto.MarketDTO;
import com.jumbo.supermatten.model.entity.Market;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MarketMapper extends BaseMapper<Market, MarketDTO> {
}
