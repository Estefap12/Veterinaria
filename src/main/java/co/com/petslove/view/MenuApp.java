package co.com.petslove.view;
import co.com.petslove.dao.UsuarioDAO;
import co.com.petslove.model.Cita;
import co.com.petslove.model.Mascota;
import co.com.petslove.model.Usuario;
import co.com.petslove.model.Veterinario;


import java.util.Scanner;
public class MenuApp {
    Scanner sc = new Scanner(System.in);
    Usuario u = new Usuario();
    Mascota m = new Mascota();
    Veterinario v = new Veterinario();
    Cita c = new Cita();

    public void ejecutarApp () {

        System.out.println("Oprima 1 para iniciar: ");
        int ini = sc.nextInt();

        do {
            System.out.println("Seleccione 1.Usuario 2.Mascota, 3.Veterinario, 4.Citas Medicas y 5.Salir ");
            int opcUser = sc.nextInt();
            if (opcUser == 1) {
                int opc;
                System.out.println("1.Registrar usuario");
                System.out.println("2.Listado de usuarios");
                System.out.println("3. Actualizar  usuario");
                System.out.println("4.Eliminar  usuario");
                System.out.println("5. Salir");
                System.out.println("-------------------------------");
                System.out.print("Seleccione una opción: ");

                opc = sc.nextInt();
                switch (opc) {
                    case 1:
                        u.crearUsuario();

                        break;
                    case 2:

                        u.listarUsuarios();
                        break;
                    case 3:

                        u.actualizarUsuario();
                        break;
                    case 4:

                        u.borrarUsuario();
                        break;
                    case 5:
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Seleccione una opcion valida");
                }
            }else if (opcUser == 2) {
                int opc;
                System.out.println("1.Registrar mascota");
                System.out.println("2.Lista de mascotas");
                System.out.println("3. Actualizar  mascota");
                System.out.println("4.Eliminar  mascota");
                System.out.println("5. Salir");
                System.out.println("-------------------------------");
                System.out.print("Seleccione una opción: ");

                opc = sc.nextInt();
                switch (opc) {
                    case 1:
                        m.crearMascota();

                        break;
                    case 2:

                        m.listarMascotas();
                        break;
                    case 3:

                        m.actualizarMascota();
                        break;
                    case 4:

                        m.borrarMascota();
                        break;
                    case 5:
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Seleccione una opcion valida");
                }

            }else if (opcUser == 3) {
                int opc;
                System.out.println("1.Registrar Veterinario");
                System.out.println("2.Lista de Veterinario");
                System.out.println("3. Actualizar  Veterinario");
                System.out.println("4.Eliminar  Veterinario");
                System.out.println("5. Salir");
                System.out.println("-------------------------------");
                System.out.print("Seleccione una opción: ");

                opc = sc.nextInt();
                switch (opc) {
                    case 1:
                        v.crearVeterinario();

                        break;
                    case 2:

                        v.listarVeterinario();
                        break;
                    case 3:

                     v.actualizarVeterinario();
                        break;
                    case 4:

                        v.borrarVeterinario();
                        break;
                    case 5:
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Seleccione una opcion valida");
                }

            }
            else if (opcUser == 4) {
                int opc;
                System.out.println("1.Registrar Cita");
                System.out.println("2.Lista de Citas");
                System.out.println("3. Actualizar  Cita");
                System.out.println("4.Eliminar  Cita");
                System.out.println("5. Salir");
                System.out.println("-------------------------------");
                System.out.print("Seleccione una opción: ");

                opc = sc.nextInt();
                switch (opc) {
                    case 1:
                      c.crearCita();

                        break;
                    case 2:

                        c.listarCita();
                        break;
                    case 3:

                        c.actualizarCita();
                        break;
                    case 4:

                     c.borrarCita();
                        break;
                    case 5:
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Seleccione una opcion valida");
                }
            }

            else if (opcUser==5) {
                System.out.println("Saliendo del programa");
                break;


            }

            else {
                System.out.println("Seleccione un Usuario");
            }

        }while ( ini != 0);
    }






}