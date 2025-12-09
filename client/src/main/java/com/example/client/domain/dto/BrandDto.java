package com.example.client.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BrandDto extends BaseDto {
    private String name;
}
