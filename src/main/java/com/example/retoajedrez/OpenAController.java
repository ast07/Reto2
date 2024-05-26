package com.example.retoajedrez;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OpenAController extends Application  /*implements Initializable*/ {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    private ObservableList<Jugador> jugadores;

    @FXML
    private TableColumn<Jugador, ?> colRanking;

    @FXML
    private TableColumn<Jugador, ?> colRankingFinal;

    @FXML
    private TableColumn<Jugador, ?> colPremios;

    @FXML
    private TableColumn<Jugador, ?> colNombre;

    @FXML
    private TableColumn<Jugador, ?> colFide;

    @FXML
    private TableColumn<Jugador, ?> colPais;

    @FXML
    private TableColumn<Jugador, ?> colInfo;

    @FXML
    private TableColumn<Jugador, ?> colFideID;

    @FXML
    private TableColumn<Jugador, ?> colDesc;

    @FXML
    private TableView<Jugador> tblposiblespremiosa;

    @FXML
    private TableView<Jugador> tblJugadoresA;


    @FXML
    private void cerrarVentana(ActionEvent event) {

        Stage currentStage = (Stage) ((Window) ((Node) event.getSource()).getScene().getWindow());
        currentStage.close();
    }


    @FXML
    private void irAlMenu(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Página_Menu.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Menú BenidormChess");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagenes/Logito.png")));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage) ((Window) ((Node) event.getSource()).getScene().getWindow());
            currentStage.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irAPosiblesPremiosA(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PosiblesPremiosA.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Posibles Premios Open A BenidormChess");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagenes/Logito.png")));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage) ((Window) ((Node) event.getSource()).getScene().getWindow());
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void importarA(ActionEvent event) throws SQLException {
        Functions f = new Functions();
        ObservableList<Jugador> jugadores = null;

        f.insertarA("C:/Users/Juan Karl/IdeaProjects/RetoAjedrez/src/main/resources/com/example/retoajedrez/CSV/LibroA.csv");


        //jugadores.addAll(f.tableA());

        //this.tblJugadoresA.setItems(jugadores);

    }

   /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colFide.setCellValueFactory(new PropertyValueFactory<>("fide"));
        this.colFideID.setCellValueFactory(new PropertyValueFactory<>("fideID"));
        this.colPremios.setCellValueFactory(new PropertyValueFactory<>("premios"));
        this.colRanking.setCellValueFactory(new PropertyValueFactory<>("ranking"));
        this.colPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
    }*/
}
