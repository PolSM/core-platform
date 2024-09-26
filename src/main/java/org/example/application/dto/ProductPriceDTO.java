package org.example.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProductPriceDTO {
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("brand_id")
    private int brandId;
    @JsonProperty("start_date")
    private LocalDateTime startDate;
    @JsonProperty("end_date")
    private LocalDateTime endDate;
    @JsonProperty("price")
    private float price;
    @JsonProperty("currency")
    private String currency;

    public ProductPriceDTO() {
    }

    public ProductPriceDTO(
            Integer productId,
            Integer brandId,
            LocalDateTime startDate,
            LocalDateTime endDate,
            Float price,
            String currency
    ) {
        this.productId = productId;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPriceDTO that = (ProductPriceDTO) o;
        return Objects.equals(productId, that.productId) && Objects.equals(brandId, that.brandId) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(price, that.price) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, brandId, startDate, endDate, price, currency);
    }

    public String toString() {
        return "ProductPriceDTO{" +
                "productId=" + productId +
                ", brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}