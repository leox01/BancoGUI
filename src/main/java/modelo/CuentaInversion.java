/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author leopoldomorales
 */
public class CuentaInversion extends Cuenta{
    
    private double interes;

    public CuentaInversion() {
    }

    public CuentaInversion(double interes, String tipoDeCuenta, String nombre, String direccion, String email, String telefono, int numeroCuenta, double saldo) {
        super(tipoDeCuenta, nombre, direccion, email, telefono, numeroCuenta, saldo);
        this.interes = interes;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }
    
    public double calcularInteres(int numeroDeMeses, double saldoEstimado){
    
        for (int i = 0; i < numeroDeMeses; i++) {
            saldoEstimado = saldoEstimado + saldoEstimado * interes;
        }
        
       return saldoEstimado;
    }
    
    public void aplicarInteres(){
        double saldoActual = getSaldo();
    
        setSaldo(saldoActual+saldoActual*interes);
    }
}
