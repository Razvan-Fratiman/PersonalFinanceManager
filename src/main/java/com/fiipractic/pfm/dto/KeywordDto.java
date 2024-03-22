package com.fiipractic.pfm.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class KeywordDto {
    private Long id;

    private String value;

    private Long parent;
}
