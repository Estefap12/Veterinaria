package co.com.petslove.model;

import co.com.petslove.dao.CitaDAO;
import co.com.petslove.dao.MascotaDAO;
import co.com.petslove.util.UtilCita;

import java.util.Scanner;

public class Cita implements UtilCita {
    Scanner sc=new Scanner(System.in);
    private int idCita;
    private String nombreMascota;
    private String tipoMascota;
    private String doctor;
    private int dia;
    private int mes;
    private int año;
    private String comentario;

    public Cita() {
    }

    public Cita(int id, String nombreMascota, String tipoMascota, String doctor, int dia, int mes, int año, String comentario) {
        this.idCita = idCita;
        this.nombreMascota = nombreMascota;
        this.tipoMascota = tipoMascota;
        this.doctor = doctor;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.comentario = comentario;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public void crearCita() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("CREAR CITA");
        System.out.println("Ingrese el nombre de la mascota");
        String nombreMascota=sc.nextLine();
        System.out.println("Ingrese el tipo de la mascota");
        String tipoMascota=sc.nextLine();
        System.out.println("Ingrese el nombre del doctor");
        String doctor=sc.nextLine();
        System.out.println("Ingrese el dia de la cita");
        int dia= sc.nextInt();
        System.out.println("Ingrese el mes de la cita");
        int mes=sc.nextInt();
        System.out.println("Ingrese el año de la cita");
        int año =sc.nextInt();
        Cita registro = new Cita() {
        };
        registro.setNombreMascota(nombreMascota);
        registro.setTipoMascota(tipoMascota);
        registro.setDoctor(doctor);
        registro.setDia(dia);
        registro.setMes(mes);
        registro.setAño(año);

        CitaDAO citaDAO = new CitaDAO();
        CitaDAO.crearCita(registro);

    }

    @Override
    public void listarCita() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("lISTA DE CITAS");
        CitaDAO.listarCita();

    }

    @Override
    public void verCita() {

    }

    @Override
    public void actualizarCita() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("ACTUALIZAR CITA");
        sc.skip("\n");
        System.out.println("Indique el dia actualizar");
        int dia = sc.nextInt();
        System.out.println("Indique el mes actualizar");
        int mes = sc.nextInt();
        System.out.println("Indique el año actualizar");
        int año = sc.nextInt();
        System.out.println("Indique el ID de la cita");
        int idCita = sc.nextInt();



        Cita actualizacion = new Cita() {
        };
        actualizacion.setDia(dia);
        actualizacion.setMes(mes);
        actualizacion.setAño(año);
        CitaDAO.actualizarCita(actualizacion);

    }



    @Override
    public void borrarCita() {
        System.out.println("------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------");
            System.out.println("BORRAR CITA.");
            System.out.println("Indique el id de la cita");
            int idCita = sc.nextInt();
            CitaDAO.borrarCita(idCita);


        }

    }



