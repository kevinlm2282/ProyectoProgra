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
    String nombre=""; String apellido=""; String ci=""; Integer celular=0;Integer idEstudiante=0;
    Estudiante estudiante = new Estudiante(nombre, apellido, ci, celular,idEstudiante);

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
        ObservableList<Estudiante> obsEstudiante = estudiante.getEstudiantes();
        System.out.println("linea 49: "+estudiante.getIdEstudiante());
        this.comEstudiante.setItems(obsEstudiante);
    }

    @FXML
    void consultar(ActionEvent event) {
        String[] idEstudianteCadena =  comEstudiante.getValue().toString().split("-");
            System.out.println("se busco el id: "+idEstudianteCadena[0]);
            leer(idEstudianteCadena[0]);
            tblEstudiante.refresh();
            leer(idEstudianteCadena[0]);
    }

    void leer(String idBuscar){
        String idCurso=""; String idEstudiante=""; double valor=0.0;
        Calificaciones calificaciones = new Calificaciones(valor,idCurso,idEstudiante);

        try {
            this.colMateria.setCellValueFactory(new PropertyValueFactory("idcurso"));
            this.colNota.setCellValueFactory(new PropertyValueFactory("valor"));
            ObservableList<Calificaciones> items = calificaciones.getCalificaciones(idBuscar);
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
            leer("1");
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
