package org.example.builders;

import org.example.domain.ProductPrice;

import java.time.LocalDateTime;

public class ProductPriceBuilder {
    private Integer productId = 35455;
    private Integer brandId = 1;
    private LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 0, 0);
    private LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59);
    private Integer priceList = 1;
    private Integer priority = 0;
    private Float price = 35.50f;
    private String currency = "EUR";

    public static ProductPriceBuilder aProductPrice() {
        return new ProductPriceBuilder();
    }

    public ProductPriceBuilder withProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public ProductPriceBuilder withBrandId(Integer brandId) {
        this.brandId = brandId;
        return this;
    }

    public ProductPriceBuilder withStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public ProductPriceBuilder withEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public ProductPriceBuilder withPriceList(Integer priceList) {
        this.priceList = priceList;
        return this;
    }

    public ProductPriceBuilder withPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public ProductPriceBuilder withPrice(Float price) {
        this.price = price;
        return this;
    }

    public ProductPriceBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public ProductPrice build() {
        return new ProductPrice(productId, brandId, startDate, endDate, priceList, priority, price, currency);
    }
}