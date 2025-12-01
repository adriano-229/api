package com.example.server.domain.mapper;

import com.example.server.domain.dto.ProductDto;
import com.example.server.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductDto> {

    @Mapping(source = "brand.id", target = "brandId")
    ProductDto toDto(Product entity);

    @Mapping(target = "brand", ignore = true)
    Product toEntity(ProductDto dto);

}
