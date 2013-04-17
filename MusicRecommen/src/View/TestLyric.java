/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Interface.*;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/**
 *
 * @author UCKER
 */
public class TestLyric {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        System.out.print(new getLyric().getLyric("In The End", "Linkin Park"));
    }
}
