package service;

import model.Product;

import java.util.List;

public interface ProductsService {

    boolean addProduct(Product product);

    boolean deleteProduct(Product product);

    String getName(String id);

    List<String> findByName(String name);
}
