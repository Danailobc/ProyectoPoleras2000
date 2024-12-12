
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextArea;
import modelo.Polera;
        
/**
 *
 * @author ismae
 */
public class SQLConectar {
    Connection SQLConexion = null;

    //Ruta URL Base de Datos
    public SQLConectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            SQLConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectopoleras",
                                                      "root","");
            System.out.println("BASE DE DATO CONECTADA");
            
        }catch(Exception ex){
        System.out.println("ERROR : " + ex);
        }    
    }

    public Connection getSQLConexion() {
        return SQLConexion;
    }
    
    public void agregar(Polera polera){
        try {
            String sql = "INSERT INTO `pedidos`(`idArticulo`, `cantidad`, `color`, `talla`, `material`, `precio`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = SQLConexion.prepareStatement(sql);
            
            ps.setInt(1, 0);
            ps.setInt(2, polera.getCantidad());
            ps.setString(3, polera.getColor());
            ps.setString(4, polera.getTalla());
            ps.setString(5, polera.getMaterial());
            ps.setString(6, polera.getPrecio());
            
            ps.executeUpdate();
            System.out.println("AGREGADO");
        } catch (Exception e) {
            System.out.println("------ "+ e);
        } 
    }
    
    public void eliminar(String idArticulo, JTextArea eliminar) {
    try {
        String sql = "DELETE FROM `pedidos` WHERE `idArticulo` = ?";          
        PreparedStatement ps = SQLConexion.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(idArticulo));

        int filasEliminadas = ps.executeUpdate();

        if (filasEliminadas > 0) {
            System.out.println("ELIMINADO CORRECTAMENTE");
            eliminar.setText("EL PEDIDO : "+idArticulo+" SE ELIMINO");
        } else {
            System.out.println("No se encontro ninguna fila con el idArticulo proporcionado.");
            eliminar.setText("NO SE ENCONTRO EL PEDIDO : "+idArticulo);
        }

    } catch (Exception e) {
        System.out.println("Error al intentar eliminar: " + e);
        eliminar.setText("ERROR AL INTENTAR ELIMINAR");
    }
    }
    
    
    
    
    
    public Polera buscarPorId(int idArticulo) {
    Polera poleraEncontrada = null;
    try {
        String sql = "SELECT * FROM `pedidos` WHERE `idArticulo` = ?";
        PreparedStatement ps = SQLConexion.prepareStatement(sql);
        
        ps.setInt(1, idArticulo);

        ResultSet resultSet = ps.executeQuery();
            
        if (resultSet.next()) {       // con esto verificamos de si se encontró alguna fila para imprimir los datos 
            poleraEncontrada = new Polera();
            poleraEncontrada.setIdArticulo(resultSet.getInt("idArticulo"));
            poleraEncontrada.setCantidad(resultSet.getInt("cantidad"));
            poleraEncontrada.setColor(resultSet.getString("color"));
            poleraEncontrada.setTalla(resultSet.getString("talla"));
            poleraEncontrada.setMaterial(resultSet.getString("material"));
            poleraEncontrada.setPrecio(resultSet.getString("precio"));
        }
        
    } catch (Exception e) {
        System.out.println("ERROR: " + e);
    }
    return poleraEncontrada;
    }
    
