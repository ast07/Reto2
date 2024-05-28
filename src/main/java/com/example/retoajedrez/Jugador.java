package com.example.retoajedrez;

import java.util.Objects;

public class Jugador {
    private String nombre;
    private int ranking;
    private int rankingFinal;
    private String tipo;
    private String fideId;
    private String info;
    private String pais;
    private String fide;
    private String desc;


    public Jugador(String nombre, int ranking, int rankingFinal, String tipo, String fideId) {
        this.nombre = nombre;
        this.ranking = ranking;
        this.rankingFinal = rankingFinal;
        this.tipo = tipo;
        this.fideId = fideId;
        this.desc = "Not";
    }

    public Jugador(int ranking, String nombre, String pais, String fide, String fideId, String info) {
        this.nombre = nombre;
        this.ranking = ranking;
        this.fideId = fideId;
        this.pais = pais;
        this.fide = fide;
        this.info = info;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getRankingFinal() {
        return rankingFinal;
    }

    public void setRankingFinal(int rankingFinal) {
        this.rankingFinal = rankingFinal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFideId() {
        return fideId;
    }

    public void setFideId(String fideId) {
        this.fideId = fideId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFide() {
        return fide;
    }

    public void setFide(String fide) {
        this.fide = fide;
    }

    public String getDesc() {return desc;}

    public void setDesc(String desc) {this.desc = desc;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;
        return ranking == jugador.ranking && rankingFinal == jugador.rankingFinal && Objects.equals(nombre, jugador.nombre) && Objects.equals(tipo, jugador.tipo) && Objects.equals(fideId, jugador.fideId) && Objects.equals(info, jugador.info) && Objects.equals(pais, jugador.pais) && Objects.equals(fide, jugador.fide) && Objects.equals(desc, jugador.desc);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nombre);
        result = 31 * result + ranking;
        result = 31 * result + rankingFinal;
        result = 31 * result + Objects.hashCode(tipo);
        result = 31 * result + Objects.hashCode(fideId);
        result = 31 * result + Objects.hashCode(info);
        result = 31 * result + Objects.hashCode(pais);
        result = 31 * result + Objects.hashCode(fide);
        result = 31 * result + Objects.hashCode(desc);
        return result;
    }
}
