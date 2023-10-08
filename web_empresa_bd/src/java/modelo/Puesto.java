/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;

/**

 */
public class Puesto {
    
    private int id_puesto;
    private String puesto;
    private Conexion cn;

    public Puesto(){}

    public Puesto(int id_puesto, String puesto, Conexion cn) {
        this.id_puesto = id_puesto;
        this.puesto = puesto;
        this.cn = cn;
    }
    
    
    public int getId_puesto() {
    return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Conexion getCn() {
        return cn;
    }

    public void setCn(Conexion cn) {
        this.cn = cn;
    }
   
    
    public HashMap drop_sangre(){
        HashMap<String,String> drop = new HashMap();
        try {
            cn = new Conexion();
            String query = "SELECT id_puesto as id,puesto FROM puestos;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while(consulta.next()){
                drop.put(consulta.getString("id"), consulta.getString("puesto"));
            }
            
            cn.cerrar_conexion();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return drop;
    }
    
}
