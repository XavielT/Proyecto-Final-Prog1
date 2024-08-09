package view;

import model.Product;
import service.ProductManager;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProductTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Nombre", "Marca", "Categoría", "Precio", "Cantidad"};
    private List<Product> products;

    public ProductTableModel() {
        products = new ArrayList<>(ProductManager.getInstance().getAllProducts());
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        switch (columnIndex) {
            case 0: return product.getName();
            case 1: return product.getBrand();
            case 2: return product.getCategory();
            case 3: return product.getPrice();
            case 4: return product.getQuantity();
            default: return null;
        }
    }

    public Product getProductAt(int rowIndex) {
        return products.get(rowIndex);
    }

    public void addProduct(Product product) {
        products.add(product);
        fireTableRowsInserted(products.size() - 1, products.size() - 1);
    }

    public void updateProduct(Product product) {
        int index = products.indexOf(product);
        if (index != -1) {
            fireTableRowsUpdated(index, index);
        }
    }

    public void removeProduct(Product product) {
        int index = products.indexOf(product);
        if (index != -1) {
            products.remove(index);
            fireTableRowsDeleted(index, index);
        }
    }

    public void refreshData() {
        products = new ArrayList<>(ProductManager.getInstance().getAllProducts());
        fireTableDataChanged();
    }
}
