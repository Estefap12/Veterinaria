package co.com.petslove.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //Buscar dependencia maven repository en google ---java connector
    //Dependicia: Porsion de codigo.

    public Connection get_connection (){
        Connection connection = null;
        // try-catch es un atrapador  de errores.
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/veterinaria","root","");
            if (connection != null) {
                System.out.println("Conexion exitosa");
            }

        }catch (SQLException e){
            System.out.println(e);
        }
        return connection;
    }
}

