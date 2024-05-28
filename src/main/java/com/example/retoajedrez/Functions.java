package com.example.retoajedrez;

import javafx.collections.FXCollections; import javafx.collections.ObservableList;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Functions {
    public static void insertar(String nombre, Connection cnx){
        FileReader fr; Scanner sc = null; String palabra=""; String field;

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


    public static void optarA(Connection cnx) throws SQLException {
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

    public static void optarB(Connection cnx) throws SQLException {
        PreparedStatement ps = cnx.prepareStatement("INSERT INTO JugadorOptaPremio(Tipo,Ranking,Nombre,FIDEID,Descalificado) VALUES (?,?,?,?,?)");
        Statement st = cnx.createStatement();
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
                }else if(Integer.parseInt(rs.getString("FIDE"))>1600 && Integer.parseInt(rs.getString("FIDE"))<1800){
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

    public static void actualizar(String nombre, Connection cnx){
        FileReader fr;
        Scanner sc = null;
        String palabra="";
        String field;

        try{
            fr = new FileReader(nombre);
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
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void ganadoresA(Connection cnx) throws SQLException {
        int contadorGeneral=0; //Max:12
        int contadorCV=0; //Max:5
        int contadorHotel=0; //Max:20
        int contador2400=0; //Max:4
        int contador2200=0; //Max:2

        Statement st = cnx.createStatement();
        boolean flag= st.execute("SELECT * FROM JugadorOptaPremio ORDER BY RankingFinal asc, Tipo asc");

        if(flag){
            ResultSet rs = st.getResultSet();
            while(rs.next()){
                String[] optar = rs.getString("Tipo").split(",");
                ArrayList<String> premios = new ArrayList<>();

                String hotel = "";
                String cv = "";
                for(int i=0; i<optar.length; i++){
                    if(optar[i].equals("CVH")){
                        cv = optar[i].substring(0,2);
                        hotel = optar[i].substring(2,3);
                        premios.add(cv);
                        premios.add(hotel);
                    }else {
                        premios.add(optar[i]);
                    }
                }

                System.out.print("Nombre: " + rs.getString("Nombre") + " ");

                premios.forEach((num)->{
                    System.out.print(num + " ");
                });

                System.out.println();


                ArrayList<Integer> contadores = new ArrayList<>();
                for(int i=0;i<premios.size();i++){
                    if(premios.get(i).equals("General") && contadorGeneral <= 12){
                        contadorGeneral++;
                        contadores.add(contadorGeneral);
                    }else if(premios.get(i).equals("CV") && contadorCV <= 5 ){
                        contadorCV++;
                        contadores.add(contadorCV);
                    } else if(premios.get(i).equals("H") && contadorHotel <= 20){
                        contadorHotel++;
                        contadores.add(contadorHotel);
                    }else if(premios.get(i).equals("SUB2400") && contador2400 <= 4){
                        contador2400++;
                        contadores.add(contador2400);
                    }else if(premios.get(i).equals("SUB2200") && contador2200 <= 2){
                        contador2200++;
                        contadores.add(contador2200);
                    }
                }

                PreparedStatement ps = cnx.prepareStatement("SELECT Importe FROM Premio WHERE Tipo LIKE ? AND Puesto = ?");
                int[] importes = new int[premios.size()];
                for(int i=0;i<premios.size();i++){
                    ps.setString(1,premios.get(i));
                    ps.setInt(2,contadores.get(i));
                    ResultSet r = ps.executeQuery();
                    if (r.next()) {
                        importes[i] = r.getInt("Importe");
                    } else {
                        // Manejar el caso en el que no se encuentren resultados
                        importes[i] = 0; // o cualquier valor predeterminado que tenga sentido
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println(ps);
                }

                for(int i=0;i<premios.size();i++){
                    System.out.println(premios.get(i) + " --> " + importes[i]);
                }

                int aux = importes[0], cont=0, posicion=0;

                for(int i=0;i<premios.size();i++){
                    if(aux < importes[i]){
                        aux = importes[i];
                        posicion = i;
                    }
                }

                for(int i=0;i<premios.size();i++){
                    if(aux==importes[i]){
                        cont++;
                    }
                }

                System.out.println(premios.get(posicion) + " -> " + importes[posicion]);


                PreparedStatement preparedStatement = cnx.prepareStatement("INSERT INTO Ganadores VALUES (?,?,?,?,?)");
                if(cont==1){
                    preparedStatement.setInt(1,rs.getInt("Ranking"));
                    preparedStatement.setInt(2,rs.getInt("RankingFinal"));
                    preparedStatement.setString(3,rs.getString("Nombre"));
                    preparedStatement.setString(4,rs.getString("FIDEID"));
                    preparedStatement.setString(5,premios.get(posicion) + " -> " + importes[posicion]);
                    preparedStatement.executeUpdate();
                    System.out.println(preparedStatement);
                    //se suman 2 al 2400 y 2200
                    for(int i=0;i<premios.size();i++){
                       if(premios.get(posicion).equals("General")){
                           if(premios.get(i).equals("CV")){
                               contadorCV--;
                           }else if(premios.get(i).equals("H")){
                               contadorHotel--;
                           }else if(premios.get(i).equals("SUB2400")){
                               contador2400--;
                           }else if(premios.get(i).equals("SUB2200")){
                               contador2200--;
                           }
                       } else if(premios.get(posicion).equals("CV")){
                           if(premios.get(i).equals("General")){
                               contadorGeneral--;
                           }else if(premios.get(i).equals("H")){
                               contadorHotel--;
                           }else if (premios.get(i).equals("SUB2400")){
                               contador2400--;
                           }else if(premios.get(i).equals("SUB2200")){
                               contador2200--;
                           }
                       } else if(premios.get(posicion).equals("H")){
                           if (premios.get(i).equals("General")) {
                               contadorGeneral--;
                           } else if (premios.get(i).equals("CV")) {
                               contadorCV-- ;
                           } else if (premios.get(i).equals("SUB2400")) {
                               contador2400--;
                           } else if (premios.get(i).equals("SUB2200")) {
                               contador2200--;
                           }
                       } else if(premios.get(posicion).equals("SUB2400")) {
                           if(premios.get(i).equals("General")){
                               contadorGeneral--;
                           }else if(premios.get(i).equals("H")){
                               contadorHotel--;
                           } else if (premios.get(i).equals("CV")) {
                               contadorCV--;
                           } else if (premios.get(i).equals("SUB2200")){
                               contador2200--;
                           }
                       }else if(premios.get(posicion).equals("SUB2200")) {
                           if(premios.get(i).equals("General")){
                               contadorGeneral--;
                           }else if(premios.get(i).equals("H")){
                               contadorHotel--;
                           } else if (premios.get(i).equals("CV")) {
                               contadorCV--;
                           } else if (premios.get(i).equals("SUB2400")) {
                               contador2400--;
                           }
                       }
                   }

                } else if (cont>1) {
                    for(int i=0;i<premios.size();i++){
                        if(premios.get(i).equalsIgnoreCase("General") && importes[i] == aux){

                        }else if(premios.get(i).equalsIgnoreCase("2400") && importes[i] == aux){

                        }else if (premios.get(i).equalsIgnoreCase("2200") && importes[i] == aux) {

                        }else if (premios.get(i).equalsIgnoreCase("CV") && importes[i] == aux) {

                        }
                    }
                }
            }
        }
    }


    public static void ganadoresB(Connection cnx) throws SQLException {
        int contadorGeneral=0; //Max:12
        int contadorCV=0; //Max:5
        int contadorHotel=0; //Max:20
        int contador2400=0; //Max:4
        int contador2200=0; //Max:2

        Statement st = cnx.createStatement();
        boolean flag= st.execute("SELECT * FROM JugadorOptaPremio");

        FileReader fr;
        Scanner sc = null;
        String palabra="";
        String field;

        try{
            fr = new FileReader("/home/ALU1J/Descargas/GrupoB/RankingFinalB.csv");
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
    }

    public static ObservableList<Jugador> table(Connection cnx) throws SQLException {
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

    public static ObservableList<Jugador> tbloptapremiosA(Connection cnx) throws SQLException {
        Statement st = cnx.createStatement();
        boolean flag = st.execute("SELECT * FROM JugadorOptaPremio ORDER BY Ranking ASC");
        ObservableList<Jugador> jugadoresA = FXCollections.observableArrayList();

        if(flag){
            ResultSet rs = st.getResultSet();
            int ranking;
            int rankingFinal;
            String tipo;
            String nombre;
            String fideId;
            String desc;

            while(rs.next()){
                ranking = rs.getInt("Ranking");
                rankingFinal = rs.getInt("RankingFinal");
                tipo = rs.getString("tipo");
                nombre = rs.getString("Nombre");
                fideId = rs.getString("FIDEID");
                desc = rs.getString("desc");

                Jugador j = new Jugador(nombre, ranking, rankingFinal, tipo, fideId, desc);
                jugadoresA.add(j);
            }
        }
        return jugadoresA;
    }



    public static void imprimir(Connection cnx,Connection cnx2) throws SQLException, FileNotFoundException {
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
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        System.out.println("cac");
        Functions.ganadoresA(cnx);
    }
}
