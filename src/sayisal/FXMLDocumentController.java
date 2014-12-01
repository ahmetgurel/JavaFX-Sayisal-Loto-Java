/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sayisal;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

/**
 *
 * @author Ahmet
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Button btn;
    @FXML
    private Label s1;
    @FXML
    private Label s2;
    @FXML
    private Label s3;
    @FXML
    private Label s4;
    @FXML
    private Label s5;
    @FXML
    private Label s6;
    @FXML
    private Ellipse daire1;
    @FXML
    private Ellipse daire2;
    @FXML
    private Ellipse daire3;
    @FXML
    private Ellipse daire4;
    @FXML
    private Ellipse daire5;
    @FXML
    private Ellipse daire6;
    private int say=0;
    @FXML
    private Button siralaBtn;
    private int [] dizi=new int [6];
    @FXML
    private Button renkdegis;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        renkdegistir(null);
        siralaBtn.setDisable(true);
        daire1.setOpacity(0.3);
        daire2.setOpacity(0.3);
        daire3.setOpacity(0.3);
        daire4.setOpacity(0.3);
        daire5.setOpacity(0.3);
        daire6.setOpacity(0.3);
        int rasSayi;      
        for (int i = 0; i < dizi.length; i++) {
            rasSayi=(int)(Math.random()*49)+1;
            if (i==0) {
                dizi[i]=rasSayi;
            } else {
                for (int j = 0; j < dizi.length; j++) {
                    if (dizi[j]==rasSayi) {
                        rasSayi=(int)(Math.random()*49)+1;                     
                        j=0;
                    }                    
                }
            }
            dizi[i]=rasSayi; 
        }   
        
        s1.setText(""+dizi[0]);
        s2.setText(""+dizi[1]);
        s3.setText(""+dizi[2]);
        s4.setText(""+dizi[3]);
        s5.setText(""+dizi[4]);
        s6.setText(""+dizi[5]);
    }   
    @FXML
    private void basla(ActionEvent event) {
                
   
        say++;   
        switch (say) {
            case 1 :
                
                dondurBuyut (s1);
                tasi(s1);
                seffaflastir(daire1);
                btn.setText("2. Sayı Gelsin");
                break;
            case 2 :
                dondurBuyut (s2);
                tasi(s2);
                seffaflastir(daire2);
                btn.setText("3. Sayı Gelsin");
                break;
            case 3 :
                dondurBuyut (s3);
                tasi(s3);
                seffaflastir(daire3);
                btn.setText("4. Sayı Gelsin");
                break;
            case 4 :
                dondurBuyut (s4);
                tasi(s4);
                seffaflastir(daire4);
                btn.setText("5. Sayı Gelsin");
                break;
            case 5 :
                dondurBuyut (s5);
                tasi(s5);
                seffaflastir(daire5);
                btn.setText("6. Sayı Gelsin");
                break;
            case 6 :
                dondurBuyut (s6);
                tasi(s6);
                seffaflastir(daire6);  
                btn.setText(" ");
                btn.setDisable(true);
                siralaBtn.setDisable(false);
                break;        
        }    
    }
    @FXML
    private void sirala(ActionEvent event) {
        int tut;
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi.length-1; j++) {
                if (dizi[j]>dizi[j+1]) {
                    tut=dizi[j];
                    dizi[j]=dizi[j+1];
                    dizi[j+1]=tut;
                }                
            }            
        }
        
        s1.setText(""+dizi[0]);
        s2.setText(""+dizi[1]);
        s3.setText(""+dizi[2]);
        s4.setText(""+dizi[3]);
        s5.setText(""+dizi[4]);
        s6.setText(""+dizi[5]);
    }

                
    public static void dondurBuyut (Label lbl) {
        RotateTransition dondur=new RotateTransition(Duration.millis(1000),lbl);
        dondur.setByAngle(360f);
        dondur.setCycleCount(5);
        dondur.setAutoReverse(false);
        ScaleTransition st=new ScaleTransition(Duration.millis(2000), lbl);
        st.setToX(1.5f);
        st.setToY(1.5f);
        st.setCycleCount(2);
        st.setAutoReverse(true);
        SequentialTransition sirala= new SequentialTransition();
        sirala.getChildren().addAll(dondur, st);
        sirala.setCycleCount(1);
        sirala.play();
                
    }
    public static void seffaflastir (Ellipse daire) {
        FadeTransition sef=new FadeTransition(Duration.millis(1000),daire);
        sef.setFromValue(0.3);
        sef.setToValue(1.0);
        sef.setCycleCount(1);
        sef.setAutoReverse(false);
        sef.play();
    }
    public static void tasi (Label lbl) {
        TranslateTransition ts=new TranslateTransition (Duration.millis(4000),lbl);
        ts.setFromY(-60);
        ts.setToY(315);
        ts.setCycleCount(1);
        ts.setAutoReverse(false);
        ts.play();
    }
    
    

@FXML
    private void renkdegistir(ActionEvent event) 
    {
        Random r = new Random();
        int[] deger=new int[18];
        int ton;
        for (int i = 0 ; i < 18 ; i ++)
        {
            ton=r.nextInt(256);
            deger[i]=ton;
        }
        daire1.setFill(Color.rgb(deger[0],deger[1],deger[2]));
        daire2.setFill(Color.rgb(deger[3],deger[4],deger[5]));
        daire3.setFill(Color.rgb(deger[6],deger[7],deger[8]));
        daire4.setFill(Color.rgb(deger[9],deger[10],deger[11]));
        daire5.setFill(Color.rgb(deger[12],deger[13],deger[14]));
        daire6.setFill(Color.rgb(deger[15],deger[16],deger[17]));            
    }


}
