package service;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static ProductManager instance;
    private List<Product> products;

    private ProductManager() {
        products = new ArrayList<>();
        // Inicializa productos si es necesario
    }

    public static synchronized ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        // Actualiza el producto en la lista, si es necesario
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }
}
