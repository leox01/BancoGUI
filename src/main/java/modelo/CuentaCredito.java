/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author leopoldomorales
 */
public class CuentaCredito extends Cuenta{
    
    private double limiteDeCredito;
    private double interesMoratorio;

    public CuentaCredito() {
    }

    public CuentaCredito(double limiteDeCredito, double interesMoratorio, String tipoDeCuenta, String nombre, String direccion, String email, String telefono, int numeroCuenta, double saldo) {
        super(tipoDeCuenta, nombre, direccion, email, telefono, numeroCuenta, saldo);
        this.limiteDeCredito = limiteDeCredito;
        this.interesMoratorio = interesMoratorio;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public double getInteresMoratorio() {
        return interesMoratorio;
    }

    public void setInteresMoratorio(double interesMoratorio) {
        this.interesMoratorio = interesMoratorio;
    }

    
    public void comprarConCredito(double compra){
        
        if(compra > 0 && compra <= limiteDeCredito )
            limiteDeCredito -= compra;
        else
            System.out.println("Error!!!");
        
    
    }
    
    public void depositarCredito(double deposito){
        if ( deposito > 0)
            limiteDeCredito += deposito;
    }
    
}
