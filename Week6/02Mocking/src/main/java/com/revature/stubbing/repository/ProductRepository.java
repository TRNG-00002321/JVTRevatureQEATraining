package com.revature.stubbing.repository;

import com.revature.stubbing.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(String sku);
    List<Product> findByCategory(String category);
}
