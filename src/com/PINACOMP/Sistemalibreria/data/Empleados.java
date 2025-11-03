package com.PINACOMP.Sistemalibreria.data;

import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;
import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;

import java.util.ArrayList;
import java.util.List;

public class Empleados {
    public final static List<Empleado> empleados = new ArrayList<>();
    static {

        empleados.add(new Empleado(1,"Jonh","Steward", "jonhh122345@gmain.com",35, TipoSexo.Masculino, 34125,2000,"j12345", TipoPuesto.VENDEDOR));
        empleados.add(new Empleado(2,"Maria","Lopez","maria.lopez@gmail.com",28, TipoSexo.Femenino,55234111,2200,"mlopez28",TipoPuesto.VENDEDOR));
        empleados.add(new Empleado(3,"Carlos","Ramirez","carlos.ramirez@yahoo.com",40, TipoSexo.Masculino,55487221,3000,"cramirez40",TipoPuesto.ADMIN));
        empleados.add(new Empleado(4,"Lucia","Fernandez","luciaf@hotmail.com",32, TipoSexo.Femenino,55300112,2500,"luciaf32",TipoPuesto.VENDEDOR));
        empleados.add(new Empleado(5,"Miguel","Santos","msantos@gmail.com",29, TipoSexo.Masculino,55998877,2300,"msantos29",TipoPuesto.VENDEDOR));
        empleados.add(new Empleado(6,"Ana","Torres","ana.torres@gmail.com",27, TipoSexo.Femenino,55774422,2100,"atorres27",TipoPuesto.VENDEDOR));
        empleados.add(new Empleado(7,"Pedro","Hernandez","pedro_hdz@gmail.com",45, TipoSexo.Masculino,55112233,3500,"phernandez45",TipoPuesto.ADMIN));
        empleados.add(new Empleado(8,"Sofia","Martinez","sofia.mtnez@yahoo.com",31, TipoSexo.Femenino,55334455,2400,"smartinez31",TipoPuesto.VENDEDOR));
        empleados.add(new Empleado(9,"Diego","Castillo","diegocas@gmail.com",38, TipoSexo.Masculino,55667788,2700,"dcastillo38",TipoPuesto.VENDEDOR));


    }
    //metodo para obtener siempre a los mismo empleados
    public static List<Empleado> obtenerEmpleados(){
        return empleados;
    }
}
