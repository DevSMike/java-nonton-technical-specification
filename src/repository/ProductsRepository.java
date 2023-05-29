package repository;

import model.Product;

import java.util.List;
import java.util.Map;

public interface ProductsRepository {

    boolean addProduct(Product product);

    boolean deleteProduct(Product product);

    Map<String, Product> getAllProducts();
}
