/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.util.List;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author UCKER
 */
public class getLyric {
    private String getCharacterDataFromElement(Element e) {
        try {
            Node child = e.getFirstChild();
            if (child instanceof CharacterData) {
                CharacterData cd = (CharacterData) child;
                return cd.getData();
            }
        } catch (Exception ex) {
        }
        return "";
    }

    protected float getFloat(String value) {
        if (value != null && !value.equals("")) {
            return Float.parseFloat(value);
        }
        return 0;
    }

    protected String getElementValue(Element parent, String label) {
        return getCharacterDataFromElement((Element) parent.getElementsByTagName(label).item(0));
    }

    public String getLyric(String name,String singer) throws ParserConfigurationException, IOException, SAXException {
        try {
            name=name.trim();
            singer=singer.trim();
            name=name.replace(" ", "%20");
            singer=singer.replace(" ", "%20");
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            URL u = new URL("http://api.chartlyrics.com/apiv1.asmx/SearchLyricDirect?artist="+singer+"&song="+name);
            Document doc = builder.parse(u.openStream());
            NodeList nodes = doc.getElementsByTagName("GetLyricResult");
            for(int i=0;i<nodes.getLength();i++) {
                Element element = (Element) nodes.item(i);
                return getElementValue(element, "Lyric");
            }
            return "Không có lời bài hát";
        } catch (MalformedURLException ex) {
           return "Không có lời bài hát";
        }
    }
}
