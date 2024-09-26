package org.example.infrastructure;

import org.example.application.dto.ProductPriceDTO;
import org.example.infrastructure.tools.JsonConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class PriceControllerTest {

    private static final int PRODUCT_ID = 35455;
    private static final int BRAND_ID = 1;
    public static final String CURRENCY = "EUR";

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @ParameterizedTest
    @MethodSource("priceProvider")
    public void should_return_OK_given_prices(String dateTime, ProductPriceDTO productPriceDTO) throws Exception {
        LocalDateTime date = LocalDateTime.parse(dateTime);

        mockMvc.perform(get("/price")
                        .param("date", date.toString())
                        .param("product_id", "35455")
                        .param("brand_id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string(JsonConverter.convertToJson(productPriceDTO)));
    }

    @ParameterizedTest
    @MethodSource("priceNotFoundProvider")
    public void should_return_KO_when_not_found(String dateTime, ProductPriceDTO productPriceDTO) throws Exception {
        LocalDateTime date = LocalDateTime.parse(dateTime);

        mockMvc.perform(get("/price")
                        .param("date", date.toString())
                        .param("product_id", "35455")
                        .param("brand_id", "1"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Price not found"));
    }

    static Stream<Arguments> priceProvider() {
        return Stream.of(
                Arguments.of("2020-06-14T10:00:00", new ProductPriceDTO(PRODUCT_ID, BRAND_ID, LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 35.50f, CURRENCY)),
                Arguments.of("2020-06-14T16:00:00", new ProductPriceDTO(PRODUCT_ID, BRAND_ID, LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"), 25.45f, CURRENCY)),
                Arguments.of("2020-06-15T10:00:00", new ProductPriceDTO(PRODUCT_ID, BRAND_ID, LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"), 30.50f, CURRENCY)),
                Arguments.of("2020-06-15T16:00:00", new ProductPriceDTO(PRODUCT_ID, BRAND_ID, LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 38.95f, CURRENCY))
        );
    }

    static Stream<Arguments> priceNotFoundProvider() {
        return Stream.of(
                Arguments.of("2019-12-31T23:59:59", new ProductPriceDTO(PRODUCT_ID, BRAND_ID, LocalDateTime.parse("2020-01-01T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 0.0f, CURRENCY)),
                Arguments.of("2021-01-01T00:00:00", new ProductPriceDTO(PRODUCT_ID, BRAND_ID, LocalDateTime.parse("2020-01-01T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 0.0f, CURRENCY))
        );
    }
}