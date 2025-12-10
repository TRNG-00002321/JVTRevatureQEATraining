package com.revature.stubbing.service;

public interface InventoryService {
    boolean checkStock(String sku, int quantity);
    void reserveStock(String sku, int quantity);
    void releaseStock(String sku, int quantity);
}
