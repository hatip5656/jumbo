package com.jumbo.supermatten.mapper;

import java.util.List;


public interface BaseMapper<Entity, DTO> {

  Entity toEntity(DTO domainObject);

  List<Entity> toListEntity(List<DTO> entities);

  DTO toDTO(Entity entity);

  List<DTO> toListDTO(List<Entity> entities);

}
