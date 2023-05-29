package service;

import model.Product;
import repository.ProductsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public boolean addProduct(Product product) {
        if (productsRepository.getAllProducts().containsKey(product.getId())) {
            return false;
        }
        return productsRepository.addProduct(product);
    }

    @Override
    public boolean deleteProduct(Product product) {
        if (!productsRepository.getAllProducts().containsKey(product.getId())) {
            return false;
        }
        return productsRepository.deleteProduct(product);
    }

    @Override
    public String getName(String id) {
        return productsRepository.getAllProducts().get(id) != null ? productsRepository
                .getAllProducts().get(id).getName() : "";
    }

    @Override
    public List<String> findByName(String name) {
        List<String> productsIds = productsRepository.getAllProducts().values()
                .stream()
                .filter(x -> x.getName().equals(name))
                .map(Product::getId)
                .collect(Collectors.toList());
        if (productsIds.isEmpty()) {
            return new ArrayList<>();
        }
        return productsIds;
    }
}
