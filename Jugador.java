package com.example.retoajedrez;

public class Jugador {
    private String nombre;
    private String ranking;
    private String pais;
    private String Fide;
    private String FideId;
    private String Info;


    public Jugador(String nombre, String ranking, String pais, String fide, String fideId, String info) {
        this.nombre = nombre;
        this.ranking = ranking;
        this.pais = pais;
        this.Fide = fide;
        this.FideId = fideId;
        this.Info = info;

    }

    public Jugador(String ranking, String nombre, String fide, String fideId) {
        this.ranking = ranking;
        this.nombre = nombre;
        this.Fide = fide;
        this.FideId = fideId;

    }

    public String getNombre() {
        return nombre;
    }

    public String getRanking() {
        return ranking;
    }

    public String getPais() {
        return pais;
    }

    public String getFide() {
        return Fide;
    }

    public String getFideId() {
        return FideId;
    }

    public String getInfo() {
        return Info;
    }
}
