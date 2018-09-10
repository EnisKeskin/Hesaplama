package Hesaplamalarım;

import Hesaplamalarım.Verilerim.KaynakVeriler;
import Hesaplamalarım.Verilerim.KaynakVerilerinDepolanması;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javax.swing.text.ChangedCharSetException;
import java.io.IOException;

public class Controller {

    @FXML
    private ListView<KaynakVeriler> kayıtMekanı;

    @FXML
    private JFXTextField txt3dk;

    @FXML
    private JFXTextField txt5dk;

    @FXML
    private JFXTextField txt1sa;

    @FXML
    private JFXTextField txt2sa;

    @FXML
    private JFXTextField txt4sa;

    @FXML
    private JFXTextField txt12sa;

    @FXML
    private JFXTextField txt1g;

    @FXML
    private JFXTextField txt3g;

    @FXML
    private Label lbldk;

    @FXML
    private Label lblsaat;

    @FXML
    private Label lblgun;

    @FXML
   private void Hesapla() //Buttona basılınca hesaplanacak veri
    {
        int donusenler[]=donusumler();
        float hesaplamam;
        hesaplamam= (donusenler[0]*3)+
                    (donusenler[1]*5)+
                    (donusenler[2]*60)+
                    (donusenler[3]*120)+
                    (donusenler[4]*240)+
                    (donusenler[5]*720)+
                    (donusenler[6]*1440)+
                    (donusenler[7]*4320);
        lbldk.setText(String.valueOf(hesaplamam));
        lblsaat.setText(String.valueOf(hesaplamam/60));
        lblgun.setText(String.valueOf(hesaplamam/(60*24)));
    }
    @FXML
    private void Sil() //Buttona basılınca silinecek veri
    {
        txt3dk.clear();
        txt5dk.clear();
        txt1sa.clear();
        txt2sa.clear();
        txt4sa.clear();
        txt12sa.clear();
        txt1g.clear();
        txt3g.clear();
        lblgun.setText("0");
        lblsaat.setText("0");
        lbldk.setText("0");
    }
    @FXML
    void Kaydet(ActionEvent event) //Buttona basılınca Kayıt Gerçekleşecek
    {
        if(degerKontrol()==true) {
            yazmaIslemi();
        }
        else {
            alarm();
        }
    }
    @FXML
    void silinecekVeri(ActionEvent event)
    {
        Sil();
        KaynakVeriler secilenVeri=kayıtMekanı.getSelectionModel().getSelectedItem();
        KaynakVerilerinDepolanması.getInstance().veriSil(secilenVeri);

    }
    private void yazmaIslemi()
    {
        String dk3=txt3dk.getText().trim();
        String dk5=txt5dk.getText().trim();
        String sa1=txt1sa.getText().trim();
        String sa2=txt2sa.getText().trim();
        String sa4=txt4sa.getText().trim();
        String sa12=txt12sa.getText().trim();
        String gun1=txt1g.getText().trim();
        String gun3=txt3g.getText().trim();
        KaynakVeriler yazmaIsslemi=new KaynakVeriler(dk3,dk5,sa1,sa2,sa4,sa12,gun1,gun3);
        KaynakVerilerinDepolanması.getInstance().yeniVeriYaz(yazmaIsslemi);
    }
    private int[] donusumler()
    {
        int veriDonusenler[] = new int[8];
           if(degerKontrol()==true)
           {
            veriDonusenler[0] = Integer.parseInt(txt3dk.getText());
            veriDonusenler[1] = Integer.parseInt(txt5dk.getText());
            veriDonusenler[2] = Integer.parseInt(txt1sa.getText());
            veriDonusenler[3] = Integer.parseInt(txt2sa.getText());
            veriDonusenler[4] = Integer.parseInt(txt4sa.getText());
            veriDonusenler[5] = Integer.parseInt(txt12sa.getText());
            veriDonusenler[6] = Integer.parseInt(txt1g.getText());
            veriDonusenler[7] = Integer.parseInt(txt3g.getText());
            return veriDonusenler;
        }
       else
            {
               alarm();
        }
        return veriDonusenler;
    }
    public void initialize()throws IOException
    {
        kayıtMekanı.setItems(KaynakVerilerinDepolanması.getInstance().geriDonusDegeri());
        kayıtMekanı.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<KaynakVeriler>() {
            @Override
            public void changed(ObservableValue<? extends KaynakVeriler> observable, KaynakVeriler oldValue, KaynakVeriler newValue) {
                if(newValue!=null)
                {
                    KaynakVeriler secilenOgeler=kayıtMekanı.getSelectionModel().getSelectedItem();
                    txt3dk.setText(secilenOgeler.getDk3());
                    txt5dk.setText(secilenOgeler.getDk5());
                    txt1sa.setText(secilenOgeler.getSaat1());
                    txt2sa.setText(secilenOgeler.getSaat2());
                    txt4sa.setText(secilenOgeler.getSaat4());
                    txt12sa.setText(secilenOgeler.getSaat12());
                    txt1g.setText(secilenOgeler.getGun1());
                    txt3g.setText(secilenOgeler.getGun3());
                    Hesapla();
                }
            }
        });
    }

    private boolean degerKontrol()
    {
        if(txt3dk.getText().trim().isEmpty()==true)
        {
            return false;
        }
        else if (txt5dk.getText().trim().isEmpty()==true)
        {
            return false;
        }
            else if(txt1sa.getText().trim().isEmpty()==true)
        {
            return false;
        }
        else if(txt2sa.getText().trim().isEmpty()==true)
        {
            return false;
        }
        else if(txt4sa.getText().trim().isEmpty()==true)
        {
            return false;
        }
        else if(txt12sa.getText().trim().isEmpty()==true)
        {
            return false;
        }
        else if (txt1g.getText().trim().isEmpty()==true)
        {
            return false;
        }
        else if(txt3g.getText().trim().isEmpty()==true)
        {
            return false;
        }

        return true;
    }

    private void alarm()
    {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Boş Bırakma");
        alert.setContentText("Boş Bırakma");
        alert.showAndWait();
    }
}

