# Database Documentation

## Schema: `core_platform`

### Table: `tbl_prices`
#### Columns:
- **brand_id**: An integer that represents a unique identifier for the brand.
- **start_date**: A timestamp indicating the start date of the price validity.
- **end_date**: A timestamp indicating the end date of the price validity.
- **price_list**: An integer that corresponds to the specific rate applied to a product.
- **product_id**: An integer that uniquely identifies each product.
- **priority**: An integer used to resolve conflicts when two rates overlap in date ranges.
- **price**: A decimal value representing the final sale price of the product.
- **currency**: A three-character string storing the ISO code of the currency.

#### Primary Key:
- Composite key consisting of `product_id`, `brand_id`, `start_date`, and `end_date`.

#### SQL Definition:
```sql
CREATE SCHEMA IF NOT EXISTS core_platform;

CREATE TABLE core_platform.tbl_prices (
    brand_id INTEGER NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price_list INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    priority INTEGER NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    PRIMARY KEY (product_id, brand_id, start_date, end_date)
);