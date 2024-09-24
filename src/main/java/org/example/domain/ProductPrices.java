package org.example.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductPrices {
    private Long productId;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Integer priority;
    private BigDecimal price;
    private String currency;
}