/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectData;

import java.sql.*;
import Model.*;

/**
 *
 * @author UCKER
 */
public class DAO {

    Connection conn = null;

    public DAO() {
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/musicportal?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        String dbClass = "com.mysql.jdbc.Driver";
        try {
            Class.forName(dbClass);
            conn = DriverManager.getConnection(dbUrl, "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // Ham kiem tra dang nhap

    public boolean checkLogin(User user) {
        String query = "Select * FROM user WHERE name = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // ham lay thong tin user truyen vao name
    public User getUserName(String name) {
        User u = new User();
        String query = "Select * FROM user WHERE name='" + name + "'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                u = new User(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return u;
    }
// Ham them mot user vao csdl

    public void addAcc(User u) throws SQLException {
        String query = "INSERT INTO user(age,name,email) VALUES('" + u.getAge() + "','" + u.getName() + "','" + u.getEmail() + "')";
        try {
            Statement stmt = conn.createStatement();
            int k = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }
}
