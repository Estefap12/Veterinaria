package co.com.petslove.dao;

import co.com.petslove.conexion.Conexion;
import co.com.petslove.model.Mascota;
import co.com.petslove.model.Veterinario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeterinarioDAO {

    public static void crearVeterinario (Veterinario Veterinario) {
        //Es Polimorfismo y Herencia

        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()){

            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO veterinario( turno,nombreVeterinario) VALUES(?,?)";
                ps = conexion.prepareStatement(query);

                ps.setString(1, Veterinario.getTurno());
                ps.setString(3, Veterinario.getNombreVeterinario());



                ps.executeUpdate();
                System.out.println("Registro Exitoso");

            } catch (SQLException ex) {

                System.out.println(ex);
            }
        }catch (SQLException e) {
            System.out.println(e);

        }

    }
    public static void listarVeterinario(){
        Conexion db_connect = new Conexion();
        //Preparar query
        PreparedStatement ps = null;
        //Vamos a traer datos
        ResultSet rs = null;

        try(Connection connection = db_connect.get_connection()){
            String query = "SELECT  * FROM  veterinario";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("idVeterinario"));
                System.out.println("Turno: " + rs.getString("turno"));
                System.out.println("NombreVeterinario: " + rs.getString("nombreVeterinario"));



            }

        }catch (SQLException e){
            System.out.println("No se pudo recuperar registros");
            System.out.println(e);
        }

    }
    public static void actualizarVeterinario(Veterinario Veterinario){
        Conexion db_connect = new Conexion();
        try(Connection connection = db_connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "UPDATE veterinario SET nombreVeterinario = ? WHERE idVeterinario = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1,Veterinario.getNombreVeterinario());
                ps.setInt(2,Veterinario.getIdVeterinario());


                ps.executeUpdate();
                System.out.println("El registro se actualizo correctamente");
            }catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se actualizo el resgisto");
            }
        }catch (SQLException e){
            System.out.println(e);

        }
    }
    public static void borrarVeterinario(int idVeterinario){
        Conexion db_connect = new Conexion();

        try (Connection connection = db_connect.get_connection()) {

            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM veterinario WHERE veterinario.idVeterinario = ?";

                ps = connection.prepareStatement(query);
                ps.setInt(1,idVeterinario);
                ps.executeUpdate();
                System.out.println("El registro se ha eliminado exitosamente");
            }catch (SQLException e){
                System.out.println(e);
                System.out.println("No se elimino el registro");
            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }

}
