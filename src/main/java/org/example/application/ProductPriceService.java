package org.example.application;

import org.example.application.dto.ProductPriceDTO;
import org.example.domain.ProductPrice;
import org.example.infrastructure.JpaProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductPriceService {

    private final JpaProductPriceRepository productPriceRepository;

    @Autowired
    public ProductPriceService(JpaProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }

    public ProductPriceDTO findProductPriceByDateAndId(LocalDateTime date, Integer productId, Integer brandId) {
        ProductPrice productPrice = productPriceRepository.findProductPriceByDateAndId(date, productId, brandId);
        return convertToDTO(productPrice);
    }

    private ProductPriceDTO convertToDTO(ProductPrice productPrice) {
        if (productPrice == null) {
            return null;
        }
        return new ProductPriceDTO(
                productPrice.getProductId(),
                productPrice.getBrandId(),
                productPrice.getStartDate(),
                productPrice.getEndDate(),
                productPrice.getPrice(),
                productPrice.getCurrency()
        );
    }
}