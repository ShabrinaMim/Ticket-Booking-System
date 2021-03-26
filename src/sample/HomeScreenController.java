package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


import static sample.Client.searchedBus;

public class HomeScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField start;

    @FXML
    private TextField end;

    @FXML
    private DatePicker dates;

    @FXML
    private Button search;

    @FXML
    private ComboBox<String>  from = new ComboBox<>();

    @FXML
    private ComboBox<String> to = new ComboBox<>();

    @FXML
    private Button back;

    @FXML
    void initialize() {
        assert start != null : "fx:id=\"start\" was not injected: check your FXML file 'HomeScreen.fxml'.";
        assert end != null : "fx:id=\"end\" was not injected: check your FXML file 'HomeScreen.fxml'.";
        assert dates != null : "fx:id=\"dates\" was not injected: check your FXML file 'HomeScreen.fxml'.";
        assert search != null : "fx:id=\"search\" was not injected: check your FXML file 'HomeScreen.fxml'.";

    }

   public void insideManager(Client loginManager){
       from.getItems().addAll("Chittagong","Dhaka","Panchagarh","Rajshahi","Rangpur","Sylhet");
       to.getItems().addAll("Chittagong","Dhaka","Panchagarh","Rajshahi","Rangpur","Sylhet");
       search.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent event){
                String date = dates.getValue().toString();
                System.out.println(date);
                System.out.println(from.getValue()+ to.getValue());
                BusSearch b = new BusSearch(from.getValue(), to.getValue(),date);
                loginManager.boss.write(b);
                Object o = loginManager.boss.read();
                if(o instanceof BusList){
                    BusList bbb = (BusList)o;
                    searchedBus = bbb.getBuslist();
                }
                /*try{
                    String[]s ={"ab","bc"};
                    Bus b = new Bus("a","b","c","d","v",s);
                    searchedBus = busList.searchBus(date,start.getText(),end.getText());
                    busList.getBuslist().add(b);

                }catch (NullPointerException e){
                    System.out.println("There is no available buses.");
                    e.printStackTrace();
                }*/
                loginManager.showBusListScreen();

                for(int i=0; i<searchedBus.size(); i++){
                    System.out.println(searchedBus.get(i).getName());
                }
        }});
       back.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
           @Override
           public void handle(javafx.event.ActionEvent event) {
               loginManager.showLoginScreen();
           }});
    }}
