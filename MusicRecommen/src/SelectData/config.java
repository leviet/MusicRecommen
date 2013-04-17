/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UCKER
 */
public class config {

    public config() {
    }

    public Connection getConect() {
        String dbUsername = "root";
        String dbPassword = "";
        Connection conn = null;
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/musicportal?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        String dbClass = "com.mysql.jdbc.Driver";
        try {
            Class.forName(dbClass);
            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
        } catch ( SQLException e) {
        }
        return conn;
    }
}
