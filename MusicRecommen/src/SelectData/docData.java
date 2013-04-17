/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectData;

/**
 *
 * @author UCKER
 */
import Interface.ConnectionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import Model.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class docData implements ConnectionDB {

    Connection conn = new config().getConect();

    public docData() {
    }

    @Override
    public ArrayList<Type> getListType() {
        ArrayList<Type> listtype = new ArrayList<Type>();
        String query = "Select * FROM type";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Type t = new Type(rs.getInt(1), rs.getString(2), rs.getString(3));
                listtype.add(t);
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return (ArrayList<Type>) listtype;
    }

    @Override
    public ArrayList<Singer> getListSinger() {
        ArrayList<Singer> listsinger = new ArrayList<Singer>();
        String query = "Select * FROM singer";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Singer t = new Singer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                listsinger.add(t);
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return (ArrayList<Singer>) listsinger;
    }

    @Override
    public ArrayList<User> getListUser() {
        ArrayList<User> listUser = new ArrayList<User>();
        String query = "Select * FROM user";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User t = new User(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                listUser.add(t);
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return (ArrayList<User>) listUser;
    }

    @Override
    public User getUser(int idu) {
        User u = new User();
        String query = "Select * FROM user WHERE id='" + idu + "'";
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

    @Override
    public ArrayList<Song> getListSong() {
        ArrayList<Song> listSong = new ArrayList<Song>();
        String query = "Select * FROM song";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Song t = new Song(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                listSong.add(t);
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return (ArrayList<Song>) listSong;
    }

    @Override
    public ArrayList<Vote> getListVote() {
        ArrayList<Vote> listVote = new ArrayList<Vote>();
        String query = "Select * FROM vote";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Vote t = new Vote(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                listVote.add(t);
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return (ArrayList<Vote>) listVote;
    }
//lay thong tin bai hat
    @Override
    public Song getSong(int songid) {
        Song u = new Song();
        String query = "Select * FROM song WHERE id=" + songid;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                u = new Song(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return u;
    }

//Lay danh sach nhac theo the loai
    @Override
    public ArrayList<Song> getListSongType(int typeid) {
        ArrayList<Song> listSong = new ArrayList<Song>();
        String query = "Select * FROM song where typeid=" + typeid;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Song t = new Song(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                listSong.add(t);
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return (ArrayList<Song>) listSong;
    }

    @Override
    public String getNameSinger(int id) {
        String name = "";
        String query = "Select * FROM singer WHERE id=" + id;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                name = rs.getString(3);
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return name;
    }

    @Override
    public void singer(Singer si) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void song(Song son) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void type(Type ty) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void vote(Vote vo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void user(User u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
