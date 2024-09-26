package org.example.infrastructure;

import org.example.domain.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface BaseJpaProductPriceRepository extends JpaRepository<ProductPrice, Integer> {
    @Query("SELECT p FROM ProductPrice p WHERE p.startDate <= :date AND p.endDate >= :date AND p.productId = :productId AND p.brandId = :brandId ORDER BY p.priority DESC")
    ProductPrice findProductPriceByDateAndId(@Param("date") LocalDateTime date, @Param("productId") Integer productId, @Param("brandId") Integer brandId);
}