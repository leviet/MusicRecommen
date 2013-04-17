/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectData;

/**
 *
 * @author UCKER
 */
import Model.*;
import java.util.ArrayList;

public class kNN {

    private ArrayList<Song> liSong = new ArrayList<Song>();
    private ArrayList<Vote> liVote = new ArrayList<Vote>();
    private ArrayList<User> liUser = new ArrayList<User>();
    private docData doc = new docData();
    private float[][] diem = new float[2000][2000];
    private float[] diemTB = new float[2000];

    public kNN() {
        liSong = doc.getListSong();
        liVote = doc.getListVote();
        liUser = doc.getListUser();
        int m = 0, n = 0;
        for (User u : liUser) {
            n = 0;
            for (Song so : liSong) {
                diem[m][n] = tdiem(so, u);
                n++;
            }
            diemTB[m] = tdiemTB(u);
            m++;
        }
        n = 0;
    }

    public void test() {
        int m = 0, n = 0;
        for (User u : liUser) {
            n = 0;
            for (Song so : liSong) {
                System.out.print(diem[m][n]);
                n++;
            }
            //     System.out.print(diemTB[m]);
            System.out.print("\n");
            m++;
        }
    }

    public float tdiem(Song A, User I) {
        for (Vote vo : liVote) {
            if (vo.getSong() == A.getId() && vo.getUser() == I.getId()) {
                return 1;
            }
        }
        return (float) 0.5;
    }

    public float tdiemTB(User A) {
        float diem = 0;
        for (Vote vo : liVote) {
            if (vo.getUser() == A.getId()) {
                diem++;
            }
        }
        return diem / liSong.size();
    }

    public float trongso(User A, User B) {
        float Tuso = 0, Mauso = 0, Ms1 = 0, Ms2 = 0;
        int a = 0, b = 0;
        for (int i = 0; i < liUser.size(); i++) {
            if (liUser.get(i).getId() == A.getId()) {
                a = i;
            }
            if (liUser.get(i).getId() == B.getId()) {
                b = i;
            }
        }
        for (int i = 0; i < liSong.size(); i++) {
            Tuso += (diem[a][i] - diemTB[a]) * (diem[b][i] - diemTB[b]);
            Ms1 += (diem[a][i] - diemTB[a]) * (diem[a][i] - diemTB[a]);
            Ms2 += (diem[b][i] - diemTB[b]) * (diem[b][i] - diemTB[b]);
        }
        float xk = (float) Math.sqrt(Ms1 * Ms2);
        return Tuso / xk;
    }

    public void doicho(float a, float b) {
        float c = a;
        a = b;
        b = c;
    }

    public ArrayList<Song> tinh(User A) {
        ArrayList<Song> liKq = new ArrayList<Song>();
        float[] kq = new float[liSong.size()];
        float[] tmp = new float[liSong.size()];
        int a = 0;
        for (int i = 0; i < liUser.size(); i++) {
            if (liUser.get(i).getId() == A.getId()) {
                a = i;
            }
        }
        int k = 0;
        for (int i = 0; i < liSong.size(); i++) {
            kq[k] = diem[a][i];
            tmp[k] = liSong.get(i).getId();
            if (kq[k] != 1) {
                float Tuso = 0, Mauso = 0;
                for (User u : liUser) {
                    Tuso += trongso(A, u) * (diem[a][i] - diemTB[a]);
                    Mauso += Math.abs(trongso(A, u));
                }
                kq[k] = diemTB[a] + Tuso / Mauso;
            }
            k++;
        }
        for (int m = 0; m < kq.length; m++) {
            for (int n = m + 1; n < kq.length; n++) {
                if (kq[m] < kq[n]) {
                    float x = kq[m];
                    kq[m] = kq[n];
                    kq[n] = x;
                    x = tmp[m];
                    tmp[m] = tmp[n];
                    tmp[n] = x;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            liKq.add(doc.getSong((int) tmp[i]));
        }
        for (int m = 0; m < kq.length; m++) {
            System.out.print(kq[m] + "\n");
        }
        /*   int i=0;
         while(kq[i]==1){
         i++;
         }
         for(int j=0;j<10;j++){
         liKq.add(doc.getSong((int)tmp[i+j]));
         }*/
        return liKq;
    }

    public ArrayList<Song> getLiSongType(Song so) {
        ArrayList<Song> liS = new ArrayList<Song>();
        ArrayList<Song> tmp = doc.getListSongType(so.getTypeid());
        float kq[] = new float[tmp.size()];
        float tam[] = new float[tmp.size()];
        int k = 0;
        for (Song song : tmp) {
            tam[k] = song.getId();
            float diem = 0;
            if (song.getPoster().equals(so.getPoster())) {
                diem += 0.5;
            }
            if (song.getSingerid() == so.getSingerid()) {
                diem += 0.4;
            }
            kq[k] = diem;
            k++;
        }
        for (int m = 0; m < kq.length; m++) {
            for (int n = m + 1; n < kq.length; n++) {
                if (kq[m] < kq[n]) {
                    float x = kq[m];
                    kq[m] = kq[n];
                    kq[n] = x;
                    x = tam[m];
                    tam[m] = tam[n];
                    tam[n] = x;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            liS.add(doc.getSong((int) tam[i]));
        }
        for (int m = 0; m < kq.length; m++) {
            System.out.print(kq[m] + "\n");
        }
        return liS;
    }

    public boolean checklike(User A, Song y) {
        for (Vote vo : liVote) {
            if ((vo.getSong() == y.getId()) && (vo.getUser() == A.getId())) {
                return false;
            }
        }
        return true;
    }
}
