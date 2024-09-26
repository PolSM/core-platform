package org.example.infrastructure;

import org.example.builders.ProductPriceBuilder;
import org.example.domain.ProductPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@TestPropertySource("classpath:application-test.properties")
@SpringBootTest
public class JpaProductPriceRepositoryTest {
    private static final int PRODUCT_ID = 35456;
    private static final int BRAND_ID = 1;

    @Autowired
    private JpaProductPriceRepository productPriceRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        jdbcTemplate.execute("TRUNCATE TABLE core_platform.tbl_prices");
    }

    @Test
    public void should_retrieve_a_product() {
        ProductPrice aProductPrice = ProductPriceBuilder.aProductPrice()
                .withStartDate(LocalDateTime.of(2021, 1, 1, 0, 0))
                .withEndDate(LocalDateTime.of(2021, 12, 31, 23, 59))
                .withProductId(PRODUCT_ID)
                .withBrandId(BRAND_ID)
                .build();
        productPriceRepository.save(aProductPrice);

        ProductPrice price = productPriceRepository.findProductPriceByDateAndId(
                LocalDateTime.of(2021, 1, 1, 0, 0),
                PRODUCT_ID,
                BRAND_ID
        );

        Assertions.assertEquals(aProductPrice, price);
    }

    @Test
    public void should_not_retrieve_a_price_if_date_before_start_date() {
        productPriceRepository.save(
                ProductPriceBuilder.aProductPrice()

                        .withStartDate(LocalDateTime.of(2021, 1, 1, 0, 0))
                        .withEndDate(LocalDateTime.of(2021, 12, 31, 23, 59))
                        .build()
        );

        ProductPrice price = productPriceRepository.findProductPriceByDateAndId(
                LocalDateTime.of(2020, 12, 1, 0, 0),
                PRODUCT_ID,
                BRAND_ID
        );

        Assertions.assertNull(price);
    }

    @Test
    public void should_not_retrieve_a_price_if_date_after_start_date() {
        productPriceRepository.save(
                ProductPriceBuilder.aProductPrice()
                        .withStartDate(LocalDateTime.of(2021, 1, 1, 0, 0))
                        .withEndDate(LocalDateTime.of(2021, 12, 31, 23, 59))
                        .build()
        );

        ProductPrice price = productPriceRepository.findProductPriceByDateAndId(
                LocalDateTime.of(2022, 1, 1, 0, 0),
                PRODUCT_ID,
                BRAND_ID
        );

        Assertions.assertNull(price);
    }

}