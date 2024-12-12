/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ismae
 */
public class Polera {
    
    private int idArticulo;
    private int cantidad;
    private String color;
    private String talla;
    private String material;
    private String precio;

    public Polera() {
        
    }

    public Polera(int idArticulo, int cantidad, String color, String talla, String material, String precio) {
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.color = color;
        this.talla = talla;
        this.material = material;
        this.precio = precio;
    }

    
    
    public void mostrarDatos(){
        System.out.println("cantidad   : " + this.getCantidad());
        System.out.println("color      : " + this.getColor());
        System.out.println("talla      : " + this.getTalla());
        System.out.println("material   : " + this.getMaterial());
        System.out.println("precio     : " + this.getPrecio());
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Polera{" + "idArticulo=" + idArticulo + ", cantidad=" + cantidad + ", color=" + color + ", talla=" + talla + ", material=" + material + ", precio=" + precio + '}';
    }

   
}
