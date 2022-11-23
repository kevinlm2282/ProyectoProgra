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

import models.Estudiante;
import utils.utilEstudiante;

public class RegistroEstudiante implements Initializable{

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnRegistro;

    @FXML
    private TableColumn<Estudiante, String> colApellidos;

    @FXML
    private TableColumn<Estudiante, String>colCI;

    @FXML
    private TableColumn<Estudiante, Integer>colCelular;

    @FXML
    private TableColumn<Estudiante, String> colNombre;

    @FXML
    private TableView<Estudiante> tblEstudiante;

    @FXML
    private TextField tfApellido;

    @FXML
    private TextField tfCelular;

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
    void registrar(ActionEvent event) throws NumberFormatException, SQLException {
        Estudiante estudiante = new Estudiante(tfNombre.getText(), tfApellido.getText(), tfCi.getText(), Integer.parseInt(tfCelular.getText()));
        estudiante.registrarDatosEstudiante(tfNombre.getText(), tfApellido.getText(), tfCi.getText(), Integer.parseInt(tfCelular.getText()));
    }

    void leer(){
        String nombre=""; String apellido=""; String ci=""; Integer celular=0;
        Estudiante estudiante = new Estudiante(nombre, apellido, ci, celular);

        try {
            this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellido"));
            this.colCI.setCellValueFactory(new PropertyValueFactory("ci"));
            this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
            this.colCelular.setCellValueFactory(new PropertyValueFactory("celular"));
            ObservableList<Estudiante> items = estudiante.getEstudiantes();
            this.tblEstudiante.setItems(items);            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        leer();       
        
    }
    

}
