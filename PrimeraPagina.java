package com.example.retoajedrez;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.stage.Window;
import javafx.stage.FileChooser;
import java.io.File;

import java.io.IOException;
import java.sql.SQLException;

public class PrimeraPagina extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PrimeraPagina.class.getResource("Página_Inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 700);
        stage.setTitle("Programa BenidormChess");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagenes/Logito.png")));
        stage.setResizable(false);
        scene.setFill(Color.WHITE);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {

        Stage currentStage = (Stage) ((Window) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
        currentStage.close();
    }

    @FXML
        private void irAlMenu(ActionEvent event) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Página_Menu.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Programa BenidormChess");
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
    private void irAInicio(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Página_Inicio.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Programa BenidormChess");
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
            stage.setTitle("Programa BenidormChess");
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
        private void irAOpenB(ActionEvent event) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OpenB.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Programa BenidormChess");
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
    private void irAPremiosA(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PremiosA.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Programa BenidormChess");
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
    private void irAPremiosB(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PremiosB.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Programa BenidormChess");
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
    private void importarA(ActionEvent event) throws SQLException {
        Insertar insertar = new Insertar();

        insertar.insertarB("/home/ALU1J/IdeaProjects/RetoAjedrez/src/main/resources/com/example/retoajedrez/CSV/LibroA.csv");
    }


    @FXML
    private void importarB(ActionEvent event) throws SQLException {
        Insertar insertar = new Insertar();

        insertar.insertarB("/home/ALU1J/IdeaProjects/RetoAjedrez/src/main/resources/com/example/retoajedrez/CSV/LibroB.csv");
    }

}

