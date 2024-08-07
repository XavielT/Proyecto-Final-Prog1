package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.UserManager;
import model.User;

public class RegisterFrame extends JFrame {
    private JTextField txtUsername;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtPhoneNumber;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private JButton btnRegister;
    private JButton btnBack;

    public RegisterFrame() {
        setTitle("Register");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField();

        JLabel lblFirstName = new JLabel("First Name:");
        txtFirstName = new JTextField();

        JLabel lblLastName = new JLabel("Last Name:");
        txtLastName = new JTextField();

        JLabel lblPhoneNumber = new JLabel("Phone Number:");
        txtPhoneNumber = new JTextField();

        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();

        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField();

        JLabel lblConfirmPassword = new JLabel("Confirm Password:");
        txtConfirmPassword = new JPasswordField();

        btnRegister = new JButton("Register");
        btnBack = new JButton("Back");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblFirstName);
        panel.add(txtFirstName);
        panel.add(lblLastName);
        panel.add(txtLastName);
        panel.add(lblPhoneNumber);
        panel.add(txtPhoneNumber);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(lblConfirmPassword);
        panel.add(txtConfirmPassword);
        panel.add(btnRegister);
        panel.add(btnBack);

        add(panel);

        // Acciones para los botones
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String firstName = txtFirstName.getText();
                String lastName = txtLastName.getText();
                String phoneNumber = txtPhoneNumber.getText();
                String email = txtEmail.getText();
                String password = new String(txtPassword.getPassword());
                String confirmPassword = new String(txtConfirmPassword.getPassword());

                if (username.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
                    phoneNumber.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Todos los campos son obligatorios.");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Las contraseñas no coinciden.");
                    return;
                }

                User user = new User(username, firstName, lastName, phoneNumber, email, password);
                UserManager.getInstance().addUser(user);

                JOptionPane.showMessageDialog(RegisterFrame.this, "Registro exitoso!");
                // Regresar a la ventana de login
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
                dispose();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Regresar a la ventana de login
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
                dispose();
            }
        });
    }
}
