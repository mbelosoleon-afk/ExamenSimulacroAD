package Examen;

import java.io.*;
import java.util.ArrayList;

    public class DeserializarVehiculo implements Serializable {
        public static void deserializar(){
            try{
                ArrayList<Vehiculo> vehiculos = null;
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Serialización BD.txt")); // usarlo si es un arraylist
                ObjectInputStream ois = new ObjectInputStream(bis);
                vehiculos = (ArrayList<Vehiculo>) ois.readObject();
                System.out.println("Deserializacion: "+ vehiculos);
            }catch (IOException e){
                System.out.println("Error de entrada / saida:(Deserializacion) "+ e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
}
