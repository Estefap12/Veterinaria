package co.com.petslove.service;

import co.com.petslove.dao.UsuarioDAO;
import co.com.petslove.dao.VeterinarioDAO;
import co.com.petslove.model.Usuario;
import co.com.petslove.model.Veterinario;

import java.util.Scanner;

public class VeterinarioService {

    Scanner sc= new Scanner(System.in);

    public void crearVeterinario(){
        System.out.println("Ingrese el nombre del veterinario");
        String nombreVeterinario=sc.nextLine();
        sc.skip("\n");
        System.out.println("Ingrese el turno del veterinario");
        String turno=sc.nextLine();



        Veterinario registro = new Veterinario() {
        };
        registro.setNombreVeterinario(nombreVeterinario);
        registro.setTurno(turno);

       VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
        veterinarioDAO.crearVeterinario(registro);



    }
}
