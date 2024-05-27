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
import javafx.scene.control.TableCell;
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

public class OpenAController implements Initializable {

    private ObservableList<com.example.retoajedrez.Jugador> jugadoresA;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, Integer> colRanking;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, String> colNombre;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, String> colPais;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, Integer> colFide;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, String> colFideID;

    @FXML
    private TableColumn<com.example.retoajedrez.Jugador, String> colInfo;

    @FXML
    private TableView<com.example.retoajedrez.Jugador> tblJugadoresA;

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
        jugadoresA = FXCollections.observableArrayList();

        f.insertarA("C:/Users/Juan Karl/IdeaProjects/RetoAjedrez/src/main/resources/com/example/retoajedrez/CSV/LibroA.csv");
        //f.insertarA("/home/ALU1J/IdeaProjects/RetoAjedrez/src/main/resources/com/example/retoajedrez/CSV/LibroA.csv");
        jugadoresA.addAll(f.tableA());

        this.tblJugadoresA.setItems(jugadoresA);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jugadoresA = FXCollections.observableArrayList();

        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colFide.setCellValueFactory(new PropertyValueFactory<>("fide"));
        this.colFideID.setCellValueFactory(new PropertyValueFactory<>("fideId"));
        this.colRanking.setCellValueFactory(new PropertyValueFactory<>("ranking"));
        this.colPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        this.colInfo.setCellValueFactory(new PropertyValueFactory<>("info"));

        this.tblJugadoresA.setItems(jugadoresA);
        
    }
}
