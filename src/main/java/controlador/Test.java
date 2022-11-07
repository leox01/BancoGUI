/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import controlador.Controlador;
import modelo.CuentaAhorro;
/**
 *
 * @author leopoldomorales
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Controlador controlador = new Controlador();
        
     
        
        System.out.println(controlador.iDyNumeroDeCuentaRepetidos("1", 1));
        System.out.println(controlador.crearCuentaDeAhorros("1", "Leo", "calle 123","leo01@gmail.com", "33166009516", 1, 2));
        System.out.println(controlador.iDyNumeroDeCuentaRepetidos("1", 1));
        
        
        CuentaAhorro cuentaAhorro = controlador.buscarCuentaAhorro(1);
        
        System.out.println(cuentaAhorro.getId());
        System.out.println(cuentaAhorro.getNombre());
        System.out.println(cuentaAhorro.getDireccion());
        System.out.println(cuentaAhorro.getTelefono());
        System.out.println(cuentaAhorro.getEmail());
        System.out.println(cuentaAhorro.getNumeroCuenta());
        System.out.println(cuentaAhorro.getSaldo());
        
        
        controlador.editarCuentaDeAhorro("2", "Leo2", "calle 1232", "2", "2", 2, 0, 1);
        
        
        cuentaAhorro = controlador.buscarCuentaAhorro(2);
        
        System.out.println(cuentaAhorro.getId());
        System.out.println(cuentaAhorro.getNombre());
        System.out.println(cuentaAhorro.getDireccion());
        System.out.println(cuentaAhorro.getTelefono());
        System.out.println(cuentaAhorro.getEmail());
        System.out.println(cuentaAhorro.getNumeroCuenta());
        System.out.println(cuentaAhorro.getSaldo());
        
        
        System.out.println(controlador.eliminarCuentaDeAhorro(2));
        
        
        cuentaAhorro = controlador.buscarCuentaAhorro(2);
        System.out.println(cuentaAhorro.getId());
        System.out.println(cuentaAhorro.getNombre());
        System.out.println(cuentaAhorro.getDireccion());
        System.out.println(cuentaAhorro.getTelefono());
        System.out.println(cuentaAhorro.getEmail());
        System.out.println(cuentaAhorro.getNumeroCuenta());
        System.out.println(cuentaAhorro.getSaldo());
        
    }
    
}
