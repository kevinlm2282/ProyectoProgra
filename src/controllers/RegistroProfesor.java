package controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Docente;

public class RegistroProfesor implements Initializable{

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TableColumn<Docente, String> colApellido;

    @FXML
    private TableColumn<Docente, String> colCi;

    @FXML
    private TableColumn<Docente, String> colNombre;

    @FXML
    private TableView<Docente> tblProfesor;

    @FXML
    private TextField tfApellido;

    @FXML
    private TextField tfCi;

    @FXML
    private TextField tfNombre;

    @FXML
    void irAtras(ActionEvent event) {
        Stage stage = (Stage) this.btnAtras.getScene().getWindow();
        stage.close();
    }

    @FXML
    void registrarProfesor(ActionEvent event) throws SQLException {
        Docente docente = new Docente(null, null, null, null, null, null);
        docente.registrarDatosProfesor(tfNombre.getText(), tfApellido.getText(), tfNombre.getText());
        tblProfesor.refresh();
        leer();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            leer();
    }
    void leer(){
        String nombre=""; String apellido=""; String ci=""; Integer celular=0;
        Docente docente = new Docente(nombre, apellido, ci, celular, apellido, ci);

        try {
            this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
            this.colCi.setCellValueFactory(new PropertyValueFactory("ci"));
            this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
            ObservableList<Docente> items = docente.getDocentes();
            this.tblProfesor.setItems(items);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
