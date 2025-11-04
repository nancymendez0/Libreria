package com.PINACOMP.Sistemalibreria.app;
import com.PINACOMP.Sistemalibreria.model.entidades.*;
import com.PINACOMP.Sistemalibreria.model.servicios.MenuService;
import com.sistemalibreria.excepciones.ErroresEmpleados.CorreoInvalidoException;
import com.sistemalibreria.excepciones.ErroresEmpleados.ValidadorEmpleado;

import java.util.Scanner;

public class main {
    public static Scanner scanner = new Scanner(System.in);
    static MenuService menu = new MenuService();
    static Administrador ad1 = new Administrador("lalo9807","12345");

    public static void main(String[] args) {
        int opcion;
        System.out.println("BIENVENIDO A LIBRERIA ETERNAS");
        System.out.println("¿Qué tipo de usuario eres(Digita el número correspondiente): \n 1-Cliente \n 2-Empleado   \n 0-Salir" );
        opcion = leerOpcion();
        while(opcion!=0){
                if (opcion==1){
                    String correoCli= null;
                    //obteniendo correo
                    while(true){
                        try {
                            System.out.println("Ingresa tu correo: ");
                            correoCli=leerDatos();
                            ValidadorEmpleado.validarCorreo(correoCli);
                            break;
                        }catch (CorreoInvalidoException e){
                            System.out.println(e.getMessage());
                        }
                    }

                    int opcionCliente;
                    do {
                        menu.menuCliente();
                        opcionCliente = leerOpcion();
                        menu.accionesCliente(opcionCliente, scanner);
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
    public static int leerOpcion() {
        boolean entradaValida=false;
        int opcion=0;
        while(!entradaValida){
            if(scanner.hasNextInt()){
                opcion = scanner.nextInt();
                entradaValida=true;
                scanner.nextLine();
            }else{
                System.out.println("Entrada inválida. Porfavor ingresa un número entero");
                scanner.nextLine();
            }
        }

        return opcion;
    }
    public static double leerOpcionDouble() {
        boolean entradaValida=false;
        double opcion=0;
        while(!entradaValida){
            if(scanner.hasNextDouble()){
                opcion = scanner.nextDouble();
                entradaValida=true;
                scanner.nextLine();
            }else{
                System.out.println("Entrada inválida. Porfavor ingresa una cantidad numérica(con punto decimal)");
                scanner.nextLine();
            }
        }

        return opcion;
    }
    private static String leerDatos() {
        String valor = scanner.nextLine();
        //scanner.nextLine(); // Limpiar buffer
        return valor;
    }
    }



