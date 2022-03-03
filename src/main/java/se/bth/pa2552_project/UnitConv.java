package se.bth.pa2552_project;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class UnitConv extends Application {

    TextField fhTextField;
    TextField clTextField;
    TextField mpsTextField;
    TextField kmphTextField;
    TextField minTextField;
    TextField hrsTextField;
    TextField glsTextField;
    TextField ltsTextField;
    TextField grmsTextField;
    TextField ouncesTextField;

    Button tempbtn = new Button("Convert to Celsius");
    Button speedbtn = new Button("Convert to Kmph");
    Button timebtn = new Button("Convert to Hours");
    Button volbtn = new Button("Convert to Litres");
    Button weightbtn = new Button("Convert to Ounces");

    //@Override
    public void start (Stage stage){
        Pane root = new Pane();

        Label tempLabel = new Label("TEMPERATURE");
        tempLabel.relocate(300, 50);
        Label fhLabel = new Label("Fahrenheit");
        fhLabel.relocate(50, 85);
        Label clLabel = new Label("Celsius");
        clLabel.relocate(370, 85);
        fhTextField = new TextField();
        fhTextField.relocate(170, 85);

        tempbtn.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                String fhString = fhTextField.getText();
                double fhval = Double.parseDouble(fhString);
                double clval = (fhval - 32) * 5.0/9.0;
                clTextField.setText(String.format("%.2f", clval));
            }
        });

        clTextField = new TextField();
        clTextField.relocate(420, 85);
        tempbtn.relocate(600,85);


        Label speedLabel = new Label("SPEED");
        speedLabel.relocate(317, 130);
        Label mpsLabel = new Label("mtr/sec");
        mpsLabel.relocate(50, 165);
        Label kmphLabel = new Label("km/hr");
        kmphLabel.relocate(370, 165);
        mpsTextField = new TextField();
        mpsTextField.relocate(170, 165);

        speedbtn.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                String mpsString = mpsTextField.getText();
                double mpsval = Double.parseDouble(mpsString);
                double kmphval = mpsval * 18.0/5.0;
                kmphTextField.setText(String.format("%.2f", kmphval));
            }
        });

        kmphTextField = new TextField();
        kmphTextField.relocate(420, 165);
        speedbtn.relocate(600,165);


        Label timeLabel = new Label("TIME");
        timeLabel.relocate(322, 210);
        Label minLabel = new Label("Minutes");
        minLabel.relocate(50, 245);
        Label hrsLabel = new Label("Hours");
        hrsLabel.relocate(370, 245);
        minTextField = new TextField();
        minTextField.relocate(170, 245);

        timebtn.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                String minString = minTextField.getText();
                double minval = Double.parseDouble(minString);
                double hrsval = minval / 60.0;
                hrsTextField.setText(String.format("%.2f", hrsval));
            }
        });

        hrsTextField = new TextField();
        hrsTextField.relocate(420, 245);
        timebtn.relocate(600,245);


        Label VolLabel = new Label("VOLUME");
        VolLabel.relocate(316, 290);
        Label glsLabel = new Label("Gallons");
        glsLabel.relocate(50, 325);
        Label ltsLabel = new Label("Litres");
        ltsLabel.relocate(370, 325);
        glsTextField = new TextField();
        glsTextField.relocate(170, 325);

        volbtn.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                String glsString = minTextField.getText();
                double glsval = Double.parseDouble(glsString);
                double ltsval = glsval * 3.785;
                ltsTextField.setText(String.format("%.2f", ltsval));
            }
        });

        ltsTextField = new TextField();
        ltsTextField.relocate(420, 325);
        volbtn.relocate(600,325);


        Label WeightLabel = new Label("WEIGHT");
        WeightLabel.relocate(317, 370);
        Label gramsLabel = new Label("Grams");
        gramsLabel.relocate(50, 405);
        Label ouncesLabel = new Label("Ounces");
        ouncesLabel.relocate(370, 405);
        grmsTextField = new TextField();
        grmsTextField.relocate(170, 405);

        weightbtn.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                String grmsString = minTextField.getText();
                double grmsval = Double.parseDouble(grmsString);
                double ouncesval = grmsval * 0.035274;
                ouncesTextField.setText(String.format("%.2f", ouncesval));
            }
        });

        ouncesTextField = new TextField();
        ouncesTextField.relocate(420, 405);
        weightbtn.relocate(600,405);

        root.getChildren().addAll(tempbtn, speedbtn, timebtn, volbtn, weightbtn, tempLabel, speedLabel, timeLabel, VolLabel, WeightLabel, fhLabel, clLabel, mpsLabel, kmphLabel, minLabel, hrsLabel, glsLabel, ltsLabel, gramsLabel, ouncesLabel, fhTextField, clTextField, mpsTextField, kmphTextField, minTextField, hrsTextField, glsTextField, ltsTextField, grmsTextField, ouncesTextField);

        Scene scene = new Scene(root, 850, 500);
        stage.setScene(scene);
        stage.setTitle("Unit Converter");
        stage.show();
    }

    //public static void main(String[] args) {launch(args);

}
