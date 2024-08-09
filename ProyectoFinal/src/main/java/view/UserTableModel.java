package view;

import model.User;
import service.UserManager;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class UserTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    
    private static final String[] COLUMN_NAMES = {"Usuario", "Nombre", "Apellido", "Teléfono", "Correo"};
    
    private List<User> users;

    public UserTableModel() {
        users = new ArrayList<>(UserManager.getInstance().getAllUsers());
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
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
            default: throw new IllegalArgumentException("Invalid column index");
        }
    }

    public User getUserAt(int rowIndex) {
        return users.get(rowIndex);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        if (index != -1) {
            fireTableRowsUpdated(index, index);
        }
    }

    public void removeUser(User user) {
        int index = users.indexOf(user);
        if (index != -1) {
            users.remove(index);
            fireTableRowsDeleted(index, index);
        }
    }

    public void refreshData() {
        users = new ArrayList<>(UserManager.getInstance().getAllUsers());
        fireTableDataChanged();
    }
}
