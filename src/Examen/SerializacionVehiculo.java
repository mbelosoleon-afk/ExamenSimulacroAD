package Examen;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializacionVehiculo {
    public static void serializacion(ArrayList<Vehiculo> vehiculos ){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Serialización BD.txt"));
            oos.writeObject(vehiculos);
            System.out.println("Objeto escrito");
            oos.close();
        }catch(FileNotFoundException e){
            System.out.println("Archivo non encontrado: "+ e.getMessage());
        }catch (IOException e){
            System.out.println("Error de entrada/saida:(Serializacion) e"+ e.getMessage());
        }
    }
}
