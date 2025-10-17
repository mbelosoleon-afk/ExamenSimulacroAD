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

public class MetodosTenda {
    static void insertar(Connection conn, Tenda tenda){
        //Con la tabla de inventarioTenda
        String sql = "INSERT INTO inventariotenda (id,idvehiculo,prezomayorista,prezoventa,porcentaxeoferta) VALUES " +
                "(?,?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,tenda.getId());
            pstmt.setInt(2,tenda.getIdvehiculo());
            pstmt.setDouble(3,tenda.getPrezomayorista());
            pstmt.setDouble(4,tenda.getPrezoventa());
            pstmt.setInt(5,tenda.getPorcentaxe());
            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Entrada creada exitosamente ,filas afectadas: "+ filasAfectadas);
        }catch (SQLException e){
            System.out.println("Error con la base: "+e.getMessage());
        }
    }
    static void selec(Connection conn){
        String sql = "SELECT * FROM inventariotenda";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet filasAfectadas = pstmt.executeQuery();
            System.out.println("Entrada leida exitosamente: "+ filasAfectadas);
            ArrayList<Tenda>tendas = new ArrayList<>();
            while(filasAfectadas.next()){
                int id = filasAfectadas.getInt(1);
                int idvehiculo = filasAfectadas.getInt(2);
                double prezomayorista = filasAfectadas.getInt(3);
                double prezoventa = filasAfectadas.getInt(4);
                int porcentaxeoferta = filasAfectadas.getInt(5);
                tendas.add(new Tenda(id,idvehiculo,prezomayorista,prezoventa,porcentaxeoferta));
            }
        }catch (SQLException e){
            System.out.println("Error con la base: "+e.getMessage());
        }
    }
    static void borrarEntrada(Connection conn){
        String sql = "Delete From inventariotenda WHERE prezomayorista = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setDouble(1,11.99);
            int filasAfectadas = pstm.executeUpdate();
            System.out.println("Entrada borrada exitosamente:"+ filasAfectadas);
        }catch (SQLException e){
            System.out.println("Error con la conexion: "+ e.getMessage());
        }
    }
    static void actualizarEntrada(Connection conn,Tenda tenda){
        String sql = "UPDATE inventariotenda SET prezomayorista = ?, prezoventa = ?,porcentaxeoferta = ? WHERE id = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setDouble(1,tenda.getPrezomayorista());
            pstm.setDouble(2,tenda.getPrezoventa());
            pstm.setInt(3,tenda.getPorcentaxe());
            pstm.setInt(4,tenda.getId());
            int filasAfectadas = pstm.executeUpdate();
            System.out.println("Filas actualizadas: "+ filasAfectadas);

        }catch (SQLException e){
            System.out.println("Error con la base de datos:(Tenda)  "+ e.getMessage());
        }
    }
    static void serializartenda(ArrayList<Tenda> tendas){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Serializacion tenda.txt"));
            oos.writeObject(tendas);
        }catch (IOException e){
            System.out.println("Error de entrada/saida (SerializableTenda): "+ e.getMessage());
        }

    }
}
