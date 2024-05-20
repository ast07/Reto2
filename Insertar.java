package com.example.retoajedrez;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class Insertar {
    /*
    static {
        try {
            cnx = getConnexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            cnx2 = getConnexion2();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

     */

    private  Connection getConnexion() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/GrupoA";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    private  Connection getConnexion2() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/GrupoB";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public void insertarA(String nombre) throws SQLException {
        Connection cnx = getConnexion();
        FileReader fr;
        Scanner sc = null;
        String palabra="";
        String field;

        try{
            fr = new FileReader(nombre);
            BufferedReader bf = new BufferedReader(fr);
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO Jugador(Ranking,Nombre,Pais,FIDE,FIDEID,Info) VALUES (?,?,?,?,?,?)");
            while((palabra=bf.readLine())!=null){
                sc = new Scanner(palabra);
                sc.useDelimiter(";");
                while(sc.hasNext()){
                    field = sc.next();
                    ps.setString(1,field);
                    field = sc.next();
                    ps.setString(2,field);
                    field = sc.next();
                    ps.setString(3,field);
                    field = sc.next();
                    ps.setString(4,field);
                    field = sc.next();
                    ps.setString(5,field);
                    field = sc.next();
                    ps.setString(6,field);
                    break;
                }
                ps.executeUpdate();
                System.out.println(ps);
            }
            ps.close();
            fr.close();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertarB(String nombre) throws SQLException {
        Connection cnx2 = getConnexion2();
        FileReader fr;
        Scanner sc = null;
        String palabra="";
        String field;

        try{
            fr = new FileReader(nombre);
            BufferedReader bf = new BufferedReader(fr);
            PreparedStatement ps = cnx2.prepareStatement("INSERT INTO Jugador(Ranking,Nombre,Pais,FIDE,FIDEID,Info) VALUES (?,?,?,?,?,?)");
            while((palabra=bf.readLine())!=null){
                sc = new Scanner(palabra);
                sc.useDelimiter(";");
                while(sc.hasNext()){
                    field = sc.next();
                    ps.setString(1,field);
                    field = sc.next();
                    ps.setString(2,field);
                    field = sc.next();
                    ps.setString(3,field);
                    field = sc.next();
                    ps.setString(4,field);
                    field = sc.next();
                    ps.setString(5,field);
                    field = sc.next();
                    ps.setString(6,field);
                    break;
                }
                ps.executeUpdate();
                System.out.println(ps);
            }
            ps.close();
            fr.close();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}


