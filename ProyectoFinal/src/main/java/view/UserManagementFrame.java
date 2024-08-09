package view;

import model.User;
import service.UserManager;

import javax.swing.*;
import java.awt.*;

public class UserManagementFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTable userTable;
    private JButton btnBack;
    private UserTableModel userTableModel;

    public UserManagementFrame() {
        setTitle("Gestión de Usuarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        userTableModel = new UserTableModel();
        userTable = new JTable(userTableModel);

        btnBack = createButton("Volver", Color.LIGHT_GRAY, Color.BLACK);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelButtons.add(btnBack);

        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Usuarios"));

        add(scrollPane, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);

        setActionListeners();
    }

    private JButton createButton(String text, Color background, Color foreground) {
        JButton button = new JButton(text);
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(100, 30));
        return button;
    }

    private void setActionListeners() {
        btnBack.addActionListener(e -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            dispose();
        });

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
