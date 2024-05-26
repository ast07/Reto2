package com.example.retoajedrez;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

public class OpenBController extends Application {

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
    private TableColumn<com.example.retoajedrez.Jugador, ?> colRankingFinal;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, ?> colPremios;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, ?> colNombre;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, ?> colFide;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, ?> colPais;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, ?> colInfo;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, ?> colFideID;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, ?> colDesc;

    @FXML
    private TableView<Jugador> tblposiblespremiosa;

    @FXML
    private TableView<Jugador> tblJugadoresA;



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

            Stage currentStage = (Stage) ((Window) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
            currentStage.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irAPosiblesPremiosB(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PosiblesPremiosB.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Posibles Premios Open B BenidormChess");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagenes/Logito.png")));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage) ((Window) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void importarB(ActionEvent event) throws SQLException {
        Functions f = new Functions();

        f.insertarB("C:/Users/Juan Karl/IdeaProjects/RetoAjedrez/src/main/resources/com/example/retoajedrez/CSV/LibroB.csv");


    }

    @FXML
    private void optarB(ActionEvent event) throws SQLException {
        Functions f = new Functions();
        ObservableList<Jugador> jugadores = null;

        f.optarB();

    }

}