public void modificarCantidad(int idArticulo, int nuevaCantidad) {
    try {
        String sqlBuscar = "SELECT * FROM `pedidos` WHERE `idArticulo` = ?";
        PreparedStatement psBuscar = SQLConexion.prepareStatement(sqlBuscar);
        psBuscar.setInt(1, idArticulo);
        
        try (ResultSet resultSet = psBuscar.executeQuery()) {
            if (resultSet.next()) {

            int cantidadActual = resultSet.getInt("cantidad");
            double nuevoPrecio = nuevaCantidad * 2000;

            String sqlModificar = "UPDATE `pedidos` SET `cantidad`=?, `precio`=? WHERE `idArticulo`=?";
            PreparedStatement psModificar = SQLConexion.prepareStatement(sqlModificar);

            psModificar.setInt(1, nuevaCantidad);
            psModificar.setDouble(2, nuevoPrecio);
            psModificar.setInt(3, idArticulo);

            int filasActualizadas = psModificar.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("SE MODIFICO LA CANTIDAD Y EL PRECIO");
            }else{
                System.out.println("NO SE ENCONTRO EL ID PARA PODER MODIFICAR");
            }
            }else{
                System.out.println("NO SE ENCONTRO EL ID");
            }
        }
    } catch (Exception e) {
        System.out.println("ERROR: " + e);
    }
}

    public void modificarColor(int modificaridArticulo, String nuevoColor) {
    try {
        String sqlBuscar = "SELECT * FROM `pedidos` WHERE `idArticulo` = ?";
        PreparedStatement psBuscar = SQLConexion.prepareStatement(sqlBuscar);
        psBuscar.setInt(1, modificaridArticulo);
        
        try (ResultSet resultSet = psBuscar.executeQuery()) {
            if (resultSet.next()) {

            String colorActual = resultSet.getString("color");

            String sqlModificar = "UPDATE `pedidos` SET `color`=? WHERE `idArticulo`=?";
            PreparedStatement psModificar = SQLConexion.prepareStatement(sqlModificar);

            psModificar.setString(1, nuevoColor);
            psModificar.setInt(2, modificaridArticulo);

            int filasActualizadas = psModificar.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("SE MODIFICO EL COLOR");
            } else {
                System.out.println("NO SE ENCONTRO EL ID PARA PODER MODIFICAR");
            }
            }else{
                System.out.println("NO SE ENCONTRO EL ID");
            }
        }
    } catch (Exception e) {
        System.out.println("ERROR: " + e);
    }
}

    public void modificarTalla(int ModiidArticulo, String nuevaTalla) {
    try {
        String sqlBuscar = "SELECT * FROM `pedidos` WHERE `idArticulo` = ?";
        PreparedStatement psBuscar = SQLConexion.prepareStatement(sqlBuscar);
        psBuscar.setInt(1, ModiidArticulo);
        
        try (ResultSet resultSet = psBuscar.executeQuery()) {
            if (resultSet.next()) {

            String tallaActual = resultSet.getString("talla");

            String sqlModificar = "UPDATE `pedidos` SET `talla`=? WHERE `idArticulo`=?";
            PreparedStatement psModificar = SQLConexion.prepareStatement(sqlModificar);

            psModificar.setString(1, nuevaTalla);
            psModificar.setInt(2, ModiidArticulo);

            int filasActualizadas = psModificar.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("SE MODIFICO LA TALLA");
            }else{
                System.out.println("NO SE ENCONTRO EL ID PARA PODER MODIFICAR");
            }
            }else{
                System.out.println("NO SE ENCONTRO EL ID");
            }
        }
    } catch (Exception e) {
        System.out.println("ERROR: " + e);
    }
}

    public void modificarMaterial(int modificidArticulo, String nuevoMaterial) {
    try {
        String sqlBuscar = "SELECT * FROM `pedidos` WHERE `idArticulo` = ?";
        PreparedStatement psBuscar = SQLConexion.prepareStatement(sqlBuscar);
        psBuscar.setInt(1, modificidArticulo);
        
        try (ResultSet resultSet = psBuscar.executeQuery()) {
            if (resultSet.next()) {

            String materialActual = resultSet.getString("material");

            String sqlModificar = "UPDATE `pedidos` SET `material`=? WHERE `idArticulo`=?";
            PreparedStatement psModificar = SQLConexion.prepareStatement(sqlModificar);

            psModificar.setString(1, nuevoMaterial);
            psModificar.setInt(2, modificidArticulo);

            int filasActualizadas = psModificar.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("SE MODIFICO EL MATERIAL");
            }else{
                System.out.println("NO SE ENCONTRO EL ID PARA PODER MODIFICAR");
            }
            }else{
                System.out.println("NO SE ENCONTRO EL ID");
            }
        }
    } catch (Exception e) {
        System.out.println("ERROR: " + e);
    }
}

public String filtrarPorCantidad(int cantidad) {
    try {
        String sql = "SELECT * FROM pedidos WHERE cantidad = ?";
        PreparedStatement ps = SQLConexion.prepareStatement(sql);
        ps.setInt(1, cantidad);

        ResultSet rs = ps.executeQuery();

        StringBuilder mensaje = new StringBuilder("FILTRO POR LA CANTIDAD:\n");
        boolean encontrados = false;

        while (rs.next()) {
            encontrados = true;
            mensaje.append("ID Artículo: ").append(rs.getInt("idArticulo")).append(", ");
            mensaje.append("Cantidad: ").append(rs.getInt("cantidad")).append(", ");
            mensaje.append("Color: ").append(rs.getString("color")).append(", ");
            mensaje.append("Talla: ").append(rs.getString("talla")).append(", ");
            mensaje.append("Material: ").append(rs.getString("material")).append(", ");
            mensaje.append("Precio: ").append(rs.getString("precio")).append("\n");
        }

        if (!encontrados) {
            mensaje = new StringBuilder("NO SE ENCOTRARON REGISTROS CON LA CANTIDAD QUE INDICA");
        }
        return mensaje.toString();
    }catch (SQLException e){
        System.out.println("ERROR " + e);
        return "ERROR";
    }
}
    
    public String listar (){
        String sql = "SELECT * FROM movie";
        System.out.println(sql);
        return "";
    }
}
