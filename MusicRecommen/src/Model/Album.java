/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author UCKER
 */
public class Album implements java.io.Serializable{
    private int id,singerid,typeid,viewed;
    private String name, name_asscii,info;

    public Album() {
    }

    public Album(int id, int singerid, int typeid, int viewed, String name, String name_asscii, String info) {
        this.id = id;
        this.singerid = singerid;
        this.typeid = typeid;
        this.viewed = viewed;
        this.name = name;
        this.name_asscii = name_asscii;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public int getSingerid() {
        return singerid;
    }

    public int getTypeid() {
        return typeid;
    }

    public int getViewed() {
        return viewed;
    }

    public String getName() {
        return name;
    }

    public String getName_asscii() {
        return name_asscii;
    }

    public String getInfo() {
        return info;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSingerid(int singerid) {
        this.singerid = singerid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName_asscii(String name_asscii) {
        this.name_asscii = name_asscii;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
}
