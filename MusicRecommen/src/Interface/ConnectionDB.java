/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import Model.*;

/**
 *
 * @author UCKER
 */
public interface ConnectionDB {
    //Ham lay danh sach ca si
    public ArrayList<Singer> getListSinger();
    //Ham lay toan bo danh sach cac bai hat trong CSDL
    public ArrayList<Song> getListSong();
    //Ham lay danh sach cac bai hat theo the loai
    public ArrayList<Song> getListSongType(int idtype);
    //Ham lay danh sach cac the loai nhac
    public ArrayList<Type> getListType();
    //Ham lay danh sach user trong he thong
    public ArrayList<User> getListUser();
    //Ham lay danh sach bau chon
    public ArrayList<Vote> getListVote();
    //Ham lay ten cua ca si
    public String getNameSinger(int id);
    //Ham lay thong tin ca khuc dua tren id truyen vao
    public Song getSong(int i);
    //Ham lay thoong tin nguoi dung dua tren id truyen vao
    public User getUser(int i);
    // Ham ghi thong tin mot ca si vao csdl
    public void singer(Singer si);
    // Ham ghi thong tin bai hat vao csdl
    public void song(Song son);
    // Ham ghi thong tin mot the loai nhac vao csdl
    public void type(Type ty);
    //Ham ghi thong tin mot vote vao csdl
    public void vote(Vote vo);
    //Ham ghi thong tin mot user vao csdl
    public void user(User u);
}
