/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author UCKER
 */
public class Singer implements java.io.Serializable{
    private int id,viewed,typeid;
    private String name,name_ascii,img,info;

    public Singer() {
    }

    public Singer(int id, int viewed, String name, String name_ascii, String img, String info, int typeid) {
        this.id = id;
        this.viewed = viewed;
        this.name = name;
        this.name_ascii = name_ascii;
        this.img = img;
        this.info = info;
        this.typeid = typeid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName_ascii(String name_ascii) {
        this.name_ascii = name_ascii;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getId() {
        return id;
    }

    public int getViewed() {
        return viewed;
    }

    public String getName() {
        return name;
    }

    public String getName_ascii() {
        return name_ascii;
    }

    public String getImg() {
        return img;
    }

    public String getInfo() {
        return info;
    }

    public int getTypeid() {
        return typeid;
    }

}
