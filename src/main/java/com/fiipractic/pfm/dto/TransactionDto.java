package com.fiipractic.pfm.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionDto {
    private Long id;

    private Date date;

    private BigDecimal amount;

    private Long categoryId;

    private Long keywordId;

    private Long parentId;

    private String description;
}
