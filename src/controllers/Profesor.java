package controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Calificaciones;
import models.Estudiante;

public class Profesor implements Initializable{

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnRegistro;

    @FXML
    private TableColumn<Calificaciones, String> colApellido;

    @FXML
    private TableColumn<Calificaciones, String> colNombre;

    @FXML
    private TableColumn<Calificaciones, Double> colNota;

    @FXML
    private ComboBox<Estudiante> combEstudiante;

    @FXML
    private TableView<Calificaciones> tblProfesor;

    @FXML
    private TextField tfValor;

    @FXML
    void irAtras(ActionEvent event) {
        Stage stage = (Stage) this.btnAtras.getScene().getWindow();
        stage.close();
    }

    public void initCombox() throws SQLException{
        String nombre=""; String apellido=""; String ci=""; Integer celular=0;Integer idEstudiante=0;
        Estudiante estudiante = new Estudiante(nombre,apellido,ci,celular,idEstudiante);
        ObservableList<Estudiante> obsEstudiante = estudiante.getEstudiantes();
        this.combEstudiante.setItems(obsEstudiante);
    }

    void leer(){
        String nombre=""; String apellido=""; double valor=0.0;
        Calificaciones calificaciones = new Calificaciones(nombre,apellido,valor);

        try {
            this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
            this.colNota.setCellValueFactory(new PropertyValueFactory("valor"));
            this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
            ObservableList<Calificaciones> items2 = calificaciones.getCalificacionesNombres();
            this.tblProfesor.setItems(items2);            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        try {
            initCombox();
            leer();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @FXML
    void registrar(ActionEvent event) throws SQLException {
        Calificaciones calificaciones = new Calificaciones(null, null, 0);
        String[] idEstudianteCadena =  combEstudiante.getValue().toString().split("-");
        System.out.println("se busco el id: "+idEstudianteCadena[0]);
        calificaciones.registrarCalificaciones(tfValor.getText(), "1", idEstudianteCadena[0]);
        tblProfesor.refresh();
        leer();
    }

}
