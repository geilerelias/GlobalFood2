
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Impuesto;
import aplicacionglobalfoodtrading.Modelo.OtroImp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorOtroImp {

    private static Connection con;
    private static ResultSet rs;
    private static Statement st;

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection aCon) {
        con = aCon;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet aRs) {
        rs = aRs;
    }

    public static Statement getSt() {
        return st;
    }

    public static void setSt(Statement aSt) {
        st = aSt;
    }

    public ControladorOtroImp() {
    }
    
    
     public void Conectar() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }
    
     
      public int RegistrarOtroImpuesto(OtroImp o) {
        int exi = 0;
        String sql = "INSERT INTO Otroimpuesto (abreviatura,descripcion,valor) values ('" + o.getAbreviatura() + "','" + o.getDescripcion() +"',"+o.getValor()+")";
        try {
            Conectar();
            //System.out.println(sql);
            System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de OtroImpuesto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        
        return exi;
        
    }
     
         public ArrayList<OtroImp> ListadoOtroImpuesto() {
        ArrayList<OtroImp> ListaImp = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from otroimpuesto order by abreviatura";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                OtroImp o = new OtroImp();
                o.setAbreviatura(rs.getString(1));
                o.setDescripcion(rs.getString(2));
                o.setValor(rs.getFloat(3));
                ListaImp.add(o);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de OtroImpuesto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        return ListaImp;
    }
    
    public OtroImp RetornarOtroImpuestoxCod(String cod){
        OtroImp otroimp = null;
        for(OtroImp o : this.ListadoOtroImpuesto()){
            if(cod.equals(o.getAbreviatura())){
                otroimp = o;
            }
        }
        return otroimp;
    }
    
  
    public int ModificarOtroImpuesto(OtroImp o){
        int exi;
         String sql = "UPDATE otroimpuesto SET descripcion = '"+o.getDescripcion()+"', valor = "+o.getValor()+" where abreviatura = '"+o.getAbreviatura()+"'";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ Otroimpuesto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;
    }  
    
    
    public int EliminarOtroImpuesto(String cod){
        int exi;
         String sql = " DELETE FROM Otroimpuesto WHERE abreviatura = '"+cod+"'";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ Otroimpuesto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;     
    }
    
    
    
    public float ValorxAbrev(String abrev){
          float valor = 0;  
        for(OtroImp o : this.ListadoOtroImpuesto()){
            
            if(o.getAbreviatura().equalsIgnoreCase(abrev)){
                valor = o.getValor();
                System.out.println("Valor en el controlador : "+o.getValor());
            }
            
        }
        
        return valor;
    }
    

}
