package com.example.proyecto2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MainController {

    @FXML
    Button btnClonar;
    @FXML
    Button btnEvaluar;
    @FXML
    Button btnTop3;
    @FXML
    Button btnNuevaEncuesta;
    @FXML
    Button btnCancelarCuestionario;
    @FXML
    Button btnGuardarPregunta;
    @FXML
    Button btnAgregarPregunta;
    @FXML
    Button btnModificarPregunta;
    @FXML
    Button btnTerminarPreguntas;
    @FXML
    Button btnBorrarPregunta;
    @FXML
    Pane panelMenuPrincipal;
    @FXML
    Pane panelNuevaEncuesta;
    @FXML
    Pane panelDetalleCuestionario;
    @FXML
    TextField txtNombreCuestionario;
    @FXML
    TextField txtDescripcionCuestionario;
    @FXML
    TextField txtPregunta;
    @FXML
    TextField txtLimiteTiempo;
    @FXML
    TextField txtRespuestaPregunta;
    @FXML
    TextField txtPunteo;

    @FXML
    Pane panelAgregarPregunta;
    @FXML
    TableView tvCuestionarios;
    @FXML
    TableColumn tcCorrelativo;
    @FXML
    TableColumn tcPin;
    @FXML
    TableColumn tcNombre;

    @FXML
    TableColumn tcDescripcion;

    @FXML
    TableView tvPreguntas;
    @FXML
    TableColumn tcCorrelativoPreguntas;
    @FXML
    TableColumn tcPregunta;
    @FXML
    TableColumn tcRespuesta;
    @FXML
    TableColumn tcTiempo;
    @FXML
    TableColumn tcPunteo;

    public void initialize(){
        tcCorrelativo.setCellValueFactory(new PropertyValueFactory<Cuestionario, Integer>("correlativo"));
        tcPin.setCellValueFactory(new PropertyValueFactory<Cuestionario, Integer>("pin"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<Cuestionario, String>("nombre"));
        tcDescripcion.setCellValueFactory(new PropertyValueFactory<Cuestionario, String>("descripcion"));
        ObservableList<Cuestionario> datos = FXCollections.observableArrayList(VariablesCuestionario.vCuestionario);
        tvCuestionarios.setItems(datos);


        tcCorrelativoPreguntas.setCellValueFactory(new PropertyValueFactory<Pregunta, Integer>("correlativo"));
        tcPregunta.setCellValueFactory(new PropertyValueFactory<Pregunta, String>("pregunta"));
        tcRespuesta.setCellValueFactory(new PropertyValueFactory<Pregunta, String>("respuesta"));
        tcTiempo.setCellValueFactory(new PropertyValueFactory<Pregunta, String>("tiempoLimite"));
        tcPunteo.setCellValueFactory(new PropertyValueFactory<Pregunta, String>("punteo"));
        ObservableList<Pregunta> datosPregunta = FXCollections.observableArrayList(VariablesCuestionario.vPregunta);
        tvPreguntas.setItems(datosPregunta);

    }

    public void onMainButtonClick(ActionEvent actionEvent){
        if (actionEvent.getSource() == btnNuevaEncuesta){
            panelNuevaEncuesta.toFront();
        }
        if (actionEvent.getSource() == btnCancelarCuestionario){
            panelMenuPrincipal.toFront();
        }
        if (actionEvent.getSource() == btnAgregarPregunta){
            panelAgregarPregunta.toFront();
        }
        if (actionEvent.getSource() == btnTerminarPreguntas){
            tvPreguntas.getItems().clear();
            tvPreguntas.refresh();
            panelMenuPrincipal.toFront();
        }
    }

    public void onClickAgregar(ActionEvent actionEvent){
        String nombre = txtNombreCuestionario.getText();
        String descripcion = txtDescripcionCuestionario.getText();

        Cuestionario cuestionario = new Cuestionario(nombre,descripcion);

        VariablesCuestionario.vCuestionario.add(cuestionario);

        txtNombreCuestionario.setText("");
        txtDescripcionCuestionario.setText("");

        ObservableList<Cuestionario> datos = FXCollections.observableArrayList(VariablesCuestionario.vCuestionario);
        tvCuestionarios.setItems(datos);

        panelDetalleCuestionario.toFront();
        }


        public void onClickRemover(ActionEvent actionEvent){
        ObservableList<Pregunta> todos, individual;
        todos=tvPreguntas.getItems();
        individual=tvPreguntas.getSelectionModel().getSelectedItems();
        individual.forEach(todos::remove);
        }

        public void onClickAgregarPregunta(ActionEvent actionEvent){
            String pregunta = txtPregunta.getText();
            String tiempo = txtLimiteTiempo.getText();
            String respuesta = txtRespuestaPregunta.getText();
            String punteo = txtPunteo.getText();

            Pregunta pregunta1 = new Pregunta(pregunta, tiempo, respuesta, punteo);

            VariablesCuestionario.vPregunta.add(pregunta1);

            txtPregunta.setText("");
            txtLimiteTiempo.setText("");
            txtRespuestaPregunta.setText("");
            txtPunteo.setText("");

            ObservableList<Pregunta> datosPregunta = FXCollections.observableArrayList(VariablesCuestionario.vPregunta);
            tvPreguntas.setItems(datosPregunta);

            panelDetalleCuestionario.toFront();

        }

}