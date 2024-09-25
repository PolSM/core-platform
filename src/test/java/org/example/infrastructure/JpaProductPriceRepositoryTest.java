package org.example.infrastructure;

import org.example.domain.ProductPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class JpaProductPriceRepositoryTest {

    @Autowired
    private JpaProductPriceRepository productPriceRepository;


    @Test
    public void should_retrieve_a_product() {
        ProductPrice newPrice = new ProductPrice(
                35456,
                1,
                LocalDateTime.of(2021, 1, 1, 0, 0),
                LocalDateTime.of(2021, 12, 31, 23, 59),
                2,
                1,
                45.50f,
                "USD"
        );
        productPriceRepository.save(newPrice);

        ProductPrice price = productPriceRepository.findProductPriceByDateAndId(
                LocalDateTime.of(2021, 1, 1, 0, 0),
                35456,
                1
        );

        ProductPrice expectedPrice = new ProductPrice(
                35456,
                1,
                LocalDateTime.of(2021, 1, 1, 0, 0),
                LocalDateTime.of(2021, 12, 31, 23, 59),
                2,
                1,
                45.50f,
                "USD"
        );
        Assertions.assertEquals(expectedPrice, price);
    }
}