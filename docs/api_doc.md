### API Documentation

#### GET /price

**Description:**
Retrieves the price of a product for a given date, product ID, and brand ID.

**Request Parameters:**
- \`date\` (required): The date for which the price is requested. Format: \`yyyy-MM-dd'T'HH:mm:ss\`.
- \`product_id\` (required): The unique identifier of the product.
- \`brand_id\` (required): The unique identifier of the brand.

**Response:**
- **200**: Successfully retrieved the price.
    - Body:
      ```json
      {
        "product_id": 35455,
        "brand_id": 1,
        "price_list": 1,
        "start_date": "2020-06-14T00:00:00",
        "end_date": "2020-12-31T23:59:59",
        "price": 35.50,
        "currency": "EUR"
      }
      ```
- **400**: Invalid request parameters.
- **404**: No price found for the given parameters.

**Example Request:**
```sh
curl -X GET "http://localhost:8080/price?date=2020-06-14T10:00:00&product_id=35455&brand_id=1"