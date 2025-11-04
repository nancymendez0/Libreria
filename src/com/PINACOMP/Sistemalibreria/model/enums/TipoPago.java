package com.PINACOMP.Sistemalibreria.model.enums;

import java.util.Scanner;

public enum TipoPago {
    Efectivo,
    Tarjeta_debito,
    Tarjeta_credito,
    Vale,
    Transferencia,
    Desconocido;
    @Override
    public String toString() {
        String nombre = name().toLowerCase().replaceAll("_", " ");//devuelve el nombre exacto del valor enumerado tal como fue declarado .Convierte todo a minúsculas
       //reemplaza los guioes bajos por espacios
        //Da formato , conviertiendo la primer letra en mayúscula y une con el resto de la cadena
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }
    public static TipoPago Seleccionador(Scanner scanner){
        System.out.println("Ingrese el tipo de pago");
        TipoPago[] tipos = TipoPago.values();//convierte enum a un arreglo
        for(int i=0;i<tipos.length;i++){//re
            System.out.println((i+1)+"-"+values()[i].name());
        }
        while (true){
            String opciont = scanner.nextLine();
            try{
                int opciont=Integer.parseInt(entrada);
                if(opciont<1 || opciont>values().length){
                    return values()[opciont-1];
                }
                System.out.println("invalido");
            }catch (NumberFormatException e){
                System.out.println("invalido");
            }
        }

    }
}
