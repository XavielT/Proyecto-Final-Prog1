package view;

import model.User;
import service.UserManager;

import javax.swing.*;
import java.awt.*;

public class UserManagementFrame extends JFrame {
    private JTable userTable;
    private JButton btnBack;
    private UserTableModel userTableModel;

    public UserManagementFrame() {
        setTitle("Gestión de Usuarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        userTableModel = new UserTableModel();
        userTable = new JTable(userTableModel);

        btnBack = new JButton("Volver");

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());
        panelButtons.add(btnBack);

        add(new JScrollPane(userTable), BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);

        // Acción para el botón Volver
        btnBack.addActionListener(e -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            dispose();
        });

        // Acción al seleccionar un usuario en la tabla
        userTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = userTable.getSelectedRow();
                if (selectedRow >= 0) {
                    User selectedUser = userTableModel.getUserAt(selectedRow);
                    // Aquí se podría abrir una ventana de edición de usuario si se quisiera implementar
                }
            }
        });
    }
}

