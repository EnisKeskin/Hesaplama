package Hesaplamalarım.Verilerim;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class KaynakVerilerinDepolanması
{
    private static KaynakVerilerinDepolanması instance=new KaynakVerilerinDepolanması();
    private static String dosyaAdi="veriler.txt";

    private ObservableList<KaynakVeriler> veriListesi;

    private KaynakVerilerinDepolanması(){}

    public static KaynakVerilerinDepolanması getInstance() {return instance;}


    public void DosyayıOku()throws IOException
    {
        veriListesi=FXCollections.observableArrayList();
        Path dosyaYolu=Paths.get(dosyaAdi);
        BufferedReader br=Files.newBufferedReader(dosyaYolu);
        String ifade;
        try {
            while ((ifade = br.readLine()) != null) {
                String veriler[] = ifade.split("\t");
                String dk3 = veriler[0];
                String dk5 = veriler[1];
                String sa1 = veriler[2];
                String sa2 = veriler[3];
                String sa4 = veriler[4];
                String sa12 = veriler[5];
                String gun1 = veriler[6];
                String gun3 = veriler[7];
                KaynakVeriler verilerOkunuyor = new KaynakVeriler(dk3, dk5, sa1, sa2, sa4, sa12, gun1, gun3);
                veriListesi.add(verilerOkunuyor);
            }
        }finally {
            if (br!=null)
            {
                br.close();
            }
        }
    }

    public void DosyayaYaz() throws IOException
    {
        Path dosyaYolu= Paths.get(dosyaAdi);
        BufferedWriter wr= Files.newBufferedWriter(dosyaYolu);

        Iterator<KaynakVeriler>iterator=veriListesi.iterator();
        try {
            while (iterator.hasNext()) {
                KaynakVeriler okunanVeriler = iterator.next();
                wr.write(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
                        okunanVeriler.getDk3(),
                        okunanVeriler.getDk5(),
                        okunanVeriler.getSaat1(),
                        okunanVeriler.getSaat2(),
                        okunanVeriler.getSaat4(),
                        okunanVeriler.getSaat12(),
                        okunanVeriler.getGun1(),
                        okunanVeriler.getGun3()
                ));
                wr.newLine();
            }
        }finally {
            if (wr!=null)
            {
                wr.close();
            }
        }
    }

    public void yeniVeriYaz(KaynakVeriler veri)
    {
        veriListesi.add(veri);
    }

    public void veriSil(KaynakVeriler silinecekVeri){veriListesi.remove(silinecekVeri);}

    public ObservableList<KaynakVeriler> geriDonusDegeri()
    {
        return veriListesi;
    }

}
