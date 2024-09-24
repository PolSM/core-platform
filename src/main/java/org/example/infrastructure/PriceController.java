package org.example.infrastructure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController {

    @GetMapping("/price")
    public Float getPrice(
            @RequestParam("date") LocalDateTime date,
            @RequestParam("product_id") Integer productId,
            @RequestParam("brand_id") Integer brandId) {
        return 20.0f;
    }

}
