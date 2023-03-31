CREATE TABLE currency (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    symbol VARCHAR(255),
    country VARCHAR(255),
    quotation DECIMAL

)