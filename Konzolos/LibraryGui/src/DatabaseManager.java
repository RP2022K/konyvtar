
import java.sql.*;
/**
 *
 * @author rp
 */
public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/konyvtar", "user", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

  public ResultSet getBooksForUser(String username) throws SQLException {
    PreparedStatement stmt = connection.prepareStatement("SELECT book_name FROM kolcsonzesek WHERE user_name = ?");
    stmt.setString(1, username);
    return stmt.executeQuery();
}
public void deleteBook(String bookName) throws SQLException {
    PreparedStatement stmt = connection.prepareStatement("DELETE FROM kolcsonzesek WHERE book_name = ?");
    stmt.setString(1, bookName);
    stmt.executeUpdate();
}
private void jButtonVisszahozvaActionPerformed(java.awt.event.ActionEvent evt) {
    String selectedBook = bookList.getSelectedValue();
    if (selectedBook != null && !selectedBook.isEmpty()) {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            dbManager.deleteBook(selectedBook);
            // Frissítsd a listát, stb.
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}

}