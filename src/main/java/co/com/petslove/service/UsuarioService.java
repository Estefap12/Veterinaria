package co.com.petslove.service;

import co.com.petslove.dao.UsuarioDAO;
import co.com.petslove.model.Usuario;

import java.util.Scanner;

public class UsuarioService {
    Scanner sc= new Scanner(System.in);

    public void crearUsuario(){
        System.out.println("Ingrese el nombre del usuario");
        String nombre=sc.nextLine();
        sc.skip("\n");
        System.out.println("Ingrese el apellido del usuario");
        String apellido=sc.nextLine();
        sc.skip("\n");
        System.out.println("Ingrese el telefono del usuario");
        String telefono=sc.nextLine();
        sc.skip("\n");
        System.out.println("Ingrese el correo del usuario");
        String correo= sc.nextLine();
        sc.skip("\n");
        System.out.println("Ingrese la contrasena del usuario");
        String contrasena=sc.nextLine();

        Usuario registro = new Usuario() {
        };
        registro.setNombre(nombre);
        registro.setApellido(apellido);
        registro.setTelefono(telefono);
        registro.setCorreo((correo));
        registro.setContrasena(contrasena);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioDAO.crearUsuario(registro);



    }


}
