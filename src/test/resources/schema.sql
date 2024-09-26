CREATE SCHEMA IF NOT EXISTS core_platform;

DROP TABLE IF EXISTS core_platform.prices;

CREATE TABLE core_platform.prices (
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

CREATE INDEX idx_brand_id ON core_platform.prices (brand_id);
CREATE INDEX idx_product_id ON core_platform.prices (product_id);
CREATE INDEX idx_start_date ON core_platform.prices (start_date);
CREATE INDEX idx_end_date ON core_platform.prices (end_date);