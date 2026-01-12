
import java.sql.*;

class MainApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/lab8";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "root");
            Statement statement = connection.createStatement();

            stergere_excursie(connection, 1);


            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void adaugare_persoane(Connection connection, String nume, int varsta) {
        String sql = "insert into persoane (nume, varsta) values (?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nume);
            ps.setInt(2, varsta);

            int nr_randuri = ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare=" + nr_randuri);

        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }


    public static void afisare_tabela_persoane(Statement statement, String mesaj) {
        String sql = "select * from persoane";
        System.out.println("\n---" + mesaj + "---");
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next())
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ",varsta=" + rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void adaugare_excursii(Connection connection, int id_persoana, String destinatia, int anul) {

        if (!existaPersoana(connection, id_persoana)) {
            System.out.println("Persoana cu id " + id_persoana + " NU exista!");
            return;
        }
        String sql = "insert into excursii(id_persoana,destinatia,anul) values (?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id_persoana);
            ps.setString(2, destinatia);
            ps.setInt(3, anul);

            int nr_randuri = ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare=" + nr_randuri);

        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void afisare_tabela_excursii(Statement statement, String mesaj) {
        String sql = "select * from excursii";
        System.out.println("\n---" + mesaj + "---");
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        "id_excursie=" + rs.getInt("id_excursie") +
                                ", id_persoana=" + rs.getInt("id_persoana") +
                                ", destinatia=" + rs.getString("destinatia") +
                                ", anul=" + rs.getInt("anul")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean existaPersoana(Connection connection, int id_persoana) {
        String sql = "select id from persoane where id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id_persoana);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // true dacă există
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void afisare_persoane_excursii(Statement statement) {
        String sql = "SELECT p.nume,p.varsta,e.destinatia,e.anul " +
                " FROM persoane p " +
                " LEFT JOIN excursii e ON p.id=e.id_persoana ";

        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Nume:" + rs.getString("nume")
                        + ", Varsta:" + rs.getInt("varsta") + ",Destinatie:" + rs.getString("destinatia")
                        + ",Anul:" + rs.getInt("anul"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void afisare_excursiile_persoanelor(Connection connection, String nume) {

        if (!existaNumelePersoanei(connection, nume)) {
            System.out.println();
            System.out.println("Persoana cu numele -" + nume + "- NU exista in baza noastra de date!");
            return;
        }

        String sql = "SELECT e.destinatia,e.anul " +
                " FROM excursii e " +
                " INNER JOIN persoane p ON p.id=e.id_persoana " +
                " WHERE p.nume=? ";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nume);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Destinatie:" + rs.getString("destinatia") + ",Anul:" + rs.getInt("anul"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static boolean existaNumelePersoanei(Connection connection, String nume) {

        String sql = "select nume from persoane where nume=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nume);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // true dacă există
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void afisare_persoanele_dupa_excursii(Connection connection, String destinatia) {


        String sql = "SELECT p.nume,e.destinatia" +
                " FROM persoane p" +
                " LEFT JOIN excursii e ON p.id=e.id_persoana " +
                " WHERE e.destinatia=? ";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, destinatia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(" Persoane: " + rs.getString("nume") + " || Destinatie: " + rs.getString("destinatia"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void afisare_persoanele_dupa_excursii_an(Connection connection, int anul) {


        String sql = "SELECT p.nume,e.anul" +
                " FROM persoane p" +
                " LEFT JOIN excursii e ON p.id=e.id_persoana " +
                " WHERE e.anul=? ";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, anul);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(" Persoane: " + rs.getString("nume") + " || Anul: " + rs.getInt("anul"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void stergere_excursie(Connection connection, int id_excursie) {
        String sql = "DELETE FROM excursii WHERE id_excursie=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id_excursie);
            int randuri_modificate = ps.executeUpdate();
            if (randuri_modificate > 0) {
                System.out.println("Excursia a fost stearsa!");
            } else System.out.println("Excursia nu exista!");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void stergere_excursie_persoana(Connection connection,int id_excursie)
    {
        String sql="DELETE FROM persoane WHERE id_excursie=?";

        try(PreparedStatement ps =connection.prepareStatement(sql))
        {
            ps.setInt(1,id_excursie);
            int randuri_modificate=ps.executeUpdate();
            if(randuri_modificate>0)
            {
                System.out.println("Excursia a fost stearsa!");
            }else System.out.println("Excursia nu exista!");


        }catch (SQLException e)
        {
            e.printStackTrace();
        }






    }


}