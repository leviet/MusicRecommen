/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author UCKER
 */
public class Vote implements java.io.Serializable{
    private int point,id,user,song;

    public Vote() {
    }

    public int getPoint() {
        return point;
    }

    public int getId() {
        return id;
    }

    public int getUser() {
        return user;
    }

    public int getSong() {
        return song;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setSong(int song) {
        this.song = song;
    }

    public Vote(int point, int id, int user, int song) {
        this.point = point;
        this.id = id;
        this.user = user;
        this.song = song;
    }

   
}
