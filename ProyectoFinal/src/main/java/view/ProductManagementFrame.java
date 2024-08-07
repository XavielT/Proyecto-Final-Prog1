package view;

import model.Product;
import service.ProductManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductManagementFrame extends JFrame {
    private JTable productTable;
    private JButton btnNewProduct;
    private JButton btnBack;
    private ProductTableModel productTableModel;

    public ProductManagementFrame() {
        setTitle("Gestión de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        productTableModel = new ProductTableModel();
        productTable = new JTable(productTableModel);

        btnNewProduct = new JButton("Nuevo Producto");
        btnBack = new JButton("Volver");

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());
        panelButtons.add(btnNewProduct);
        panelButtons.add(btnBack);

        add(new JScrollPane(productTable), BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);

        // Acción para el botón Nuevo Producto
        btnNewProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductFormFrame productFormFrame = new ProductFormFrame(null, productTableModel);
                productFormFrame.setVisible(true);
            }
        });

        // Acción para el botón Volver
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                dispose();
            }
        });

        // Acción al seleccionar un producto en la tabla
        productTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow >= 0) {
                    Product selectedProduct = productTableModel.getProductAt(selectedRow);
                    ProductFormFrame productFormFrame = new ProductFormFrame(selectedProduct, productTableModel);
                    productFormFrame.setVisible(true);
                }
            }
        });
    }
}

