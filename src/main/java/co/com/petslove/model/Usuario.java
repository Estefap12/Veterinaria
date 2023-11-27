package co.com.petslove.model;

import co.com.petslove.dao.UsuarioDAO;
import co.com.petslove.util.UtilUsuario;

import java.util.Scanner;

public class Usuario implements UtilUsuario {
    Scanner sc= new Scanner(System.in);
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private  String contrasena;

    public Usuario(){};

    public Usuario(int idUsuario, String nombre, String apellido, String telefono, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    @Override
    public void crearUsuario() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("CREAR USUARIO");
        System.out.println("Ingrese el nombre del usuario");
        String nombre=sc.nextLine();

        System.out.println("Ingrese el apellido del usuario");
        String apellido=sc.nextLine();
        System.out.println("Ingrese el telefono del usuario");
        String telefono=sc.nextLine();
        System.out.println("Ingrese el correo del usuario");
        String correo= sc.nextLine();
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

    @Override
    public void listarUsuarios() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("lISTA DE USUARIOS");
        UsuarioDAO.listarUsuarios();
    }

    @Override
    public void verUsuario() {
        System.out.println("Id: "+idUsuario+"\n"+"Nombre"+nombre+"\n"+"Apellido"+
                "Telefono:"+telefono+"\n"+"Correo: "+correo+"\n"+"Contrasena: "+contrasena);


    }

    @Override
    public void actualizarUsuario() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("ACTUALIZAR USUARIO");
        sc.skip("\n");
        System.out.println("Indique el nombre del usuario a actualizar");
        nombre = sc.nextLine();
        System.out.println("Indique el ID del usuario a actualizar");
        int idUsuario = sc.nextInt();

        Usuario actualizacion = new Usuario() {
        };
        actualizacion.setNombre(nombre);
        actualizacion.setIdUsuario(idUsuario);
        UsuarioDAO.actualizarUsuario(actualizacion);



    }

    @Override
    public void borrarUsuario() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("BORRAR USUARIO.");
        System.out.println("Indique el id del usuario a eliminar");
        int idUsuarioo = sc.nextInt();
        UsuarioDAO.eliminarUsuario(idUsuarioo);


    }


}
