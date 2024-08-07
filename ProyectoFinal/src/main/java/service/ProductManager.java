package service;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    // Singleton para la gestión de productos
    private static ProductManager instance;

    private ProductManager() {}

    public static ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void updateProduct(Product product) {
        // Implementación para actualizar el producto
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }
}
