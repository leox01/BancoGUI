/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author leopoldomorales
 */
public abstract class Cuenta {
    //variables de instancia o atributos
    private String tipoDeCuenta;
    private String nombre;
    private String direccion;
    private String email;
    private String telefono;
    private int numeroCuenta;
    private double saldo;
    
    
    //constructor
    
    /*
     Cuando tengo dos o más métodos con el mismo nombre, dentro de una clase
     se le conoce como Overloading (sobrecarga) de métodos. 
     Lo único a tener en cuenta es que deben de tener diferente número 
     de parámetros.
     En este caso el constructor Cuenta está sobrecargado 
    */
    public Cuenta(){
        System.out.println("Estoy creando un objeto de la clase Cuenta");
    }
    
    public Cuenta(String tipoDeCuenta, String nombre, String direccion, String email, String telefono, int numeroCuenta, double saldo){
        this.nombre = nombre;
        this.tipoDeCuenta = tipoDeCuenta;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void hacerDeposito(Double deposito){
        
        if (deposito>0) {
            saldo = saldo + deposito;
        }else
            System.out.println("La cantidad no puede ser negativa ");
        
    }
    
    public void mostrarDatos(){
    
        System.out.println("Tipo de cuenta: "+tipoDeCuenta);
        System.out.println("Nombre: "+nombre);
        System.out.println("Número de cuenta: "+numeroCuenta);
        System.out.println("Direccion: "+direccion);
        System.out.println("Teléfono: "+telefono);
        System.out.println("email: "+email);
        System.out.println("Saldo: "+saldo);
    }
    
    public void hacerRetiro(Double retiro){
        if (retiro<=saldo){ 
            if(retiro>0){
                saldo = saldo - retiro;
            }else{
                System.out.println("La cantidad no puede ser negativa ");
            }
        }else{
            System.out.println("Saldo insuficiente");
        }
        
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
}
