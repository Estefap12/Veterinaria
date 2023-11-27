package co.com.petslove.service;

import co.com.petslove.dao.CitaDAO;
import co.com.petslove.model.Cita;

import java.util.Scanner;

public class CitaService {
    Scanner sc= new Scanner(System.in);

    public void crearCita(){
        System.out.println("Ingrese el nombre de la mascota");
        String nombreMascota=sc.nextLine();
        sc.skip("\n");
        System.out.println("Ingrese el tipo de mascota");
        String tipoMascota = sc.nextLine();
        sc.skip("\n");
        System.out.println("Ingrese el nombre del doctor");
        String doctor=sc.nextLine();
        sc.skip("\n");
        System.out.println("Ingrese el dia de la cita");
        int dia= sc.nextInt();
        sc.skip("\n");
        System.out.println("Ingrese el mes de la cita");
        int mes =sc.nextInt();
        sc.skip("\n");
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

        CitaDAO cItaDAO = new CitaDAO();
        CitaDAO.crearCita(registro);



    }

}
