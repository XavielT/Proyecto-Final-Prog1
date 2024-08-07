package view;

import model.User;
import service.UserManager;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UserTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Usuario", "Nombre", "Apellido", "Teléfono", "Correo"};
    private List<User> users;

    public UserTableModel() {
        users = UserManager.getInstance().getAllUsers();
    }

    @Override
    public int getRowCount() {
        return users.size();
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
        User user = users.get(rowIndex);
        switch (columnIndex) {
            case 0: return user.getUsername();
            case 1: return user.getFirstName();
            case 2: return user.getLastName();
            case 3: return user.getPhoneNumber();
            case 4: return user.getEmail();
            default: return null;
        }
    }

    public User getUserAt(int rowIndex) {
        return users.get(rowIndex);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        fireTableRowsUpdated(index, index);
    }

    public void removeUser(User user) {
        int index = users.indexOf(user);
        users.remove(user);
        fireTableRowsDeleted(index, index);
    }
}
