package com.example.retoajedrez;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

import static javafx.application.Application.launch;

public class OpenAPremioController implements Initializable {

    public static void main(String[] args) {
        launch(args);
    }

    private ObservableList<com.example.retoajedrez.Jugador> jugadoresposiblespremiosA;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, Integer> colRanking;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, Integer> colRankingFinal;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, String> colPremios;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, String> colNombre;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, String> colFideID;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, String> colInfo;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, String> colDesc;

    @FXML
    private TableView<Jugador> tblposiblespremiosA;

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
    private void optarA(ActionEvent event) throws SQLException {
        Functions.actualizarRankingFinal();

        Functions f = new Functions();
        ObservableList<Jugador> jugadores = null;

        jugadoresposiblespremiosA.addAll(f.tbloptapremiosA());

        this.tblposiblespremiosA.setItems(jugadoresposiblespremiosA);

        f.optarA();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jugadoresposiblespremiosA = FXCollections.observableArrayList();

        this.colRanking.setCellValueFactory(new PropertyValueFactory<>("ranking"));
        this.colRankingFinal.setCellValueFactory(new PropertyValueFactory<>("rankingfinal"));
        this.colPremios.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colFideID.setCellValueFactory(new PropertyValueFactory<>("fideId"));
        this.colInfo.setCellValueFactory(new PropertyValueFactory<>("info"));
        this.colDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));

        // jugadoresposiblespremiosA.addAll(f.tableA());

        //this.tblposiblespremiosA.setItems(jugadoresposiblespremiosA);

    }
}
