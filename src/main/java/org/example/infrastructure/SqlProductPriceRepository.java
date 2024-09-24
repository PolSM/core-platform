package org.example.infrastructure;

import org.example.domain.ProductPrice;
import org.example.domain.ProductPriceRepository;

import java.time.LocalDateTime;

public class SqlProductPriceRepository implements ProductPriceRepository {
    @Override
    public ProductPrice findProductPrice(LocalDateTime date, Integer productId, Integer brandId) {
        return null;
    }
}
