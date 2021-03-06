package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConfirmationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button busname;

    @FXML
    private Button time;

    @FXML
    private Button selectedseats;

    @FXML
    private Button price;

    @FXML
    private TextField mobile;

    @FXML
    private Button confirm;

    @FXML
    private Button back;

    @FXML
    private Button fromto;

    @FXML
    private Button busdate;

    public void initialManager(Client client, Bus b,int sctsetas,String ss){
        fromto.setText(b.getStart()+" to "+b.getDestination());
        busdate.setText(b.getDate());
        busname.setText(b.getName());
        time.setText(b.getTime());
        selectedseats.setText(Integer.toString(sctsetas));
        int p = Integer.parseInt(b.getPrice())*sctsetas;
        String s = "Tk. "+p;
        price.setText(s);
        back.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                cancel c = new cancel(b,ss,"cancel");
                client.boss.write(c);
                client.showSeatPlan(b);
            }});

    }
    @FXML
    void initialize() {
        assert busname != null : "fx:id=\"busname\" was not injected: check your FXML file 'Cofirmation.fxml'.";
        assert time != null : "fx:id=\"time\" was not injected: check your FXML file 'Cofirmation.fxml'.";
        assert selectedseats != null : "fx:id=\"selectedseats\" was not injected: check your FXML file 'Cofirmation.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'Cofirmation.fxml'.";
        assert mobile != null : "fx:id=\"mobile\" was not injected: check your FXML file 'Cofirmation.fxml'.";
        assert confirm != null : "fx:id=\"confirm\" was not injected: check your FXML file 'Cofirmation.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'Cofirmation.fxml'.";

    }
}
