package co.com.petslove.model;

import co.com.petslove.dao.MascotaDAO;
import co.com.petslove.dao.UsuarioDAO;
import co.com.petslove.util.UtilMascota;

import java.util.Scanner;

public class Mascota implements UtilMascota {
    Scanner sc=new Scanner(System.in);
    private int idMascota;
    private String raza;
    private String peso;
    private String tamano;
    private String nombreDueno;
    private String nombreMascota;

    public Mascota(){
        super();
    }

    public Mascota( int idMascota, String raza, String peso, String tamano, String nombreDueno, String nombreMascota) {

        this.idMascota = idMascota;
        this.raza = raza;
        this.peso = peso;
        this.tamano = tamano;
        this.nombreDueno = nombreDueno;
        this.nombreMascota = nombreMascota;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getNombreMascota() {

        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {

        this.nombreMascota = nombreMascota;
    }


    @Override
    public void crearMascota() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("CREAR MASCOTA");
        System.out.println("Ingrese el nombre de la mascota");
        String nombreMascota=sc.nextLine();
        System.out.println("Ingrese la raza de la mascota");
        String raza=sc.nextLine();
        System.out.println("Ingrese el peso de la mascota");
        String peso=sc.nextLine();
        System.out.println("Ingrese el tamano de la mascota");
        String tamano= sc.nextLine();
        System.out.println("Ingrese el nombre del dueno de la mascota");
        String nombreDueno=sc.nextLine();

        Mascota registro = new Mascota() {
        };
        registro.setNombreMascota(nombreMascota);
        registro.setRaza(raza);
        registro.setPeso(peso);
        registro.setTamano((tamano));
        registro.setNombreDueno(nombreDueno);

        MascotaDAO mascotaDAO = new MascotaDAO();
        MascotaDAO.crearMascota(registro);



    }

    @Override
    public void listarMascotas() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("lISTA DE MASCOTAS");
        MascotaDAO.listarMascotas();

    }

    @Override
    public void verMascota() {

    }

    @Override
    public void actualizarMascota() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("ACTUALIZAR MASCOTA");
        sc.skip("\n");
        System.out.println("Indique el nuevo nombre de la mascota a actualizar");
        String nombreMascota = sc.nextLine();
        System.out.println("Indique el ID de la mascota a actualizar");
        int idMascota = sc.nextInt();

        Mascota actualizacion = new Mascota() {
        };
        actualizacion.setNombreMascota(nombreMascota);
        actualizacion.setIdMascota(idMascota);
        MascotaDAO.actualizarMascota(actualizacion);

    }

    @Override
    public void borrarMascota() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("BORRAR MASCOTA.");
        System.out.println("Indique el id de la mascota a eliminar");
        int idMascota = sc.nextInt();
        MascotaDAO.borrarMascota(idMascota);


    }


}
