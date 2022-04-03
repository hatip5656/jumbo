package com.jumbo.supermatten.mapper;

import java.util.List;

/**
 * @author Burak Naroğlu
 */

public interface BaseMapper<Entity, DTO> {

  Entity toEntity(DTO domainObject);

  List<Entity> toListEntity(List<DTO> entities);

  DTO toDTO(Entity entity);

  List<DTO> toListDTO(List<Entity> entities);

}
