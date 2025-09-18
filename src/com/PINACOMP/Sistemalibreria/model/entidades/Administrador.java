package com.PINACOMP.Sistemalibreria.model.entidades;

import java.util.List;
import java.util.Scanner;

public class Administrador {
    String usuario;
    String contraseña;
    Scanner lectura = new Scanner(System.in);

    public Administrador(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuariosuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    public double calcularSueldoMensual(List<Empleado> resultado){
        int opcion;
        double total=0;
        System.out.println("-------FUNCION CALCULAR SUELDO-------");
        do{
            System.out.println("¿Cómo deseas buscar a tu empleado?");
            System.out.println("1-ID   O    2-NOMBRE DE PILA");
            opcion=lectura.nextInt();
            lectura.nextLine();
            Empleado encontrado= null;
            if(opcion==1){
                int id;
                System.out.println("Introduce el ID del empleado");
                id=lectura.nextInt();
                for(Empleado empleado : resultado){
                    if(empleado.getId()==id){
                        encontrado=empleado;
                        break;
                    }
                }
            }else{
                String nombre;
                System.out.println("Introduzca el nombre del empleado");
                nombre=lectura.nextLine();
                for (Empleado empleado : resultado){
                    if(empleado.getNombre().equalsIgnoreCase(nombre)){
                        encontrado=empleado;
                        break;
                    }
                }
            }
            if (encontrado!=null){

                double sueldo=encontrado.sueldoSemanal;
                System.out.println("El sueldo de: "+ encontrado.getNombre() + "es de: $"+sueldo*4);
            }else{
                System.out.println("Empleado no encontrado");
            }
            System.out.println("Deseas calcular otro salario");
            System.out.println("1-si    2-no");
            opcion=lectura.nextInt();
        }while (opcion==1);
        return total;

    }

    public boolean iniciarSesion(String usuario,String contraseña){
        boolean validacion;
        if(this.contraseña.equals(contraseña) && this.usuario.equals(usuario)){
            validacion=true;
        }else{
            validacion=false;
        }
        return validacion;
    }
}
