package Examen;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MetodosVehiculo {

    public static void crearEntrada(Connection conn, Vehiculo vehiculo){
        //Con la tabla de vehiculo
        String sql = "INSERT INTO vehiculo (id,modelo,marca,ano,descripcion) VALUES (?,?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,vehiculo.getId());
            pstmt.setString(2,vehiculo.getModelo());
            pstmt.setString(3,vehiculo.getMarca());
            pstmt.setInt(4,vehiculo.getAno());
            pstmt.setString(5,vehiculo.getDescripción());
            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Entrada creada exitosamente ,filas afectadas: "+ filasAfectadas);
        }catch (SQLException e){
            System.out.println("Error con la base: "+e.getMessage());
        }
    }

    /**
     * Lee los datos de vehiculo
     * @param conn conexion
     */
    public static ArrayList<Vehiculo> leerEntrada(Connection conn){
        String sql = "SELECT * FROM vehiculo";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet filasAfectadas = pstmt.executeQuery();
            System.out.println("Entrada leida exitosamente: "+ filasAfectadas);
            ArrayList<Vehiculo> vehiculos = new ArrayList<>();
            while(filasAfectadas.next()){
                int id  = filasAfectadas.getInt(1);
                String modelo  = filasAfectadas.getString(2);
                String marca = filasAfectadas.getString(3);
                int data = filasAfectadas.getInt(4);
                String descripcion = filasAfectadas.getString(5);
                System.out.println(marca+ " "+ modelo + " "+ data + " "+ descripcion);
                vehiculos.add(new Vehiculo(id,modelo,marca,data,descripcion));

            }

            SerializacionVehiculo.serializacion(vehiculos);
            DeserializarVehiculo.deserializar();
            return vehiculos;
        }catch (SQLException e){
            System.out.println("Error con la base: "+e.getMessage());
        }
        return null;
    }

    /**
     * Borra una entrada de vehiculo con el valor de prezomayorista 11.99
     * @param conn conexion
     */
    public static void borrarEntrada(Connection conn, int id){
        String sql = "Delete From vehiculo WHERE id = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1,id);
            int filasAfectadas = pstm.executeUpdate();
            System.out.println("Entrada borrada exitosamente:"+ filasAfectadas);
        }catch (SQLException e){
            System.out.println("Error con la conexion: "+ e.getMessage());
        }
    }

    /**
     * Actualiza una entrada
     * @param conn conexion
     */
    public static void actualizarEntrada(Connection conn, Vehiculo vehiculo){
        String sql = "UPDATE vehiculo SET modelo = ?, marca = ?,ano = ?, descripcion = ? where id = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, vehiculo.getModelo());
            pstm.setString(2, vehiculo.getMarca());
            pstm.setInt(3,vehiculo.getAno());
            pstm.setString(4, vehiculo.getDescripción());
            pstm.setInt(5,vehiculo.getId());
            int filasAfectadas = pstm.executeUpdate();
            System.out.println("Filas actualizadas: "+ filasAfectadas);

        }catch (SQLException e){
            System.out.println("Error con la base de datos: (Vehiculo)  "+ e.getMessage());
        }
    }

}
