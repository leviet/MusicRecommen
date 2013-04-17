/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author UCKER
 */
public class Type implements java.io.Serializable{
    private int id;
    private String name,name_asscii;

    public Type() {
    }


    public Type(int id, String name, String name_asscii) {
        this.id = id;
        this.name = name;
        this.name_asscii = name_asscii;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getName_asscii() {
        return name_asscii;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName_asscii(String name_asscii) {
        this.name_asscii = name_asscii;
    }
    
}
