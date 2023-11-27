package co.com.petslove.service;

import co.com.petslove.dao.MascotaDAO;
import co.com.petslove.dao.UsuarioDAO;
import co.com.petslove.model.Mascota;
import co.com.petslove.model.Usuario;

import java.util.Scanner;

public class MascotaService {
    Scanner sc= new Scanner(System.in);

    public void crearMascota(){
        System.out.println("Ingrese el nombre de la macota");
        String nombreMascota=sc.nextLine();
        sc.skip("\n");
        System.out.println("Ingrese el nombre de dueño de la mascota");
        String nombreDueno = sc.nextLine();
        sc.skip("\n");
        System.out.println("Ingrese la raza de la mascota");
        String raza=sc.nextLine();
        sc.skip("\n");
        System.out.println("Ingrese el peso de la mascota");
        String peso= sc.nextLine();
        sc.skip("\n");
        System.out.println("Ingrese el tamaño de la mascota");
        String tamano=sc.nextLine();

        Mascota registro = new Mascota() {
        };
        registro.setNombreMascota(nombreMascota);
        registro.setNombreDueno(nombreDueno);
        registro.setRaza(raza);
        registro.setPeso(peso);
        registro.setTamano(tamano);

        MascotaDAO mascotaDAO = new MascotaDAO();
        MascotaDAO.crearMascota(registro);



    }


}
