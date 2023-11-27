package co.com.petslove.dao;

import co.com.petslove.conexion.Conexion;
import co.com.petslove.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UsuarioDAO {
    //Permite el envio y lectura de datos en la Base de Datos

    public static void crearUsuario(Usuario Usuario) {
        //Es Polimorfismo y Herencia

        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()){


            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO usuario( nombre,apellido, telefono, correo, contrasena) VALUES(?,?,?,?,?)";
                ps = conexion.prepareStatement(query);

                ps.setString(1, Usuario.getNombre());
                ps.setString(2, Usuario.getApellido());
                ps.setString(3, Usuario.getTelefono());
                ps.setString(4, Usuario.getCorreo());
                ps.setString(5, Usuario.getContrasena());
                ps.executeUpdate();
                System.out.println("Registro Exitoso");

            } catch (SQLException ex) {

                System.out.println(ex);
            }
        }catch (SQLException e) {
            System.out.println(e);

        }

    }

    public static void listarUsuarios(){

        Conexion db_connect = new Conexion();
        //Preparar query
        PreparedStatement ps = null;
        //Vamos a traer datos
        ResultSet rs = null;

        try(Connection connection = db_connect.get_connection()){
            String query = "SELECT  * FROM  usuario";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("idUsuario"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Telefono" + rs.getString("telefono"));
                System.out.println("Correo " + rs.getString("correo"));
                System.out.println("Contrasena" + rs.getString("contrasena"));


            }

        }catch (SQLException e){
            System.out.println("No se pudo recuperar registros");
            System.out.println(e);
        }
    }
    public static void actualizarUsuario(Usuario Usuario){
        Conexion db_connect = new Conexion();
        try(Connection connection = db_connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "UPDATE usuario SET nombre = ? WHERE idUsuario = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1,Usuario.getNombre());
                ps.setInt(2,Usuario.getIdUsuario());


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
    public static void eliminarUsuario(int idUsuario){
        Conexion db_connect = new Conexion();

        try (Connection connection = db_connect.get_connection()) {

            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM usuario WHERE usuario.idUsuario = ?";

                ps = connection.prepareStatement(query);
                ps.setInt(1,idUsuario);
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

