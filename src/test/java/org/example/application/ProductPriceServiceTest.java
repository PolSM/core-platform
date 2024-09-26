package org.example.application;

import org.example.application.dto.ProductPriceDTO;
import org.example.builders.ProductPriceBuilder;
import org.example.domain.ProductPrice;
import org.example.infrastructure.JpaProductPriceRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@TestPropertySource("classpath:application-test.properties")
@ExtendWith(MockitoExtension.class)
public class ProductPriceServiceTest {

    private static final LocalDateTime DATE = LocalDateTime.of(2020, 12, 1, 0, 0);
    private static final Integer PRODUCT_ID = 35456;
    private static final Integer BRAND_ID = 1;

    @Mock
    private JpaProductPriceRepository productPriceRepository;

    @InjectMocks
    private ProductPriceService productPriceService;

    @BeforeAll
    public static void setUp() {
        MockitoAnnotations.openMocks(ProductPriceServiceTest.class);
    }

    @Test
    public void should_get_price_formatted_given_a_date_productId_and_brandId() {
        ProductPrice productPrice = ProductPriceBuilder.aProductPrice()
                .withProductId(PRODUCT_ID)
                .withBrandId(BRAND_ID)
                .withStartDate(DATE)
                .withEndDate(DATE.plusDays(1))
                .build();
        when(productPriceRepository.findProductPriceByDateAndId(DATE, PRODUCT_ID, BRAND_ID)).thenReturn(productPrice);

        ProductPriceDTO price = productPriceService.findProductPriceByDateAndId(DATE, PRODUCT_ID, BRAND_ID);

        ProductPriceDTO expectedPrice = new ProductPriceDTO(
                PRODUCT_ID,
                BRAND_ID,
                DATE,
                DATE.plusDays(1),
                35.50f,
                "EUR"
        );
        assertEquals(expectedPrice, price);
    }

    @Test
    public void should_return_null_given_when_price_does_not_exist() {

        when(productPriceRepository.findProductPriceByDateAndId(DATE, PRODUCT_ID, BRAND_ID)).thenReturn(null);

        ProductPriceDTO price = productPriceService.findProductPriceByDateAndId(DATE, PRODUCT_ID, BRAND_ID);

        assertNull(price);
    }
}