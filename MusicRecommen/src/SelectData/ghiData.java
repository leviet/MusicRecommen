/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectData;

import Interface.ConnectionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import Model.*;
import java.util.ArrayList;

public class ghiData implements ConnectionDB {

    Connection conn = new config().getConect();

    public ghiData() {
    }

    @Override
    public void song(Song so) {
        String query = "INSERT INTO song(typeid,singerid,albumid,viewed,poster,name,name_asscii,code) VALUES('" + so.getTypeid() + "','" + so.getSingerid() + "','" + so.getAlbumid() + "','" + so.getViewed() + "','" + so.getPoster() + "','" + so.getName() + "','" + so.getName_asscii() + "','" + so.getCode() + "')";
        try {
            Statement stmt = conn.createStatement();
            int k = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    @Override
    public void type(Type ty) {
        String query = "INSERT INTO type(name,name_asscii) VALUES('" + ty.getName() + "','" + ty.getName_asscii() + "')";
        try {
            Statement stmt = conn.createStatement();
            int k = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    @Override
    public void singer(Singer si) {
        String query = "INSERT INTO singer(viewed,name,name_ascii,img,info,typeid) VALUES('" + si.getViewed() + "','" + si.getName() + "','" + si.getName_ascii() + "','" + si.getImg() + "','" + si.getInfo() + "','" + si.getTypeid() + "')";
        try {
            Statement stmt = conn.createStatement();
            int k = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    @Override
    public void user(User u) {
        String query = "INSERT INTO user(age,name,email) VALUES('" + u.getAge() + "','" + u.getName() + "','" + u.getEmail() + "')";
        try {
            Statement stmt = conn.createStatement();
            int k = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    @Override
    public void vote(Vote u) {
        String query = "INSERT INTO vote(point,userid,songid) VALUES('" + u.getPoint() + "','" + u.getUser() + "','" + u.getSong() + "')";
        try {
            Statement stmt = conn.createStatement();
            int k = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    @Override
    public ArrayList<Singer> getListSinger() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Song> getListSong() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Song> getListSongType(int idtype) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Type> getListType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<User> getListUser() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Vote> getListVote() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getNameSinger(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Song getSong(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User getUser(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
