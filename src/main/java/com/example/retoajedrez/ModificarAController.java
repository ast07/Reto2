package com.example.retoajedrez;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ModificarAController implements Initializable {

    static Connection cnx;

    static {
        try {
            cnx = getConnexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnexion() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/GrupoA";
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtFIDEID;
    @FXML
    private TextField txtRanking;

    @FXML
    private TextField txtRankingFinal;
    @FXML
    private TextField premios;

    @FXML
    private TextField cvh;
    private Jugador jugador;

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnSalir;

    private ObservableList<Jugador> jugadores;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void initAtributtes(ObservableList<Jugador> jugadores, Jugador jugador) {
        this.jugadores = jugadores;
        this.jugador = jugador;
        // cargo los datos de la persona
        this.txtNombre.setText(this.jugador.getNombre());
        this.txtFIDEID.setText(this.jugador.getFide());
        this.txtRanking.setText(String.valueOf(this.jugador.getRanking()));
        this.txtRankingFinal.setText(String.valueOf(this.jugador.getRankingFinal()));
        this.premios.setText(this.jugador.getTipo());
        this.cvh.setText(this.jugador.getInfo());

    }

    public Jugador getJugador() {
        return jugador;
    };



    @FXML
    private void guardar(ActionEvent event) throws SQLException {

        // Cojo los datos
        String nombre = this.txtNombre.getText();
        String fIDEID = this.txtFIDEID.getText();
        String premios = this.premios.getText();
        int ranking = Integer.parseInt(this.txtRanking.getText());
        int rankingFinal = Integer.parseInt(this.txtRankingFinal.getText());



        // Creo la persona
        Jugador j = new Jugador(nombre,ranking,rankingFinal,premios,fIDEID);

        // Compruebo si la persona existe
        if (!jugadores.contains(j)) {

            // Modificar
            if (this.jugador != null) {
                PreparedStatement ps = cnx.prepareStatement("update grupoa.jugadoroptapremio set nombre = ?, FIDEID = ?, Ranking= ?, RankingFinal=?, Tipo = ? where FIDEID = ?");
                ps.setString(1, nombre);
                ps.setString(2, fIDEID);
                ps.setInt(3, ranking);
                ps.setInt(4,rankingFinal);
                ps.setString(5,premios);
                ps.setString(6,this.jugador.getFideId());
                ps.executeUpdate();
                ps.close();

                // Modifico el objeto
                this.jugador.setNombre(nombre);
                this.jugador.setFideId(fIDEID);
                this.jugador.setRanking(ranking);
                this.jugador.setRankingFinal(rankingFinal);
                this.jugador.setTipo(premios);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha modificado correctamente");
                alert.showAndWait();

            }

            // Cerrar la ventana
            Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La persona ya existe");
            alert.showAndWait();
        }
    }

    @FXML
    private void salir(ActionEvent event) {
        this.jugador = null;
        // Cerrar la ventana
        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
    }


}
