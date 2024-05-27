/*

$USER_HOME$\AppData\Local\SceneBuilder\SceneBuilder.exe

 */
package com.example.retoajedrez;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Functions {
    static Connection cnx; static Connection cnx2;

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

    private static Connection getConnexion() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/grupoa";
        String user = "root";
        String password = "Debian";
        return DriverManager.getConnection(url, user, password);
    }

    private static Connection getConnexion2() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/grupob";
        String user = "root";
        String password = "Debian";
        return DriverManager.getConnection(url, user, password);
    }

    public static void insertarA(String nombre){
        FileReader fr;
        Scanner sc = null;
        String palabra="";
        String field;

        try{
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE FROM Jugador;");
            stmt.close();

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

    public static void insertarB(String nombre){
        FileReader fr;
        Scanner sc = null;
        String palabra="";
        String field;

        try{
            Statement stmt = cnx2.createStatement();
            stmt.executeUpdate("DELETE FROM Jugador;");
            stmt.close();


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

    public static void optarA() throws SQLException {
        PreparedStatement ps = cnx.prepareStatement("INSERT INTO JugadorOptaPremio(Tipo,Ranking,Nombre,FIDEID,Descalificado) VALUES (?,?,?,?,?)");
        Statement st = cnx.createStatement();
        boolean flag = st.execute("SELECT * FROM Jugador");

        if(flag){
            System.out.println("Insertando registros... \n");
            ResultSet rs = st.getResultSet();
            while(rs.next()){
                if(Integer.parseInt(rs.getString("FIDE"))<2200){
                    String info = rs.getString("Info");
                    if(!info.equals("NULL")){
                        ps.setString(1,"General,SUB2200,SUB2400," + info);
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }else{
                        ps.setString(1,"General,SUB2200,SUB2400");
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }
                }else if(Integer.parseInt(rs.getString("FIDE"))>2200 && Integer.parseInt(rs.getString("FIDE"))<2400){
                    String info = rs.getString("Info");
                    if(!info.equals("NULL")){
                        ps.setString(1,"General,SUB2400," + info);
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }else{
                        ps.setString(1,"General,SUB2400");
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }
                }else{
                    String info = rs.getString("Info");
                    if(!info.equalsIgnoreCase("NULL")){
                        ps.setString(1,"General," + info);
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }else{
                        ps.setString(1,"General");
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }
                }
                System.out.println(ps);
                ps.executeUpdate();
            }
            ps.close();
            rs.close();
            st.close();
        }
    }

    public static void optarB() throws SQLException {
        PreparedStatement ps = cnx2.prepareStatement("INSERT INTO JugadorOptaPremio(Tipo,Ranking,Nombre,FIDEID,Descalificado) VALUES (?,?,?,?,?)");
        Statement st = cnx2.createStatement();
        boolean flag = st.execute("SELECT * FROM Jugador");

        if(flag){
            System.out.println("Insertando datos... \n");
            ResultSet rs = st.getResultSet();
            while(rs.next()){
                if(Integer.parseInt(rs.getString("FIDE"))<1400){
                    String info = rs.getString("Info");
                    if(!info.equalsIgnoreCase("NULL")){
                        ps.setString(1,"General,1400,1600,1800," + info);
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }else{
                        ps.setString(1,"General,1400,1600,1800");
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }
                }else if(Integer.parseInt(rs.getString("FIDE"))>1400 && Integer.parseInt(rs.getString("FIDE"))<1600){
                    String info = rs.getString("Info");
                    if(!info.equalsIgnoreCase("NULL")){
                        ps.setString(1,"General,1600,1800," + info);
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }else{
                        ps.setString(1,"General,1600,1800");
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }
                }else if(Integer.parseInt(rs.getString("FIDE"))<1600 && Integer.parseInt(rs.getString("FIDE"))<1800){
                    String info = rs.getString("Info");
                    if(!info.equalsIgnoreCase("NULL")){
                        ps.setString(1,"General,1800," + info);
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }else{
                        ps.setString(1,"General,1800");
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }
                }else{
                    String info = rs.getString("Info");
                    if(!info.equalsIgnoreCase("NULL")){
                        ps.setString(1,"General," + info);
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }else{
                        ps.setString(1,"General");
                        ps.setString(2,rs.getString("Ranking"));
                        ps.setString(3,rs.getString("Nombre"));
                        ps.setString(4,rs.getString("FIDEID"));
                        ps.setString(5,"Not");
                    }
                }
                System.out.println(ps);
                ps.executeUpdate();
            }
            ps.close();
            rs.close();
            st.close();
        }
    }

    public static void ganadoresA() throws SQLException {
        FileReader fr;
        Scanner sc = null;
        String palabra="";
        String field;

        try{
            fr = new FileReader("/home/ALU1J/Descargas/GrupoA/RankingFinalA.csv");
            BufferedReader bf = new BufferedReader(fr);
            PreparedStatement ps = cnx.prepareStatement("UPDATE JugadorOptaPremio SET RankingFinal = ? WHERE Ranking = ?");
            while((palabra=bf.readLine())!=null){
                sc = new Scanner(palabra);
                sc.useDelimiter(";");
                while(sc.hasNext()){
                    field = sc.next();
                    ps.setInt(1,Integer.parseInt(field));
                    field = sc.next();
                    ps.setInt(2,Integer.parseInt(field));
                    break;
                }
                System.out.println(ps);
                ps.executeUpdate();
            }
            ps.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int contadorGeneral=0; //Max:12
        int contadorCV=0; //Max:5
        int contadorHotel=0; //Max:20
        int contador2400=0; //Max:4
        int contador2200=0; //Max:2

        Statement st = cnx.createStatement();
        boolean flag= st.execute("SELECT * FROM JugadorOptaPremio ORDER BY RankingFinal asc");



    }

    public ObservableList<Jugador> tableA() throws SQLException {
        Statement st = cnx.createStatement();
        boolean flag = st.execute("SELECT * FROM Jugador ORDER BY Ranking ASC");
        ObservableList<Jugador> jugadoresA = FXCollections.observableArrayList();

        if(flag){
            ResultSet rs = st.getResultSet();
            int ranking;
            String nombre;
            String pais;
            String fide;
            String fideId;
            String info;
            while(rs.next()){
                ranking = rs.getInt("Ranking");
                nombre = rs.getString("Nombre");
                pais = rs.getString("Pais");
                fide = rs.getString("FIDE");
                fideId = rs.getString("FIDEID");
                info = rs.getString("Info");

                Jugador j = new Jugador(ranking,nombre,pais,fide,fideId,info);
                jugadoresA.add(j);
            }
        }
        return jugadoresA;
    }

    public static void ganadoresB() throws SQLException {
        int contadorGeneral=0; //Max:12
        int contadorCV=0; //Max:5
        int contadorHotel=0; //Max:20
        int contador2400=0; //Max:4
        int contador2200=0; //Max:2

        Statement st = cnx2.createStatement();
        boolean flag= st.execute("SELECT * FROM JugadorOptaPremio");

        FileReader fr;
        Scanner sc = null;
        String palabra="";
        String field;

        try{
            fr = new FileReader("/home/ALU1J/Descargas/GrupoB/RankingFinalB.csv");
            BufferedReader bf = new BufferedReader(fr);
            PreparedStatement ps = cnx2.prepareStatement("UPDATE JugadorOptaPremio SET RankingFinal = ? WHERE Ranking = ?");
            while((palabra=bf.readLine())!=null){
                sc = new Scanner(palabra);
                sc.useDelimiter(";");

                while(sc.hasNext()){
                    field = sc.next();
                    ps.setInt(1,Integer.parseInt(field));
                    field = sc.next();
                    ps.setInt(2,Integer.parseInt(field));
                    break;
                }
                System.out.println(ps);
                ps.executeUpdate();
            }
            ps.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Jugador> tableB() throws SQLException {
        Statement st = cnx2.createStatement();
        boolean flag = st.execute("SELECT * FROM Jugador ORDER BY Ranking ASC");
        ObservableList<Jugador> jugadoresB = FXCollections.observableArrayList();

        if(flag){
            ResultSet rs = st.getResultSet();
            int ranking;
            String nombre;
            String pais;
            String fide;
            String fideId;
            String info;
            while(rs.next()){
                ranking = rs.getInt("Ranking");
                nombre = rs.getString("Nombre");
                pais = rs.getString("Pais");
                fide = rs.getString("FIDE");
                fideId = rs.getString("FIDEID");
                info = rs.getString("Info");

                Jugador j = new Jugador(ranking,nombre,pais,fide,fideId,info);
                jugadoresB.add(j);
            }
        }
        return jugadoresB;
    }


    public static void main(String[] args) throws SQLException, FileNotFoundException {
       //Functions.imprimir();

         Functions.ganadoresA();
         Functions.ganadoresB();
    }

    public static void imprimir() throws SQLException, FileNotFoundException {
        Statement st = cnx.createStatement();
        boolean flag= st.execute("SELECT * FROM JugadorOptaPremio");
        PrintWriter pw;

        if(flag){
            pw = new PrintWriter(new FileOutputStream("jugadoresGrupoA.txt"));
            ResultSet rs = st.getResultSet();
            while(rs.next()){
                System.out.println("Nombre: "+rs.getString("Nombre") + " ---> Premios Optados: " + rs.getString("Tipo") + ".");
                pw.println("Nombre: "+rs.getString("Nombre") + " ---> Premios Optados: " + rs.getString("Tipo") + ".");
                pw.println("-----------------------------------------------------------------------------------------------------------------");
            }
            pw.close();
            rs.close();
            st.close();
        }

        Statement st2 = cnx2.createStatement();
        boolean flag2= st2.execute("SELECT * FROM JugadorOptaPremio");
        PrintWriter pw2;

        if(flag2){
            pw2 = new PrintWriter(new FileOutputStream("jugadoresGrupoB.txt"));
            ResultSet rs2 = st2.getResultSet();
            while(rs2.next()){
                System.out.println("Nombre: "+rs2.getString("Nombre") + " ---> Premios Optados: " + rs2.getString("Tipo") + ".");
                pw2.println("Nombre: "+rs2.getString("Nombre") + " ---> Premios Optados: " + rs2.getString("Tipo") + ".");
                pw2.println("-----------------------------------------------------------------------------------------------------------------");
            }
            pw2.close();
            rs2.close();
            st2.close();
        }
    }



}