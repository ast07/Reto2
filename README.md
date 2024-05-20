 public static void optarA() throws SQLException {
        PreparedStatement ps = cnx.prepareStatement("INSERT INTO JugadorOptaPremio(Tipo,Nombre,FIDEID,Descalificado) VALUES (?,?,?,?)");
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
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
                    }else{
                        ps.setString(1,"General,SUB2200,SUB2400");
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
                    }
                }else if(Integer.parseInt(rs.getString("FIDE"))>2200 && Integer.parseInt(rs.getString("FIDE"))<2400){
                    String info = rs.getString("Info");
                    if(!info.equals("NULL")){
                        ps.setString(1,"General,SUB2400," + info);
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
                    }else{
                        ps.setString(1,"General,SUB2400");
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
                    }
                }else{
                    String info = rs.getString("Info");
                    if(!info.equalsIgnoreCase("NULL")){
                        ps.setString(1,"General," + info);
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
                    }else{
                        ps.setString(1,"General");
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
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
        PreparedStatement ps = cnx2.prepareStatement("INSERT INTO JugadorOptaPremio(Tipo,Nombre,FIDEID,Descalificado) VALUES (?,?,?,?)");
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
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
                    }else{
                        ps.setString(1,"General,1400,1600,1800");
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
                    }
                }else if(Integer.parseInt(rs.getString("FIDE"))>1400 && Integer.parseInt(rs.getString("FIDE"))<1600){
                    String info = rs.getString("Info");
                    if(!info.equalsIgnoreCase("NULL")){
                        ps.setString(1,"General,1600,1800," + info);
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
                    }else{
                        ps.setString(1,"General,1600,1800");
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
                    }
                }else if(Integer.parseInt(rs.getString("FIDE"))<1600 && Integer.parseInt(rs.getString("FIDE"))<1800){
                    String info = rs.getString("Info");
                    if(!info.equalsIgnoreCase("NULL")){
                        ps.setString(1,"General,1800," + info);
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
                    }else{
                        ps.setString(1,"General,1800");
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
                    }
                }else{
                    String info = rs.getString("Info");
                    if(!info.equalsIgnoreCase("NULL")){
                        ps.setString(1,"General," + info);
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
                    }else{
                        ps.setString(1,"General");
                        ps.setString(2,rs.getString("Nombre"));
                        ps.setString(3,rs.getString("FIDEID"));
                        ps.setString(4,"Not");
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
