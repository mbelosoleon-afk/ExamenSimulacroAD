package Examen;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XMLVehiculo {
    public static void xml(){
        try{

            ArrayList<Vehiculo> vehiculos =  MetodosVehiculo.leerEntrada(Conexion.conexion());

            XMLOutputFactory xmlof = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlof.createXMLStreamWriter(new FileWriter("XMLVehiculo.xml"));
            xmlStreamWriter.writeStartDocument("1.0");
            xmlStreamWriter.writeStartElement("Vehiculo");
            xmlStreamWriter.writeStartElement("Modelo");
            xmlStreamWriter.writeCharacters(vehiculos.get(0).getModelo());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.close();
            System.out.println("XML CREADO CORRECTAMENTE");
        }catch (IOException | XMLStreamException e){
            System.out.println("Error Entrada saida (XML VEHICULO): "+e.getMessage());
        }
    }
}
