package com.example.retoajedrez;

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

public class GanadoresBController {

    static Connection cnx;

    static {
        try {
            cnx = getConnexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnexion() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/grupob";
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private ObservableList<Jugador> premiosB;// = FXCollections.observableArrayList();

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
    private TableView<Jugador> tblganadoresB;


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

            Stage currentStage = (Stage) ((Window) ((Node) event.getSource()).getScene().getWindow());
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ganadoresB(ActionEvent event) throws SQLException, FileNotFoundException {
        Functions.ganadoresB(cnx);
       /* premiosA.addAll(Functions.tblGanadores(cnx));
        this.tblganadoresA.setItems(premiosA)
        */
        initialize(tblganadoresB,Functions.tblGanadores(cnx));
        Functions.imprmirB(cnx);
    }


    public void initialize(TableView<Jugador> table,ObservableList<Jugador> observa ) {
        premiosB = FXCollections.observableArrayList();

        this.colRanking.setCellValueFactory(new PropertyValueFactory<>("Ranking"));
        this.colRankingFinal.setCellValueFactory(new PropertyValueFactory<>("rankingFinal"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colFideID.setCellValueFactory(new PropertyValueFactory<>("fideId"));
        this.colPremios.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        table.setItems(observa);

    }

}