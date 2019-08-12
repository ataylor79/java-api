package shop.product;

import java.util.*;

public class ProductService {
    private Map<String, Product> products = new HashMap<>();

    public void save(Product product) {
        String key = product.getName().toLowerCase();
        this.products.put(key, product);

    }

    public Optional<Product> getByName(String name) {
        return Optional.ofNullable(this.products.get(name.toLowerCase()));
    }

    public ArrayList<Product> getAll() {
        return new ArrayList<Product>(this.products.values());
    }

}
