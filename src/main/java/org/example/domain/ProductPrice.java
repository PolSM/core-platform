package org.example.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "prices", schema = "core_platform")
public class ProductPrice {
    @Id
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "brand_id")
    private Integer brandId;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "price_list")
    private Integer priceList;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "price")
    private Float price;
    @Column(name = "currency")
    private String currency;

    public ProductPrice() {
    }

    public ProductPrice(
            Integer productId,
            Integer brandId,
            LocalDateTime startDate,
            LocalDateTime endDate,
            Integer priceList,
            Integer priority,
            Float price,
            String currency
    ) {
        this.productId = productId;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Float getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "productId=" + productId +
                ", brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", priority=" + priority +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPrice that = (ProductPrice) o;
        return Objects.equals(productId, that.productId) && Objects.equals(brandId, that.brandId) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(priceList, that.priceList) && Objects.equals(priority, that.priority) && Objects.equals(price, that.price) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, brandId, startDate, endDate, priceList, priority, price, currency);
    }
}