package com.example.server.domain.mapper;

import com.example.server.domain.dto.BaseDto;
import com.example.server.domain.entity.BaseEntity;

import java.util.List;

public interface BaseMapper<E extends BaseEntity, D extends BaseDto> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDtoList(List<E> entities);
}
