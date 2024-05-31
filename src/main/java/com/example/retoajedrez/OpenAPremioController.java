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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class OpenAPremioController implements Initializable {

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
    private TableColumn<com.example.retoajedrez.Jugador, String> colDesc;

    @FXML
    private TableView<Jugador> tblposiblespremiosA;

    @FXML
    private TextField txtcaldesc;

    @FXML
    private TextField nombre;

    @FXML
    private TextField fideid;

    @FXML
    private TextField premios;

    @FXML
    private TextField ranking;

    @FXML
    private TextField rankingfinal;

    private Jugador jugador;

    private ObservableList<Jugador> jugadores;

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
    private void irAOpenA(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OpenA.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Open A BenidormChess");
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
    private void irAModificarA(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModificarA.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Modificar A BenidormChess");
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
    private void modificarA(ActionEvent event) {
        Jugador seleccionarJugador = tblposiblespremiosA.getSelectionModel().getSelectedItem();

        if (seleccionarJugador == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un jugador.");
            alert.showAndWait();
        } else {

            String descalificado = txtcaldesc.getText();
            if (!descalificado.equalsIgnoreCase("Not") && !descalificado.equalsIgnoreCase("Yes")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Solo puedes introducir 'Not' o 'Yes'.");
                alert.showAndWait();
            } else {
                try {
                    seleccionarJugador.setDesc(descalificado);
                    tblposiblespremiosA.refresh();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("No se pudo actualizar el jugador.");
                    alert.showAndWait();
                }
            }
        }
    }


    @FXML
    private void irAGanadoresA(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GanadoresA.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ganadores Open A BenidormChess");
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
    private void optarA(ActionEvent event) throws SQLException {
        Functions.optarA(cnx);
       // Functions.actualizar("C:/Users/Juan Karl/IdeaProjects/RetoDeloscojones/src/main/resources/com/example/retoajedrez/CSV/RankingFinalA.csv", cnx);
        Functions.actualizar("C:\\Users\\adri1\\Downloads\\RetoDeloscojones\\src\\main\\resources\\com\\example\\retoajedrez\\CSV\\RankingFinalA.csv", cnx);

        jugadoresposiblespremiosA.addAll(Functions.tbloptapremios(cnx));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jugadoresposiblespremiosA = FXCollections.observableArrayList();

        this.colRanking.setCellValueFactory(new PropertyValueFactory<>("Ranking"));
        this.colRankingFinal.setCellValueFactory(new PropertyValueFactory<>("rankingFinal"));
        this.colPremios.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colFideID.setCellValueFactory(new PropertyValueFactory<>("fideId"));
        this.colDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));

        cargarBaseDatos();
    }

    private void cargarBaseDatos() {
        try {
            jugadoresposiblespremiosA.addAll(Functions.tbloptapremios(cnx));
            this.tblposiblespremiosA.setItems(jugadoresposiblespremiosA);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
