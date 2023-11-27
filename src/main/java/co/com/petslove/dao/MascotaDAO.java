package co.com.petslove.dao;

import co.com.petslove.conexion.Conexion;
import co.com.petslove.model.Mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MascotaDAO {
    public static void crearMascota (Mascota Mascota) {
        //Es Polimorfismo y Herencia

        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()){

//	idMascota	raza	peso	tamano	nombreDueno	nombreMascota
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mascota( nombreMascota, raza,peso, tamano, nombreDueno) VALUES(?,?,?,?,?)";
                ps = conexion.prepareStatement(query);

                ps.setString(1, Mascota.getNombreMascota());
                ps.setString(2, Mascota.getRaza());
                ps.setString(3, Mascota.getPeso());
                ps.setString(4, Mascota.getTamano());
                ps.setString(5, Mascota.getNombreDueno());
                ps.executeUpdate();
                System.out.println("Registro Exitoso");

            } catch (SQLException ex) {

                System.out.println(ex);
            }
        }catch (SQLException e) {
            System.out.println(e);

        }

    }

    public static void listarMascotas(){
        Conexion db_connect = new Conexion();
        //Preparar query
        PreparedStatement ps = null;
        //Vamos a traer datos
        ResultSet rs = null;

        try(Connection connection = db_connect.get_connection()){
            String query = "SELECT  * FROM  mascota";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("idMascota"));
                System.out.println("Nombre Mascota: " + rs.getString("nombreMascota"));
                System.out.println("raza: " + rs.getString("raza"));
                System.out.println("Peso: " + rs.getString("peso"));
                System.out.println("Tamano: " + rs.getString("tamano"));
                System.out.println("Nombre Dueno: " + rs.getString("nombreDueno"));


            }

        }catch (SQLException e){
            System.out.println("No se pudo recuperar registros");
            System.out.println(e);
        }

    }

    public static void actualizarMascota(Mascota Mascota){
        Conexion db_connect = new Conexion();
        try(Connection connection = db_connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "UPDATE mascota SET nombreMascota = ? WHERE idMascota = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1,Mascota.getNombreMascota());
                ps.setInt(2,Mascota.getIdMascota());


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


    public static void borrarMascota(int idMascota){
        Conexion db_connect = new Conexion();

        try (Connection connection = db_connect.get_connection()) {

            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mascota WHERE mascota.idMascota = ?";

                ps = connection.prepareStatement(query);
                ps.setInt(1,idMascota);
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
