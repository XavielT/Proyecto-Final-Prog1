package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.UserManager;
import model.User;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnRegister;

    public LoginFrame() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField();

        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField();

        btnLogin = new JButton("Login");
        btnRegister = new JButton("Register");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnRegister);

        add(panel);

        // Acciones para los botones
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Debe ingresar su usuario y contraseña.");
                    return;
                }

                if (UserManager.getInstance().validateLogin(username, password)) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login exitoso!");
                    // Abrir la ventana principal
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Usuario o contraseña incorrectos.");
                }
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la ventana de registro
                RegisterFrame registerFrame = new RegisterFrame();
                registerFrame.setVisible(true);
                dispose();
            }
        });
    }
}
