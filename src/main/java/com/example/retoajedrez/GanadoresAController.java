package com.example.retoajedrez;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;

public class GanadoresAController /*implements Initializable*/ {

    static Connection cnx;

    static {
        try {
            cnx = getConnexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnexion() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/grupoa";
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private ObservableList<Jugador> premiosA;// = FXCollections.observableArrayList();

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, Integer> colRanking;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, Integer> colRankingFinal;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, String> colNombre;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, String> colFideID;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, String> colPremios;

    @FXML
    private TableView<Jugador> tblganadoresA;


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
    private void ganadoresA(ActionEvent event) throws SQLException, FileNotFoundException {
        Functions.ganadoresA(cnx);
       /* premiosA.addAll(Functions.tblGanadores(cnx));
        this.tblganadoresA.setItems(premiosA)
        */
        initialize(tblganadoresA,Functions.tblGanadores(cnx));
        Functions.imprimirA(cnx);
    }

    public void initialize(TableView<Jugador> tabla, ObservableList<Jugador> observa) {
        premiosA = FXCollections.observableArrayList();

        this.colRanking.setCellValueFactory(new PropertyValueFactory<>("Ranking"));
        this.colRankingFinal.setCellValueFactory(new PropertyValueFactory<>("rankingFinal"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colFideID.setCellValueFactory(new PropertyValueFactory<>("fideId"));
        this.colPremios.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tabla.setItems(observa);

    }
}