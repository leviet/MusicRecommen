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
import Model.Singer;
import Model.Song;
import Model.Type;
import Model.User;
import Model.Vote;
import View.Get;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SelectData {

    public SelectData() {
    }
    public static ConnectionDB ghi = new ghiData();
    public static ConnectionDB doc = new docData();
// Hàm lấy số người nghe từ chuỗi String
/*    public static int getVit(String st) {
     String s = "";
     int i = 0;
     while (i < st.length() && st.charAt(i) != '|') {
     i++;
     }
     s = st.substring(i);
     String str = "";        
     st = s.trim();        
     String arr[] = st.split(" ");        
     return Integer.parseInt(arr[5].replace(",", ""));
     }
     */
// Hàm get tác giả ca khúc từ chuỗi String
/*
     public static String getAu(String st) {
     String s = "";
     int i = 0;
     while (i < st.length() && st.charAt(i) != '|') {
     i++;
     }
     s = st.substring(i);
     String str = "";        
     st = s.trim();        
     String arr[] = st.split(" ");        
     return arr[3];
     } */
    /*
     public static int getVit2(String st) {

     String str = "";        
     st = st.trim();        
     String arr[] = st.split(" ");        
     return Integer.parseInt(arr[4].replace(",", ""));
     }

     public static String getAu2(String st) {      
     st = st.trim();        
     String arr[] = st.split(" ");        
     return arr[2];
     } */

    public static String getCode(String s) {
        String str[] = s.split("/");
        int i = 0;
        while (i < str[str.length - 1].length() && str[str.length - 1].charAt(i) != '.') {
            i++;
        }
        return str[str.length - 1].substring(i + 1, i + 11);
    }

    public static int checkSingger(String singer, String type) {
        try {
            ArrayList<Singer> li = doc.getListSinger();
            for (Singer y : li) {
                if (y.getName_ascii().equals(ConvertString(singer))) {
                    return y.getId();
                }
            }
            Singer si = new Singer(1, 0, singer, ConvertString(singer), "", "", checkType(type));
            ghi.singer(si);
            li = li = doc.getListSinger();
            for (Singer y : li) {
                if (y.getName_ascii().equals(ConvertString(singer))) {
                    return y.getId();
                }
            }
        } catch (Exception ex) {
            System.out.print("Loi ten");
        }
        return 0;
    }

    public static int checkType(String type) throws SQLException {
        try {
            ArrayList<Type> li = doc.getListType();
            for (Type y : li) {
                if (y.getName_asscii().equals(ConvertString(type))) {
                    return y.getId();
                }
            }
            ghi.type(new Type(1, type, ConvertString(type)));
            li = doc.getListType();
            for (Type y : li) {
                if (y.getName_asscii().equals(ConvertString(type))) {
                    return y.getId();
                }
            }
        } catch (Exception ex) {
            System.out.print("Loi the loai");
        }
        return 0;
    }

    public static int checkUser(String type) throws SQLException {
        try {
            ArrayList<User> li = doc.getListUser();
            for (User y : li) {
                if (y.getName().equals(type)) {
                    return y.getId();
                }
            }
            ghi.user(new User(1, 20, type, ""));
            for (User y : li) {
                if (y.getName().equals(type)) {
                    return y.getId();
                }
            }
        } catch (Exception ex) {
            System.out.print("Loi the loai");
        }
        return 0;
    }
    private static char[] charA = {'à', 'á', 'ạ', 'ả', 'ã', 'â', 'ầ', 'ấ', 'ậ', 'ẩ', 'ẫ', 'ă', 'ằ', 'ắ', 'ặ', 'ẳ', 'ẵ'};
    private static char[] charE = {'ê', 'ề', 'ế', 'ệ', 'ể', 'ễ', 'è', 'é', 'ẹ', 'ẻ', 'ẽ'};
    private static char[] charI = {'ì', 'í', 'ị', 'ỉ', 'ĩ'};
    private static char[] charO = {'ò', 'ó', 'ọ', 'ỏ', 'õ', 'ô', 'ồ', 'ố', 'ộ', 'ổ', 'ỗ', 'ơ', 'ờ', 'ớ', 'ợ', 'ở', 'ỡ'};
    private static char[] charU = {'ù', 'ú', 'ụ', 'ủ', 'ũ', 'ư', 'ừ', 'ứ', 'ự', 'ử', 'ữ'};
    private static char[] charY = {'ỳ', 'ý', 'ỵ', 'ỷ', 'ỹ'};
    private static char[] charD = {'đ', ' '};
    private static String charact = String.valueOf(charA, 0, charA.length)
            + String.valueOf(charE, 0, charE.length)
            + String.valueOf(charI, 0, charI.length)
            + String.valueOf(charO, 0, charO.length)
            + String.valueOf(charU, 0, charU.length)
            + String.valueOf(charY, 0, charY.length)
            + String.valueOf(charD, 0, charD.length);

    private static char GetAlterChar(char pC) {
        if ((int) pC == 32) {
            return ' ';
        }
        char tam = pC;

        int i = 0;
        while (i < charact.length() && charact.charAt(i) != tam) {
            i++;
        }
        if (i < 0 || i > 67) {
            return pC;
        }

        if (i == 66) {
            return 'd';
        }
        if (i >= 0 && i <= 16) {
            return 'a';
        }
        if (i >= 17 && i <= 27) {
            return 'e';
        }
        if (i >= 28 && i <= 32) {
            return 'i';
        }
        if (i >= 33 && i <= 49) {
            return 'o';
        }
        if (i >= 50 && i <= 60) {
            return 'u';
        }
        if (i >= 61 && i <= 65) {
            return 'y';
        }
        return pC;
    }

    public static String ConvertString(String pStr) {
        String convertString = pStr.toLowerCase();
        Character[] returnString = new Character[convertString.length()];
        for (int i = 0; i < convertString.length(); i++) {
            char temp = convertString.charAt(i);
            if ((int) temp < 97 || temp > 122) {
                char tam1 = GetAlterChar(temp);
                if ((int) temp != 32) {
                    convertString = convertString.replace(temp, tam1);
                }
            }
        }
        return convertString;
    }

    public void getData(String url, String loainhac, int k) {
        try {
            Get showm = new Get();
            for (int i = 1; i <= k / 20; i++) {
                URL yahoo = new URL(url + "?page=" + i);
                URLConnection yc = yahoo.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
                String inputLine;
                String s = "";
                while ((inputLine = in.readLine()) != null) {
                    s += inputLine;
                }
                in.close();
                Document docx = Jsoup.parse(s);
                Elements list = docx.select(".list-song");
                Elements songs = list.select("li");
                for (Element song : songs) {


                    Song so = new Song();
                    so.setName(song.select(".song-name").text().replace("'", ""));
                    so.setSingerid(checkSingger(song.select(".singer").text().replace("'", ""), loainhac));
                    so.setName_asscii(ConvertString(song.select(".song-name").text()).replace("'", ""));
                    Elements links = song.select(".song-name a");
                    so.setCode(getCode(links.last().attr("href").toString()));
                    so.setPoster(song.select(".user-up").text());
                    checkUser(song.select(".user-up").text());
                    so.setViewed(Integer.parseInt(song.select(".num").text().replace(".", "")));
                    so.setTypeid(checkType(loainhac));
                    showm.showMe("\nBài hát: " + song.select(".song-name").text());
                    showm.showMe("\nCa sĩ: " + song.select(".singer").text());
                    showm.showMe("\nPoster: " + song.select(".user-up").text());
                    showm.showMe("\nVisit: " + song.select("div.num").text());
                    showm.showMe("\nCode: " + getCode(links.last().attr("href").toString()));
                    showm.showMe("\n------------------------------------------------------------");
                    ghi.song(so);
                    ArrayList<Song> liSong = doc.getListSong();
                    Vote v = new Vote();
                    v = new Vote(1, 100, checkUser(song.select(".user-up").text()), liSong.get(liSong.size() - 1).getId());
                    ghi.vote(v);
                }
            }
            showm.showMe("\nXong, Quá đẹp ^_^");
        } catch (Exception ex) {
            System.out.print("Loi");
        }
    }
}
