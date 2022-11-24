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
import javafx.stage.Stage;
import models.Estudiante;

public class Profesor implements Initializable{

    @FXML
    private Button btnAtras;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colNota;

    @FXML
    private ComboBox<Estudiante> combEstudiante;

    @FXML
    private TableView<?> tblProfesor;

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
