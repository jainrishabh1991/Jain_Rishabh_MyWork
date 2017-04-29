/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSO;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

/**
 *
 * @author Rishabh
 */
public class FXMLDocumentController implements Initializable {


    @FXML
    private CheckBox sensor1;
    @FXML
    private CheckBox sensor2;
    @FXML
    private CheckBox sensor3;
    @FXML
    private CheckBox sensor4;
    @FXML
    private CheckBox sensor5;
    @FXML
    private CheckBox sensor6;
    @FXML
    private CheckBox sensor7;
    @FXML
    private CheckBox sensor8;
    @FXML
    private CheckBox sensor9;
    @FXML
    private CheckBox sensor10;
    @FXML
    private CheckBox sensor11;
    @FXML
    private CheckBox sensor12;
    @FXML
    private CheckBox sensor13;
    @FXML
    private CheckBox sensor14;
    @FXML
    private CheckBox sensor15;
    @FXML
    private CheckBox sensor16;
    @FXML
    private CheckBox sensor17;
    @FXML
    private CheckBox sensor18;
    @FXML
    private CheckBox sensor19;
    @FXML
    private CheckBox sensor20;
    @FXML
    private CheckBox sensor21;
    @FXML
    private CheckBox sensor22;
    @FXML
    private CheckBox sensor23;
    @FXML
    private CheckBox sensor24;
    @FXML
    private CheckBox sensor25;
    @FXML
    private CheckBox sensor26;
    @FXML
    private CheckBox sensor27;
    @FXML
    private CheckBox sensor28;
    @FXML
    private CheckBox sensor29;
    @FXML
    private CheckBox sensor30;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        <------------------------------->
        Polyline p1 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p1.getPoints().add(new Double(PSO.plotData.get(0).get(i).getxCoordinate()));
            p1.getPoints().add(new Double(PSO.plotData.get(0).get(i).getyCoordinate()));
        }

        PathTransition pt1 = new PathTransition();

        pt1.setDuration(Duration.seconds(25));
        pt1.setNode(sensor1);
        pt1.setPath(p1);
        pt1.play();
        
        //        <------------------------------->
        Polyline p2 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p2.getPoints().add(new Double(PSO.plotData.get(1).get(i).getxCoordinate()));
            p2.getPoints().add(new Double(PSO.plotData.get(1).get(i).getyCoordinate()));
        }

        PathTransition pt2 = new PathTransition();

        pt2.setDuration(Duration.seconds(25));
        pt2.setNode(sensor2);
        pt2.setPath(p2);
        pt2.play();
        
        //        <------------------------------->
        Polyline p3 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p3.getPoints().add(new Double(PSO.plotData.get(2).get(i).getxCoordinate()));
            p3.getPoints().add(new Double(PSO.plotData.get(2).get(i).getyCoordinate()));
        }

        PathTransition pt3 = new PathTransition();

        pt3.setDuration(Duration.seconds(25));
        pt3.setNode(sensor3);
        pt3.setPath(p3);
        pt3.play();
        
        //        <------------------------------->
        Polyline p4 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p4.getPoints().add(new Double(PSO.plotData.get(3).get(i).getxCoordinate()));
            p4.getPoints().add(new Double(PSO.plotData.get(3).get(i).getyCoordinate()));
        }

        PathTransition pt4 = new PathTransition();

        pt4.setDuration(Duration.seconds(25));
        pt4.setNode(sensor4);
        pt4.setPath(p4);
        pt4.play();
        
        //        <------------------------------->
        Polyline p5 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p5.getPoints().add(new Double(PSO.plotData.get(4).get(i).getxCoordinate()));
            p5.getPoints().add(new Double(PSO.plotData.get(4).get(i).getyCoordinate()));
        }

        PathTransition pt5 = new PathTransition();

        pt5.setDuration(Duration.seconds(25));
        pt5.setNode(sensor5);
        pt5.setPath(p5);
        pt5.play();
        
        //        <------------------------------->
        Polyline p6 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p6.getPoints().add(new Double(PSO.plotData.get(5).get(i).getxCoordinate()));
            p6.getPoints().add(new Double(PSO.plotData.get(5).get(i).getyCoordinate()));
        }

        PathTransition pt6 = new PathTransition();

        pt6.setDuration(Duration.seconds(25));
        pt6.setNode(sensor6);
        pt6.setPath(p6);
        pt6.play();
        
        //        <------------------------------->
        Polyline p7 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p7.getPoints().add(new Double(PSO.plotData.get(6).get(i).getxCoordinate()));
            p7.getPoints().add(new Double(PSO.plotData.get(6).get(i).getyCoordinate()));
        }

        PathTransition pt7 = new PathTransition();

        pt7.setDuration(Duration.seconds(25));
        pt7.setNode(sensor7);
        pt7.setPath(p7);
        pt7.play();
        
        //        <------------------------------->
        Polyline p8 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p8.getPoints().add(new Double(PSO.plotData.get(7).get(i).getxCoordinate()));
            p8.getPoints().add(new Double(PSO.plotData.get(7).get(i).getyCoordinate()));
        }

        PathTransition pt8 = new PathTransition();

        pt8.setDuration(Duration.seconds(25));
        pt8.setNode(sensor8);
        pt8.setPath(p8);
        pt8.play();
        
        //        <------------------------------->
        Polyline p9 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p9.getPoints().add(new Double(PSO.plotData.get(8).get(i).getxCoordinate()));
            p9.getPoints().add(new Double(PSO.plotData.get(8).get(i).getyCoordinate()));
        }

        PathTransition pt9 = new PathTransition();

        pt9.setDuration(Duration.seconds(25));
        pt9.setNode(sensor9);
        pt9.setPath(p9);
        pt9.play();
        
        //        <------------------------------->
        Polyline p10 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p10.getPoints().add(new Double(PSO.plotData.get(9).get(i).getxCoordinate()));
            p10.getPoints().add(new Double(PSO.plotData.get(9).get(i).getyCoordinate()));
        }

        PathTransition pt10 = new PathTransition();

        pt10.setDuration(Duration.seconds(25));
        pt10.setNode(sensor10);
        pt10.setPath(p10);
        pt10.play();
        
        //        <------------------------------->
        Polyline p11 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p11.getPoints().add(new Double(PSO.plotData.get(10).get(i).getxCoordinate()));
            p11.getPoints().add(new Double(PSO.plotData.get(10).get(i).getyCoordinate()));
        }

        PathTransition pt11 = new PathTransition();

        pt11.setDuration(Duration.seconds(25));
        pt11.setNode(sensor11);
        pt11.setPath(p11);
        pt11.play();
        
        //        <------------------------------->
        Polyline p12 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p12.getPoints().add(new Double(PSO.plotData.get(11).get(i).getxCoordinate()));
            p12.getPoints().add(new Double(PSO.plotData.get(11).get(i).getyCoordinate()));
        }

        PathTransition pt12 = new PathTransition();

        pt12.setDuration(Duration.seconds(25));
        pt12.setNode(sensor12);
        pt12.setPath(p12);
        pt12.play();
        
        //        <------------------------------->
        Polyline p13 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p13.getPoints().add(new Double(PSO.plotData.get(12).get(i).getxCoordinate()));
            p13.getPoints().add(new Double(PSO.plotData.get(12).get(i).getyCoordinate()));
        }

        PathTransition pt13 = new PathTransition();

        pt13.setDuration(Duration.seconds(25));
        pt13.setNode(sensor13);
        pt13.setPath(p13);
        pt13.play();
        
        //        <------------------------------->
        Polyline p14 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p14.getPoints().add(new Double(PSO.plotData.get(13).get(i).getxCoordinate()));
            p14.getPoints().add(new Double(PSO.plotData.get(13).get(i).getyCoordinate()));
        }

        PathTransition pt14 = new PathTransition();

        pt14.setDuration(Duration.seconds(25));
        pt14.setNode(sensor14);
        pt14.setPath(p14);
        pt14.play();
        
        //        <------------------------------->
        Polyline p15 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p15.getPoints().add(new Double(PSO.plotData.get(14).get(i).getxCoordinate()));
            p15.getPoints().add(new Double(PSO.plotData.get(14).get(i).getyCoordinate()));
        }

        PathTransition pt15 = new PathTransition();

        pt15.setDuration(Duration.seconds(25));
        pt15.setNode(sensor15);
        pt15.setPath(p15);
        pt15.play();
        
        //        <------------------------------->
        Polyline p16 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p16.getPoints().add(new Double(PSO.plotData.get(15).get(i).getxCoordinate()));
            p16.getPoints().add(new Double(PSO.plotData.get(15).get(i).getyCoordinate()));
        }

        PathTransition pt16 = new PathTransition();

        pt16.setDuration(Duration.seconds(25));
        pt16.setNode(sensor16);
        pt16.setPath(p16);
        pt16.play();
        
        //        <------------------------------->
        Polyline p17 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p17.getPoints().add(new Double(PSO.plotData.get(16).get(i).getxCoordinate()));
            p17.getPoints().add(new Double(PSO.plotData.get(16).get(i).getyCoordinate()));
        }

        PathTransition pt17 = new PathTransition();

        pt17.setDuration(Duration.seconds(25));
        pt17.setNode(sensor17);
        pt17.setPath(p17);
        pt17.play();
        
        //        <------------------------------->
        Polyline p18 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p18.getPoints().add(new Double(PSO.plotData.get(17).get(i).getxCoordinate()));
            p18.getPoints().add(new Double(PSO.plotData.get(17).get(i).getyCoordinate()));
        }

        PathTransition pt18 = new PathTransition();

        pt18.setDuration(Duration.seconds(25));
        pt18.setNode(sensor18);
        pt18.setPath(p18);
        pt18.play();
        
        //        <------------------------------->
        Polyline p19 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p19.getPoints().add(new Double(PSO.plotData.get(18).get(i).getxCoordinate()));
            p19.getPoints().add(new Double(PSO.plotData.get(18).get(i).getyCoordinate()));
        }

        PathTransition pt19 = new PathTransition();

        pt19.setDuration(Duration.seconds(25));
        pt19.setNode(sensor19);
        pt19.setPath(p19);
        pt19.play();
        
        //        <------------------------------->
        Polyline p20 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p20.getPoints().add(new Double(PSO.plotData.get(19).get(i).getxCoordinate()));
            p20.getPoints().add(new Double(PSO.plotData.get(19).get(i).getyCoordinate()));
        }

        PathTransition pt20 = new PathTransition();

        pt20.setDuration(Duration.seconds(25));
        pt20.setNode(sensor20);
        pt20.setPath(p20);
        pt20.play();
        
        //        <------------------------------->
        Polyline p21 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p21.getPoints().add(new Double(PSO.plotData.get(20).get(i).getxCoordinate()));
            p21.getPoints().add(new Double(PSO.plotData.get(20).get(i).getyCoordinate()));
        }

        PathTransition pt21 = new PathTransition();

        pt21.setDuration(Duration.seconds(25));
        pt21.setNode(sensor21);
        pt21.setPath(p21);
        pt21.play();
        
        //        <------------------------------->
        Polyline p22 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p22.getPoints().add(new Double(PSO.plotData.get(21).get(i).getxCoordinate()));
            p22.getPoints().add(new Double(PSO.plotData.get(21).get(i).getyCoordinate()));
        }

        PathTransition pt22 = new PathTransition();

        pt22.setDuration(Duration.seconds(25));
        pt22.setNode(sensor22);
        pt22.setPath(p22);
        pt22.play();
        
        //        <------------------------------->
        Polyline p23 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p23.getPoints().add(new Double(PSO.plotData.get(22).get(i).getxCoordinate()));
            p23.getPoints().add(new Double(PSO.plotData.get(22).get(i).getyCoordinate()));
        }

        PathTransition pt23 = new PathTransition();

        pt23.setDuration(Duration.seconds(25));
        pt23.setNode(sensor23);
        pt23.setPath(p23);
        pt23.play();
        
        //        <------------------------------->
        Polyline p24 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p24.getPoints().add(new Double(PSO.plotData.get(23).get(i).getxCoordinate()));
            p24.getPoints().add(new Double(PSO.plotData.get(23).get(i).getyCoordinate()));
        }

        PathTransition pt24 = new PathTransition();

        pt24.setDuration(Duration.seconds(25));
        pt24.setNode(sensor24);
        pt24.setPath(p24);
        pt24.play();
        
        //        <------------------------------->
        Polyline p25 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p25.getPoints().add(new Double(PSO.plotData.get(24).get(i).getxCoordinate()));
            p25.getPoints().add(new Double(PSO.plotData.get(24).get(i).getyCoordinate()));
        }

        PathTransition pt25 = new PathTransition();

        pt25.setDuration(Duration.seconds(25));
        pt25.setNode(sensor25);
        pt25.setPath(p25);
        pt25.play();
        
        //        <------------------------------->
        Polyline p26 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p26.getPoints().add(new Double(PSO.plotData.get(25).get(i).getxCoordinate()));
            p26.getPoints().add(new Double(PSO.plotData.get(25).get(i).getyCoordinate()));
        }

        PathTransition pt26 = new PathTransition();

        pt26.setDuration(Duration.seconds(25));
        pt26.setNode(sensor26);
        pt26.setPath(p26);
        pt26.play();
        
        //        <------------------------------->
        Polyline p27 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p27.getPoints().add(new Double(PSO.plotData.get(26).get(i).getxCoordinate()));
            p27.getPoints().add(new Double(PSO.plotData.get(26).get(i).getyCoordinate()));
        }

        PathTransition pt27 = new PathTransition();

        pt27.setDuration(Duration.seconds(25));
        pt27.setNode(sensor27);
        pt27.setPath(p27);
        pt27.play();
        
        //        <------------------------------->
        Polyline p28 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p28.getPoints().add(new Double(PSO.plotData.get(27).get(i).getxCoordinate()));
            p28.getPoints().add(new Double(PSO.plotData.get(27).get(i).getyCoordinate()));
        }

        PathTransition pt28 = new PathTransition();

        pt28.setDuration(Duration.seconds(25));
        pt28.setNode(sensor28);
        pt28.setPath(p28);
        pt28.play();
        
        //        <------------------------------->
        Polyline p29 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p29.getPoints().add(new Double(PSO.plotData.get(28).get(i).getxCoordinate()));
            p29.getPoints().add(new Double(PSO.plotData.get(28).get(i).getyCoordinate()));
        }

        PathTransition pt29 = new PathTransition();

        pt29.setDuration(Duration.seconds(25));
        pt29.setNode(sensor29);
        pt29.setPath(p29);
        pt29.play();
        
         //        <------------------------------->
        Polyline p30 = new Polyline();
        for(int i=0;i<PSO.plotData.get(0).size();i++){
            p30.getPoints().add(new Double(PSO.plotData.get(29).get(i).getxCoordinate()));
            p30.getPoints().add(new Double(PSO.plotData.get(29).get(i).getyCoordinate()));
        }

        PathTransition pt30 = new PathTransition();

        pt30.setDuration(Duration.seconds(25));
        pt30.setNode(sensor30);
        pt30.setPath(p30);
        pt30.play();
        
    }

}
