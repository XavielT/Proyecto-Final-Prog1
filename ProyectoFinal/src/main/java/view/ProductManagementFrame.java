package view;

import model.Product;
import service.ProductManager;

import javax.swing.*;
import java.awt.*;

public class ProductManagementFrame extends JFrame {
    private JTable productTable;
    private JButton btnNewProduct;
    private JButton btnBack;
    private ProductTableModel productTableModel;

    public ProductManagementFrame() {
        setTitle("Gestión de Productos");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar modelo de la tabla y tabla
        productTableModel = new ProductTableModel();
        productTable = new JTable(productTableModel);
        productTable.setFillsViewportHeight(true);
        productTable.setRowHeight(30);

        // Estilo de la tabla
        productTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        productTable.getTableHeader().setBackground(new Color(0x2E86C1));
        productTable.getTableHeader().setForeground(Color.WHITE);
        productTable.setSelectionBackground(new Color(0xAED6F1));
        productTable.setSelectionForeground(Color.BLACK);
        productTable.setFont(new Font("SansSerif", Font.PLAIN, 14));

        // Inicializar botones
        btnNewProduct = new JButton("Nuevo Producto");
        btnBack = new JButton("Volver");

        // Estilo de los botones
        btnNewProduct.setPreferredSize(new Dimension(150, 40));
        btnBack.setPreferredSize(new Dimension(150, 40));

        btnNewProduct.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnNewProduct.setBackground(new Color(0x28B463));
        btnNewProduct.setForeground(Color.WHITE);

        btnBack.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnBack.setBackground(new Color(0xC0392B));
        btnBack.setForeground(Color.WHITE);

        // Panel de botones
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelButtons.add(btnNewProduct);
        panelButtons.add(btnBack);

        // Añadir componentes al JFrame
        add(new JScrollPane(productTable), BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);

        // Acción para el botón Nuevo Producto
        btnNewProduct.addActionListener(e -> {
            ProductFormFrame productFormFrame = new ProductFormFrame(null, productTableModel);
            productFormFrame.setVisible(true);
        });

        // Acción para el botón Volver
        btnBack.addActionListener(e -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            dispose();
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
