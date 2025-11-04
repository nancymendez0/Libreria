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
}
