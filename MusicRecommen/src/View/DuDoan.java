/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author UCKER
 */
import Interface.ConnectionDB;
import Model.*;
import SelectData.*;
import java.util.ArrayList;
public class DuDoan {
public static kNN dd=new kNN();
public static DAO da=new DAO();
private static ConnectionDB doc=new docData();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Type> listtype=doc.getListType();
        System.out.print(listtype.get(0).getName());
   //  dd.test();
        Song so=doc.getSong(1);
     //  ArrayList<Song> li=dd.getLiSongType(u);
        User u=doc.getUser(1);
        if(dd.checklike(u, so)) System.out.print("OK");
        
        else System.out.print("FUCK");
        }
    
}
