
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

class MainApp {


    public static void main(String[] args) throws SQLException {


        String url = "jdbc:mysql://localhost:3306/lab8sm";
        //adaugare persoana noua
        try {
            Connection connection = DriverManager.getConnection(url, "root", "root");
            Statement statement = connection.createStatement();
//            afisare_tabela(statement, "Continut initial");
//            adaugarePersoana(connection, 6, "Dana", 23);
//            afisare_tabela(statement, "Dupa adaugare");
//            actualizare(connection, 6, 24);
//            afisare_tabela(statement, "Dupa modificare");

            afisare_tabela(statement, "-----Continut initial 2");
            adaugareExcursie(connection,5,6,"iasi",LocalDate.now());
            afisare_excursii(statement,"Dupa adaugare excursii");



            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void adaugarePersoana(Connection connection, int id, String nume, int varsta) {
        String sql = "insert into persoane values (?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nume);
            ps.setInt(3, varsta);
            int nr_randuri = ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare=" + nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }


    public static void afisare_tabela(Statement statement, String mesaj) {
        String sql = "select * from persoane";
        System.out.println("\n---" + mesaj + "---");
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next())
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ",varsta=" + rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void actualizare(Connection connection, int id, int varsta) {
        String sql = "update persoane set varsta=? where id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, varsta);
            ps.setInt(2, id);
            int nr_randuri = ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de modificare=" + nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void adaugareExcursie(Connection connection, int id_persoana, int id_excursie, String destinatie, LocalDate anul) {
        String sql = "insert into excursii values (?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id_persoana);
            ps.setInt(2, id_excursie);
            ps.setString(3, destinatie);
            ps.setDate(4, Date.valueOf(anul));
            int nr_randuri = ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare=" + nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void afisare_excursii(Statement statement, String mesaj) {
        String sql = "select * from excursii";
        System.out.println("\n---" + mesaj + "---");
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next())
                System.out.println(
                        "excursie=" + rs.getInt(1) +
                                ", pers=" + rs.getInt(2) +
                                ", destinatie=" + rs.getString(3) +
                                ", anul=" + rs.getDate(4)
                );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
