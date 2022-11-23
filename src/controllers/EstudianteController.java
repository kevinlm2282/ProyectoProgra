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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Calificaciones;
import models.Estudiante;

public class EstudianteController implements Initializable{

    @FXML
    private TableColumn<Calificaciones, String> colMateria;

    @FXML
    private TableColumn<Calificaciones, String> colNota;

    @FXML
    private Button btnConsultar;

    @FXML
    private ComboBox<Estudiante> comEstudiante;

    @FXML
    private TableView<Calificaciones> tblEstudiante;

    @FXML
    private Button tbnSalir;

    @FXML
    void irSalir(ActionEvent event) {
        Stage stage = (Stage) this.tbnSalir.getScene().getWindow();
        stage.close();
    }
    public void initCombox() throws SQLException{
        String nombre=""; String apellido=""; String ci=""; Integer celular=0;
        Estudiante estudiante = new Estudiante(nombre, apellido, ci, celular);
        ObservableList<Estudiante> obsEstudiante = estudiante.getEstudiantes();
        this.comEstudiante.setItems(obsEstudiante);
    }

    @FXML
    void consultar(ActionEvent event) {
        leer();
    }

    void leer(){
        int idCurso=0; int idEstudiante=0; double valor=0.0;
        Calificaciones calificaciones = new Calificaciones(valor,idCurso,idEstudiante);

        try {
            this.colMateria.setCellValueFactory(new PropertyValueFactory("idCurso"));
            this.colNota.setCellValueFactory(new PropertyValueFactory("valor"));
            ObservableList<Calificaciones> items = calificaciones.getCalificaciones(null);
            this.tblEstudiante.setItems(items);            
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
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
