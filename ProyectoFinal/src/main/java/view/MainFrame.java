package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JButton btnUserManagement;
    private JButton btnProductManagement;
    private JButton btnLogout;

    public MainFrame() {
        setTitle("Sistema de Gestión de Almacén");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creación de botones
        btnUserManagement = new JButton("Gestión de Usuarios");
        btnProductManagement = new JButton("Gestión de Productos");
        btnLogout = new JButton("Cerrar Sesión");

        // Estilo de los botones
        btnUserManagement.setFont(new Font("Arial", Font.PLAIN, 14));
        btnProductManagement.setFont(new Font("Arial", Font.PLAIN, 14));
        btnLogout.setFont(new Font("Arial", Font.PLAIN, 14));

        // Panel para contener los botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20)); // Ajusta los márgenes internos

        // Añadir botones al panel
        panel.add(btnUserManagement);
        panel.add(btnProductManagement);
        panel.add(btnLogout);

        add(panel, BorderLayout.CENTER);

        // Acción para el botón Gestión de Usuarios
        btnUserManagement.addActionListener(e -> {
            UserManagementFrame userManagementFrame = new UserManagementFrame();
            userManagementFrame.setVisible(true);
            dispose();
        });

        // Acción para el botón Gestión de Productos
        btnProductManagement.addActionListener(e -> {
            ProductManagementFrame productManagementFrame = new ProductManagementFrame();
            productManagementFrame.setVisible(true);
            dispose();
        });

        // Acción para el botón Cerrar Sesión
        btnLogout.addActionListener(e -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
            dispose();
        });
    }
}
