package view;

import model.User;
import service.UserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {

    private static final long serialVersionUID = 1L;

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
        
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel lblUsername = new JLabel("Username:");
        txtUsername = createTextField("Enter your username");

        JLabel lblFirstName = new JLabel("First Name:");
        txtFirstName = createTextField("Enter your first name");

        JLabel lblLastName = new JLabel("Last Name:");
        txtLastName = createTextField("Enter your last name");

        JLabel lblPhoneNumber = new JLabel("Phone Number:");
        txtPhoneNumber = createTextField("Enter your phone number");

        JLabel lblEmail = new JLabel("Email:");
        txtEmail = createTextField("Enter your email address");

        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField();
        txtPassword.setToolTipText("Enter your password");

        JLabel lblConfirmPassword = new JLabel("Confirm Password:");
        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setToolTipText("Confirm your password");

        btnRegister = createButton("Register", new Color(0, 123, 255), Color.WHITE);
        btnBack = createButton("Back", Color.LIGHT_GRAY, Color.BLACK);

        addComponentsToPanel(panel, gbc, lblUsername, txtUsername, lblFirstName, txtFirstName, lblLastName, txtLastName,
                             lblPhoneNumber, txtPhoneNumber, lblEmail, txtEmail, lblPassword, txtPassword,
                             lblConfirmPassword, txtConfirmPassword, btnRegister, btnBack);

        add(panel);
        setActionListeners();
    }

    private JTextField createTextField(String tooltip) {
        JTextField textField = new JTextField();
        textField.setToolTipText(tooltip);
        return textField;
    }

    private JButton createButton(String text, Color background, Color foreground) {
        JButton button = new JButton(text);
        button.setBackground(background);
        button.setForeground(foreground);
        return button;
    }

    private void addComponentsToPanel(JPanel panel, GridBagConstraints gbc, JComponent... components) {
        for (int i = 0; i < components.length; i += 2) {
            gbc.gridx = 0;
            gbc.gridy = i / 2;
            panel.add(components[i], gbc);

            gbc.gridx = 1;
            panel.add(components[i + 1], gbc);
        }
    }

    private void setActionListeners() {
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegisterAction();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBackAction();
            }
        });
    }

    private void handleRegisterAction() {
        String username = txtUsername.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());

        if (username.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
            phoneNumber.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
            return;
        }

        User user = new User(username, firstName, lastName, phoneNumber, email, password);
        UserManager.getInstance().addUser(user);

        JOptionPane.showMessageDialog(this, "Registro exitoso!");
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        dispose();
    }

    private void handleBackAction() {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        dispose();
    }
}
