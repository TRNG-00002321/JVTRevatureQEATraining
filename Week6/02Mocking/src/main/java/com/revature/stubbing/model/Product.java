package com.revature.stubbing.model;

import java.math.BigDecimal;

public class Product {
    private String sku;
    private String category;
    private BigDecimal value;

    public Product() {
    }

    public Product(String sku, String category, BigDecimal value) {
        this.sku = sku;
        this.category = category;
        this.value = value;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
