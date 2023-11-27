package co.com.petslove.dao;

import co.com.petslove.conexion.Conexion;
import co.com.petslove.model.Cita;
import co.com.petslove.model.Mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CitaDAO {
    public static void crearCita(Cita Cita) {
        //Es Polimorfismo y Herencia

        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()) {

//	idMascota	raza	peso	tamano	nombreDueno	nombreMascota
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO cita( nombreMascota,tipoMascota,doctor, dia, mes, año) VALUES(?,?,?,?,?,?)";
                ps = conexion.prepareStatement(query);

                ps.setString(1, Cita.getNombreMascota());
                ps.setString(2, Cita.getTipoMascota());
                ps.setString(3, Cita.getDoctor());
                ps.setInt(4, Cita.getDia());
                ps.setInt(5, Cita.getMes());
                ps.setInt(6, Cita.getAño());
                ps.executeUpdate();
                System.out.println("Registro Exitoso");

            } catch (SQLException ex) {

                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public static void listarCita(){
        Conexion db_connect = new Conexion();
        //Preparar query
        PreparedStatement ps = null;
        //Vamos a traer datos
        ResultSet rs = null;

        try(Connection connection = db_connect.get_connection()){
            String query = "SELECT  * FROM  cita";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("idCita"));
                System.out.println("Nombre Mascota: " + rs.getString("nombreMascota"));
                System.out.println("Tipo mascota: " + rs.getString("tipoMascota"));
                System.out.println("Doctor: " + rs.getString("doctor"));
                System.out.println("Dia: " + rs.getInt("dia"));
                System.out.println("Mes: " + rs.getInt("mes"));
                System.out.println("Año: " + rs.getInt("año"));

            }

        }catch (SQLException e){
            System.out.println("No se pudo recuperar registros");
            System.out.println(e);
        }

    }

    public static void actualizarCita(Cita Cita){
        Conexion db_connect = new Conexion();
        try(Connection connection = db_connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "UPDATE cita SET nombreMascota = ? WHERE idCita = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1,Cita.getNombreMascota());
                ps.setInt(2,Cita.getIdCita());


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
    public static void borrarCita(int id){
        Conexion db_connect = new Conexion();

        try (Connection connection = db_connect.get_connection()) {

            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM cita WHERE cita.idCita= ?";

                ps = connection.prepareStatement(query);
                ps.setInt(1,id);
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
