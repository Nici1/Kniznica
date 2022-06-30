import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionISv2021 {


    static String [] login (){
        String array [] = new String [3];
        array[0] = "sa";
        array[1]  = "Security1";
        array[2] = "jdbc:sqlserver://212.235.190.203;databaseName=ProektnaNS";
        return array;

    }


    static void insertAvtor (String Ime,String Priimek){
        String userName = "sa";
        String password = "Security1";
        String url = "jdbc:sqlserver://212.235.190.203;databaseName=proektnaNS";

        try  {
            // povezovanje z bazo
            System.out.println("Povezovanje z bazo...");
            Connection conn = DriverManager.getConnection(url, userName, password);
            // vmesnik za SQL poizvedbo
            Statement stmt = conn.createStatement();


            CallableStatement cstmt0 = conn.prepareCall("{call dbo.spDodajAvtor(?, ?, ?)}");
            cstmt0.setString(1, Ime);
            cstmt0.setString(2, Priimek);
            //cstmt0.setInt(3, 9);
            cstmt0.registerOutParameter(3, java.sql.Types.BIT);
            cstmt0.execute();
            if (cstmt0.getBoolean(3))
                System.out.println("Uspesno dodan avtor.");
            else
                System.out.println("Napaka pri dodajanju.");

            // izvrsitev SQL injecta
            // stmt.executeUpdate(sqlInject);


            // za konec pa se zapremo povezavo
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        }
    }

    static void insertStranka (String Ime,String Priimek,String DatumClanarine, String VeljavnostMesecov, String Naslov, String TelStevilka){
        String userName = "sa";
        String password = "Security1";
        String url = "jdbc:sqlserver://212.235.190.203;databaseName=proektnaNS";

        try  {
            // povezovanje z bazo
            System.out.println("Povezovanje z bazo...");
            Connection conn = DriverManager.getConnection(url, userName, password);
            // vmesnik za SQL poizvedbo
            Statement stmt = conn.createStatement();


            CallableStatement cstmt0 = conn.prepareCall("{call dbo.spDodajStranka(?, ?, ?, ?, ?, ?,?)}");
            cstmt0.setString(1, Ime);
            cstmt0.setString(2, Priimek);
            cstmt0.setString(3, DatumClanarine);
            cstmt0.setString(4, VeljavnostMesecov);
            cstmt0.setString(5, Naslov);
            cstmt0.setString(6, TelStevilka);
            //cstmt0.setInt(3, 9);
            cstmt0.registerOutParameter(7, java.sql.Types.BIT);
            cstmt0.execute();
            if (cstmt0.getBoolean(7))
                System.out.println("Uspesno dodana stranka.");
            else
                System.out.println("Napaka pri dodajanju.");


            // izvrsitev SQL injecta
            // stmt.executeUpdate(sqlInject);


            // za konec pa se zapremo povezavo
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        }
    }

    static void insertIzposoja (String DatumIzposoje, String Rok, String KnjigeID, String StrankaID){
        String userName = "sa";
        String password = "Security1";
        String url = "jdbc:sqlserver://212.235.190.203;databaseName=proektnaNS";

        try  {
            // povezovanje z bazo
            System.out.println("Povezovanje z bazo...");
            Connection conn = DriverManager.getConnection(url, userName, password);
            // vmesnik za SQL poizvedbo
            Statement stmt = conn.createStatement();


            CallableStatement cstmt0 = conn.prepareCall("{call dbo.spDodajIzposoja(?, ?, ?, ?, ?)}");
            cstmt0.setString(1, DatumIzposoje);
            cstmt0.setString(2, Rok);
            cstmt0.setInt(3, Integer.parseInt(KnjigeID));
            cstmt0.setInt(4, Integer.parseInt(StrankaID));

            //cstmt0.setInt(3, 9);
            cstmt0.registerOutParameter(5, java.sql.Types.BIT);
            cstmt0.execute();
            if (cstmt0.getBoolean(5))
                System.out.println("Uspesno dodana izposoja.");
            else {
                for (int i = 0; i < Strank().size(); i++) {
                    String parts[] = Strank().get(i).split(" ");
                    if(parts[0].equals(StrankaID)){
                        System.out.println("Napaka pri dodajanju.");
                        System.out.println("Datum Clanarine: "+parts[3]+" Veljavnost v Meseci "+parts[4]);
                    }
                }
            }

            // izvrsitev SQL injecta
            // stmt.executeUpdate(sqlInject);


            // za konec pa se zapremo povezavo
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        }
    }

    static void insertVrnitev (String DatumIzposoje, String Rok, String DatumVrnitve, String KnjigeID, String StrankaID){
        String userName = "sa";
        String password = "Security1";
        String url = "jdbc:sqlserver://212.235.190.203;databaseName=proektnaNS";

        try  {
            // povezovanje z bazo
            System.out.println("Povezovanje z bazo...");
            Connection conn = DriverManager.getConnection(url, userName, password);
            // vmesnik za SQL poizvedbo
            Statement stmt = conn.createStatement();


            CallableStatement cstmt0 = conn.prepareCall("{call dbo.spVrnitevKnjige(?, ?, ?, ?, ?)}");
            cstmt0.setString(1, DatumIzposoje);
            cstmt0.setString(2, Rok);
            cstmt0.setString(3, DatumVrnitve);
            cstmt0.setInt(4, Integer.parseInt(KnjigeID));
            cstmt0.setInt(5, Integer.parseInt(StrankaID));

            System.out.println("Knjiga je bila vrnjena");


            //cstmt0.setInt(3, 9);
            //cstmt0.registerOutParameter(5, java.sql.Types.BIT);
            cstmt0.execute();
            /*if (cstmt0.getBoolean(5))
                System.out.println("Uspesno dodana izposoja.");
            else
                System.out.println("Napaka pri dodajanju."); */

            // izvrsitev SQL injecta
            // stmt.executeUpdate(sqlInject);


            // za konec pa se zapremo povezavo
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        }
    }

    static List<String> AvtorKnjigaZvrst (){


        String userName = "sa";
        String password = "Security1";
        ArrayList <String>   AKZ  = new ArrayList<>();

        // PB, na katero bi se radi povezali
        String url = "jdbc:sqlserver://212.235.190.203;databaseName=ProektnaNS";


        String sqlSelect = "SELECT * FROM vAvtorKnjigaZvrst;";

        try  {
            // povezovanje z bazo
            System.out.println("Povezovanje z bazo...");
            Connection conn = DriverManager.getConnection(url, userName, password);
            // vmesnik za SQL poizvedbo
            Statement stmt = conn.createStatement();
            // izvrsitev poizvedbe in sprejem rezultatov prek ResultSet
            ResultSet rs = stmt.executeQuery(sqlSelect);
            // primer dostopa do sprejetih podatkov
            //18 2021-05-05 2021-05-19 null 3 4



            while (rs.next()) {

                AKZ.add( rs.getInt(1) +" "+rs.getString(2)+" "+rs.getString(3)+" "+ rs.getInt(4)
                        + " "+ rs.getString(5) + " "+ rs.getString(6)+ " "+ rs.getString(7)+ " "+ rs.getInt(8));
            }

            conn.close();
        }


        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        }

        return AKZ;
    }

    static List<String> Izposoje (){


        String userName = "sa";
        String password = "Security1";
        ArrayList <String>   list  = new ArrayList<>();

        // PB, na katero bi se radi povezali
        String url = "jdbc:sqlserver://212.235.190.203;databaseName=ProektnaNS";


        String sqlSelect = "SELECT * FROM Izposoja WHERE DatumVrnitve IS NULL;";

        try  {
            // povezovanje z bazo
            System.out.println("Povezovanje z bazo...");
            Connection conn = DriverManager.getConnection(url, userName, password);
            // vmesnik za SQL poizvedbo
            Statement stmt = conn.createStatement();
            // izvrsitev poizvedbe in sprejem rezultatov prek ResultSet
            ResultSet rs = stmt.executeQuery(sqlSelect);
            // primer dostopa do sprejetih podatkov



            while (rs.next()) {

                list.add( rs.getInt(1) +" "+rs.getString(2)+" "+rs.getString(3)+" "+ rs.getString(4)
                        + " "+ rs.getInt(5) + " "+ rs.getInt(6));
            }

            conn.close();
        }


        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        }

        return list;
    }

    static List<String> Strank (){


        String userName = "sa";
        String password = "Security1";
        ArrayList <String>   list  = new ArrayList<>();

        // PB, na katero bi se radi povezali
        String url = "jdbc:sqlserver://212.235.190.203;databaseName=ProektnaNS";


        String sqlSelect = "SELECT * FROM Stranka;";

        try  {
            // povezovanje z bazo
            System.out.println("Povezovanje z bazo...");
            Connection conn = DriverManager.getConnection(url, userName, password);
            // vmesnik za SQL poizvedbo
            Statement stmt = conn.createStatement();
            // izvrsitev poizvedbe in sprejem rezultatov prek ResultSet
            ResultSet rs = stmt.executeQuery(sqlSelect);
            // primer dostopa do sprejetih podatkov

            while (rs.next()) {

                list.add( rs.getInt(1) +" "+rs.getString(2)+" "+rs.getString(3)+" "+ rs.getString(4)
                        + " "+ rs.getInt(5) + " "+ rs.getString(6) + rs.getString(7));
            }

            conn.close();
        }


        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        }

        return list;
    }

    static List<String> VsiIzposoje (){

        ArrayList <String>   list  = new ArrayList<>();

        // PB, na katero bi se radi povezali


        String sqlSelect = "SELECT * FROM Izposoja;";

        try  {
            // povezovanje z bazo
            System.out.println("Povezovanje z bazo...");
            Connection conn = DriverManager.getConnection(login()[2], login()[0], login()[1]);
            // vmesnik za SQL poizvedbo
            Statement stmt = conn.createStatement();
            // izvrsitev poizvedbe in sprejem rezultatov prek ResultSet
            ResultSet rs = stmt.executeQuery(sqlSelect);
            // primer dostopa do sprejetih podatkov


            while (rs.next()) {

                list.add( rs.getInt(1) +" "+rs.getString(2)+" "+rs.getString(3)+" "+ rs.getString(4)
                        + " "+ rs.getInt(5) + " "+ rs.getInt(6));
            }

            conn.close();
        }


        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        }

        return list;
    }

}

