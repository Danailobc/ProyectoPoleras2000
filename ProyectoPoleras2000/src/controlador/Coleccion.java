/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Polera;
/**
 *
 * @author ismae
 */
public class Coleccion {
    ArrayList <Polera> listapoleras;
    
    public Coleccion() {
        this.listapoleras = new ArrayList<Polera> ();
    }
    
    public boolean agregar1(Polera polera){
        if   (polera.getIdArticulo() == 0
            ||polera.getCantidad()   == 0  
            ||polera.getColor().isEmpty() 
            ||polera.getTalla().isEmpty()
            ||polera.getMaterial().isEmpty()
            ||polera.getPrecio().isEmpty()){
            System.out.println("CAMPOS SIN DATOS");
    //JOptionPane.showMessageDialog(null, "HAY CAMPOS SIN DATOS O VALORES INCORRECTOS, DEBES LLENARLOS", "Error", JOptionPane.ERROR_MESSAGE);
    return false;
        }
    if(this.buscarIdID(polera.getIdArticulo())){
        System.out.println("YA EXISTE EL ID");
    //JOptionPane.showMessageDialog(null, "ID " + polera.getIdArticulo() + " YA EXISTE", "Error", JOptionPane.ERROR_MESSAGE);
    return false;
    }else{
        return listapoleras.add(polera); 
        }
    }
        public boolean buscarIdID (int id){
            for (Polera polera : listapoleras) {
            if(polera.getIdArticulo() == (id)){
                return true;
            }
        }
        System.out.println("NUEVO REGISTRO DE PRODUCTO");
        return false;
    }
    
    public boolean eliminarPolera (int id){
        for (Polera polera : listapoleras) {
        if(polera.getIdArticulo() == (id)){
        if(this.buscarParaEliminar(polera.getIdArticulo() ) ){
            listapoleras.remove(polera);
            System.out.println("poleras ELIMINADAS: " + id );
            return true;    
        }   
        }
    }  
    System.out.println("ID de poleras NO EXISTE");
    return false;
    }
    
    public boolean buscarParaEliminar (int iD){
            for (Polera polera : listapoleras) {
            if(polera.getIdArticulo() == (iD)){
                return true;
            }
        }
        System.out.println("PRODUCTO ELIMINADO");
        return false;
    }
    
    public String listarString(){
        String lista = "";
        for (Polera polera : listapoleras) {
            lista = lista 
                          + "\n Color         : "+polera.getColor()
                          + "\n Talla          : "+polera.getTalla()
                          + "\n Material     : "+polera.getMaterial()
                          + "\n Precio       : "+polera.getPrecio()
                          +"\n----------------------------------------";
        }
        return lista;
    }
    
        public String mostrarDatos(int id){
        String lista = "";
        for (Polera polera : listapoleras) {
            if(polera.getIdArticulo() == (id))
            lista = lista 
                          + "\n Color         : "+polera.getColor()
                          + "\n Talla          : "+polera.getTalla()
                          + "\n Material     : "+polera.getMaterial()
                          + "\n Precio       : "+polera.getPrecio();
        }
        return lista;
    }
    
    public boolean buscarModificar (int id){
        for (Polera polera : listapoleras) {
        if(polera.getIdArticulo() == (id)){
            System.out.println("Pedido encontrado");
            return true;
        }
    }
        System.out.println("Pedido no registrado");
        return false;
    }
    
    public boolean modificarCantidad(int id, int nuevaCantidad){
        for (Polera polera : listapoleras) {
            if(polera.getIdArticulo() == (id)){    
                System.out.println("La cantidad del pedido : " + polera.getCantidad()
                                  +"\n precio              : " + polera.getPrecio());
                //modifica Cantidad
                polera.setCantidad(nuevaCantidad);
                
                //modifica Precio
                int cantidad = polera.getCantidad();
                if (cantidad >= 0.0) {
                double resultado = cantidad * 2000.0;
            
                String resultadoString = Double.toString(resultado);
                polera.setPrecio(resultadoString);
                
                //Resultados
                System.out.println("Se modifico por : " + polera.getCantidad()
                                  +"\n precio       : " + polera.getPrecio());      
                }else if(nuevaCantidad == 0){
                    System.out.println("No tiene cantidad ni precio");
                }
        }
    }
        return false;
    }
    
    public boolean modificarColor(int id,String nuevoColor){
        for (Polera polera : listapoleras) {
            if(polera.getIdArticulo() == (id)){
                System.out.println("El color del pedido : " + polera.getColor());
                polera.setColor(nuevoColor);
                System.out.println("Se modifico por : " + polera.getColor());
                
            }    
        }
        return false;
    }
    
    public boolean modificarTalla(int id,String nuevaTalla){
        for (Polera polera : listapoleras) {
            if(polera.getIdArticulo() == (id)){
                System.out.println("La talla del pedido : " + polera.getTalla());
                polera.setTalla(nuevaTalla);
                System.out.println("Se modifico por : " + polera.getTalla());
                
            }    
        }
        return false;
    }
    
    public boolean modificarMaterial (int id,String nuevoMaterial){
        for (Polera polera : listapoleras) {
            if(polera.getIdArticulo() == (id)){
                System.out.println("El material del pedido : " + polera.getMaterial());
                polera.setMaterial(nuevoMaterial);
                System.out.println("Se modifico por : " + polera.getMaterial());
                
            }    
        }
        return false;
    }
    
        public double compraIVA (){
        double totalIVA = 0.0;
        for (Polera polera : listapoleras){
            totalIVA += Double.parseDouble(polera.getPrecio()) ;
            System.out.println("El precio es : " + totalIVA);
    }
        return totalIVA - (totalIVA * 0.19);
    }
    
    public double pagarCompra (){
        double totalPrecio = 0.0;
        for (Polera polera : listapoleras){
            totalPrecio += Double.parseDouble(polera.getPrecio()) ;
            System.out.println("El precio es : " + totalPrecio);
    }
        return totalPrecio;
    }
                           
}
