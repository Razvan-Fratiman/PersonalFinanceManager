package com.fiipractic.pfm.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CategoryDto {
    private Long id;

    private Long parentId;

    private String value;
}
