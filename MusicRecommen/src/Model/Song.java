/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author UCKER
 */
public class Song implements java.io.Serializable{
private int id,typeid,singerid,albumid,viewed;
private String poster,name,name_asscii,code;

    public Song() {
    }

    public Song(int id, int typeid, int singerid, int albumid, int viewed, String poster, String name, String name_asscii, String code) {
        this.id = id;
        this.typeid = typeid;
        this.singerid = singerid;
        this.albumid = albumid;
        this.viewed = viewed;
        this.poster = poster;
        this.name = name;
        this.name_asscii = name_asscii;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public int getTypeid() {
        return typeid;
    }

    public int getSingerid() {
        return singerid;
    }

    public int getAlbumid() {
        return albumid;
    }

    public int getViewed() {
        return viewed;
    }

    public String getPoster() {
        return poster;
    }

    public String getName() {
        return name;
    }

    public String getName_asscii() {
        return name_asscii;
    }

    public String getCode() {
        return code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public void setSingerid(int singerid) {
        this.singerid = singerid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName_asscii(String name_asscii) {
        this.name_asscii = name_asscii;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
