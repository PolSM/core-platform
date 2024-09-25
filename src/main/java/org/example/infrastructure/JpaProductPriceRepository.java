package org.example.infrastructure;

import org.example.domain.ProductPrice;
import org.example.domain.ProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JpaProductPriceRepository implements ProductPriceRepository {

    private final BaseJpaProductPriceRepository base;

    @Autowired
    public JpaProductPriceRepository(BaseJpaProductPriceRepository base) {
        this.base = base;
    }

    @Override
    public ProductPrice findProductPriceByDateAndId(LocalDateTime date, Integer productId, Integer brandId) {
        return base.findProductPriceByDateAndId(date, productId, brandId);
    }

    @Override
    public void save(ProductPrice productPrice) {
        base.save(productPrice);
    }
}