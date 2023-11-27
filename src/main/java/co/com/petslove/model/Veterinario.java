package co.com.petslove.model;

import co.com.petslove.dao.MascotaDAO;
import co.com.petslove.dao.VeterinarioDAO;
import co.com.petslove.util.UtilVeterinario;

import java.util.Scanner;

public class Veterinario implements UtilVeterinario {
    Scanner sc=new Scanner(System.in);
    private int idVeterinario;
    private String turno;
    private String nombreVeterinario;

    Mascota mascota;

    public Veterinario(){
        super();
    }

    public Veterinario(int idVeterinario, String turno, String nombreVeterinario, Mascota mascota) {
        this.idVeterinario = idVeterinario;
        this.turno = turno;
        this.nombreVeterinario = nombreVeterinario;
        this.mascota = mascota;
    }



    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getTurno() {
        return turno;
    }


    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNombreVeterinario() {
        return nombreVeterinario;
    }
    public void setNombreVeterinario(String nombreVeterinario ) {
        this.nombreVeterinario = nombreVeterinario;
    }



    public void crearVeterinario() {


        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("CREAR VETERINARIO");
        System.out.println("Ingrese el nombre del Veterinario");
        String nombreVeterinario = sc.nextLine();
        System.out.println("Ingrese turno del veterinario");
        String turno=sc.nextLine();

        Veterinario registro = new Veterinario() {
        };
        registro.setNombreVeterinario(nombreVeterinario);
        registro.setTurno(turno);


        VeterinarioDAO mascotaDAO = new VeterinarioDAO();
        VeterinarioDAO.crearVeterinario(registro);

    }
    public void listarVeterinario() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("lISTA DE VETERINARIOS");
        VeterinarioDAO.listarVeterinario();

    }

    public void actualizarVeterinario() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("ACTUALIZAR VETERINARIO");
        sc.skip("\n");
        System.out.println("Indique el nuevo nombre del veterinario a actualizar");
        String nombreVerinario = sc.nextLine();
        System.out.println("Indique el ID del veterinario a actualizar");
        int idVeterinario = sc.nextInt();

        Veterinario actualizacion = new Veterinario() {
        };
        actualizacion.setNombreVeterinario(nombreVeterinario);
        actualizacion.setIdVeterinario(idVeterinario);
        VeterinarioDAO.actualizarVeterinario(actualizacion);

    }
    public void borrarVeterinario() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("BORRAR VETERINARIO.");
        System.out.println("Indique el id del veterinario a eliminar");
        int idVeterinario = sc.nextInt();
        VeterinarioDAO.borrarVeterinario(idVeterinario);


    }

}

