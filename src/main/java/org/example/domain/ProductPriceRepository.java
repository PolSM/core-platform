package org.example.domain;

import java.time.LocalDateTime;

public interface ProductPriceRepository {
    ProductPrice findProductPriceByDateAndId(LocalDateTime date, Integer productId, Integer brandId);
    void save(ProductPrice productPrice);
}
