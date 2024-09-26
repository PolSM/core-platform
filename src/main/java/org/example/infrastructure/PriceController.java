package org.example.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.application.ProductPriceService;
import org.example.application.dto.ProductPriceDTO;
import org.example.infrastructure.tools.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController {

    @Autowired
    private ProductPriceService productPriceService;

    @GetMapping("/price")
    public ResponseEntity getPrice(
            @RequestParam("date") LocalDateTime date,
            @RequestParam("product_id") Integer productId,
            @RequestParam("brand_id") Integer brandId) {
        ProductPriceDTO productPriceDTO = productPriceService.findProductPriceByDateAndId(date, productId, brandId);
        try {
            String json = JsonConverter.convertToJson(productPriceDTO);
            return ResponseEntity.ok(json);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(404).body("Price not found");
        }
    }
}
