package Examen;

public class Tenda {
    int id;
    int idvehiculo;
    double prezomayorista;
    double prezoventa;
    int porcentaxe;

    //id,idvehiculo,prezomayorista,prezoventa,porcentaxeoferta
    public Tenda(int id, int idvehiculo, double prezomayorista, double prezoventa, int porcentaxeoferta){
        this.id = id;
        this.idvehiculo = idvehiculo;
        this.prezomayorista = prezomayorista;
        this.prezoventa = prezoventa;
        this.porcentaxe = porcentaxeoferta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPorcentaxe() {
        return porcentaxe;
    }

    public void setPorcentaxe(int porcentaxe) {
        this.porcentaxe = porcentaxe;
    }

    public double getPrezomayorista() {
        return prezomayorista;
    }

    public void setPrezomayorista(double prezomayorista) {
        this.prezomayorista = prezomayorista;
    }

    public double getPrezoventa() {
        return prezoventa;
    }

    public void setPrezoventa(double prezoventa) {
        this.prezoventa = prezoventa;
    }

    public int getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }
}
