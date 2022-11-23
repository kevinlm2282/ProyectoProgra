package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Label lbResultado;

    @FXML
    private TextField tfTitulo;

    @FXML
    private TextField tfTitulo2;

    @FXML
    void btnOnClicked(ActionEvent event) {
        Stage mainWindow = (Stage) tfTitulo.getScene().getWindow();
        Stage mainWindow2 = (Stage) tfTitulo2.getScene().getWindow();

        Stage mainWindow3 = (Stage) lbResultado.getScene().getWindow();

        int title = Integer.parseInt(tfTitulo.getText());
        int title1 = Integer.parseInt(tfTitulo2.getText());

        String title3 = String.valueOf(title+title1);

        lbResultado.setText(title3);
        mainWindow.setTitle(title3);
    }

}
