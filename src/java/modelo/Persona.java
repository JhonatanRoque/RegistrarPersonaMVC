package modelo;

import com.sun.istack.logging.Logger;

import java.sql.*;
import java.util.logging.Level;
import java.util.ArrayList;

public class Persona {
    //Atributos de la clase 
    String dui;
    String apellidos;
    String nombres;
    
    Connection cnn;
    Statement state;
    ResultSet result;
    
    //Constructor vacio de la clase tipo publico
    //El constructor lo utilizaremos para conectar con la base de datos
    public Persona(){
        try {
            Class.forName("com.mysql.jdbc.Driver");//Driver de la base de datos
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_recurso_humano", "root", "");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Persona(String dui, String apell, String nom){
        this.dui = dui;
        this.apellidos = apell;
        this.nombres = nom;
    }
   
    
    public boolean insertarDatos(){
        try{
            String miQuery = "insert into tb_personaq values('" + dui + "', '" + apellidos + "', '" + nombres + "');";
            int estado = 0; //Estado de la inserción
            state = cnn.createStatement();
            estado = state.executeUpdate(miQuery);
            if(estado == 1){
                return true;
            }
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Persona> consultarRegistros(){
        ArrayList<Persona> person = new ArrayList(); // Crear el arrat de almacenamiento de tipo persona
        try{
            String miQuery = "Select * from tb_persona";
            state = cnn.createStatement();
            result = state.executeQuery(miQuery);
            while(result.next()){
                person.add(new Persona(result.getString("dui_persona"), result.getString("apellidos_persona"), result.getString("nombres_persona")));
            }
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }
    
    //Generar los metodos set y get para los atributos

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
}
