package repository;

import model.Product;

import java.util.HashMap;;
import java.util.Map;
import java.util.Optional;

public class ProductsRepositoryImpl implements ProductsRepository {

    private final Map<String, Product> products = new HashMap<>();

    @Override
    public boolean addProduct(Product product) {
        if (products.containsKey(product.getId())) {
            return false;
        }
        Integer productId = getProductId();
        product.setId((++productId).toString());
        products.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean deleteProduct(Product product) {
        products.remove(product.getId());
        return true;
    }

    @Override
    public Map<String, Product> getAllProducts() {
        return products;
    }

    private Integer getProductId () {
        Optional<Integer> maxId =  products.keySet().stream().map(Integer::valueOf).max(Integer::compare);
        return maxId.orElse(0);
    }

}
