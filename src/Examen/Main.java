package Examen;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Conexion {
    public static void main(String[] args) {
        final Vehiculo p1 = new Vehiculo(1,"Mustang","Ford",2023,"Deportivos americanos icónicos");
        final Vehiculo p2 = new Vehiculo(2, "Model S", "Tesla",2023,"Sedán eléctrico de luxo con gran autonomía");
        final Vehiculo p3 = new Vehiculo(3,"civic","Honda",2020,"Compacto de gran fiabilidade");
        final Vehiculo p4 = new Vehiculo(4,"corvette","Chevrolet",2022,"");
        final Vehiculo p5 = new Vehiculo(5,"prius","Toyota",2022,"Híbrido de baixo consumo e ecolóxico");

        final Tenda i1 = new Tenda(1, p1.getId(), 25000,30000,10 );
        final Tenda i2 = new Tenda(2, p2.getId(), 40000,50000,12 );
        final Tenda i3 = new Tenda(3, p3.getId(), 18000,22000,5 );
        final Tenda i4 = new Tenda(4, p4.getId(), 60000,70000,8 );
        final Tenda i5 = new Tenda(5, p5.getId(), 25000,30000,6 );


        MetodosTenda.insertar(Conexion.conexion(),new Tenda(1,p1.getId(),25000.00,30000.00,10));
        MetodosTenda.insertar(Conexion.conexion(),new Tenda(2,p2.getId(),40000.00,50000.00,12));
        MetodosVehiculo.leerEntrada(Conexion.conexion());
        MetodosTenda.selec(Conexion.conexion());

        XMLVehiculo.xml();
    }

}