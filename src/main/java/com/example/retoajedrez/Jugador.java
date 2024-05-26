package com.example.retoajedrez;

import javafx.collections.ObservableList;

import java.util.Objects;

public class Jugador {
    private ObservableList<Jugador> jugadores;
    private String nombre;
    private int ranking;
    private int rankingFinal;
    private String tipo;
    private String FideId;
    private String Info;
    private String pais;
    private String Fide;
    private enum descalificado{Yes, Not};


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return ranking == jugador.ranking && rankingFinal == jugador.rankingFinal && Objects.equals(jugadores, jugador.jugadores) && Objects.equals(nombre, jugador.nombre) && Objects.equals(tipo, jugador.tipo) && Objects.equals(FideId, jugador.FideId) && Objects.equals(Info, jugador.Info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ranking, FideId, Info);
    }

    public Jugador(String nombre, int ranking, int rankingFinal, String tipo, String fideId, String info, ObservableList<Jugador> jugadores) {
        this.nombre = nombre;
        this.ranking = ranking;
        this.rankingFinal = rankingFinal;
        this.tipo = tipo;
        FideId = fideId;
        Info = info;
        this.jugadores = jugadores;
    }

    public Jugador(String nombre, int ranking, int rankingFinal, String tipo, String fideId, String info) {
        this.nombre = nombre;
        this.ranking = ranking;
        this.rankingFinal = rankingFinal;
        this.tipo = tipo;
        FideId = fideId;
        Info = info;
    }

    public Jugador(String nombre, int ranking, String fideId, String pais, String fide, String info) {
        this.nombre = nombre;
        this.ranking = ranking;
        this.FideId = fideId;
        this.pais = pais;
        this.Fide = fide;
        this.Info = info;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public int getRankingFinal() {
        return rankingFinal;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFideId() {
        return FideId;
    }

    public String getInfo() {
        return Info;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setRankingFinal(int rankingFinal) {
        this.rankingFinal = rankingFinal;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFideId(String fideId) {
        FideId = fideId;
    }

    public void setInfo(String info) {
        Info = info;
    }
}
