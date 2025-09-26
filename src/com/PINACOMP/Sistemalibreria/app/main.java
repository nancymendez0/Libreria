package com.PINACOMP.Sistemalibreria.app;
import com.PINACOMP.Sistemalibreria.model.entidades.*;
import com.PINACOMP.Sistemalibreria.model.servicios.EmpleadoService;
import com.PINACOMP.Sistemalibreria.model.servicios.LibroService;
import com.PINACOMP.Sistemalibreria.model.servicios.MenuService;

import java.util.List;
import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in);
    static MenuService menu = new MenuService();
    static Administrador ad1 = new Administrador("lalo9807","12345");
    public static void main(String[] args) {
        int opcion;
        System.out.println("BIENVENIDO A LIBRERIA ETERNAS");
        System.out.println("¿Qué tipo de usuario eres:  \n 1-Cliente \n 2-Empleado   \n 0-Salir" );
        opcion = leerOpcion();
        while(opcion!=0){
                if (opcion==1){
                    int opcionCliente;
                    do {
                        menu.menuCliente();
                        opcionCliente = leerOpcion();
                        menu.accionesCliente(opcionCliente);
                    }while(opcionCliente!=0);
                }else if(opcion==2){
                    System.out.println("¿Qué tipo de empleado eres \n 1-Vendedor \n 2-Administrador \n 0-Salir");
                    int opcionEmpleado;
                    opcionEmpleado = leerOpcion();
                    if (opcionEmpleado==1){
                        int opcionVendedor;
                        do {
                            menu.menuEmpleado();
                            opcionVendedor = leerOpcion();
                            menu.accionesEmpleado(opcionVendedor, scanner);

                        }while (opcionVendedor!=0);
                    }else if(opcionEmpleado==2){
                        String nombreUsuario;
                        String contraseniaDigitada;
                        System.out.println("Bienvenido Ingresa tu nombre de usuario ");
                        nombreUsuario = leerDatos();
                        System.out.println("Ingresa tu contraseña");
                        contraseniaDigitada = leerDatos();
                        boolean validador;
                        validador= ad1.iniciarSesion(nombreUsuario, contraseniaDigitada);
                        if (validador==true){
                            int opcionAdmin;
                            do {
                                menu.menuAdmin(nombreUsuario);
                                opcionAdmin=leerOpcion();
                                menu.accionesAdmin(opcionAdmin, scanner);

                            }while (opcionAdmin!=0);

                        }else{
                            System.out.println("usuario o contraseña incorrectos");
                            opcion = leerOpcion();
                        }
                    }
                }
        System.out.println("¿Qué tipo de usuario eres:  \n 1-Cliente \n 2-Empleado   \n 0-Salir" );
        opcion = leerOpcion();
            } //fin de while
        System.out.println("Gracias por usar el Sistema de librerias Eternas");
        System.out.println("¡Hasta pronto!");
        }
    private static int leerOpcion() {
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return opcion;
    }
    private static String leerDatos() {
        String valor = scanner.nextLine();
        //scanner.nextLine(); // Limpiar buffer
        return valor;
    }
    }



