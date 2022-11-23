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
import javafx.stage.Stage;
import models.Estudiante;

public class EstudianteController implements Initializable{

    @FXML
    private TableColumn<?, ?> colMateria;

    @FXML
    private TableColumn<?, ?> colNota;

    @FXML
    private ComboBox<Estudiante> comEstudiante;

    @FXML
    private TableView<?> tblEstudiante;

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
