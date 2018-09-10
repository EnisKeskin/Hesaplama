package Hesaplamalarım.Verilerim;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KaynakVeriler
{
    private String dk3;
    private String dk5;
    private String saat1;
    private String saat2;
    private String saat4;
    private String saat12;
    private String gun1;
    private String gun3;
    private Date saat;

    public KaynakVeriler(String dk3, String dk5, String saat1, String saat2, String saat4, String saat12, String gun1, String gun3) {
        this.dk3 = dk3;
        this.dk5 = dk5;
        this.saat1 = saat1;
        this.saat2 = saat2;
        this.saat4 = saat4;
        this.saat12 = saat12;
        this.gun1 = gun1;
        this.gun3 = gun3;
        saat=new Date();
    }

    public String getDk3() {
        return dk3;
    }

    public void setDk3(String dk3) {
        this.dk3 = dk3;
    }

    public String getDk5() {
        return dk5;
    }

    public void setDk5(String dk5) {
        this.dk5 = dk5;
    }

    public String getSaat1() {
        return saat1;
    }

    public void setSaat1(String saat1) {
        this.saat1 = saat1;
    }

    public String getSaat2() {
        return saat2;
    }

    public void setSaat2(String saat2) {
        this.saat2 = saat2;
    }

    public String getSaat4() {
        return saat4;
    }

    public void setSaat4(String saat4) {
        this.saat4 = saat4;
    }

    public String getSaat12() {
        return saat12;
    }

    public void setSaat12(String saat12) {
        this.saat12 = saat12;
    }

    public String getGun1() {
        return gun1;
    }

    public void setGun1(String gun1) {
        this.gun1 = gun1;
    }

    public String getGun3() {
        return gun3;
    }

    public void setGun3(String gun3) {
        this.gun3 = gun3;
    }

    @Override
    public String toString() {

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        return "İnşaat"+simpleDateFormat.format(saat) ;
    }
}
