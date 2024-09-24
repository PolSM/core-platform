package org.example.domain;

import java.time.LocalDateTime;

public interface ProductPriceRepository {
    ProductPrice findProductPrice(LocalDateTime date, Integer productId, Integer brandId);
}
