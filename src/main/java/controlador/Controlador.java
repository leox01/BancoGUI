/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.CuentaAhorro;
/**
 *
 * @author leopoldomorales
 */
public class Controlador {
    
    /**
     *
     */
    public static ArrayList<CuentaAhorro> cuentasAhorros = new ArrayList<>();
    
    /**
     * Este método revisa que no esten repetidos los números de cuenta
     * recibe los siguientes parámetros
     * 
     * @param numeroDeCuenta es el número de cuenta del usuario 
     * @return retorna true cuando hay un número de cuenta repetido o falso cuando no encuentra repetido
     */
    public static boolean numeroDeCuentaRepetido(int numeroDeCuenta){
        
        for (CuentaAhorro cuentaAhorro : cuentasAhorros) {
            if(cuentaAhorro.getNumeroCuenta() == numeroDeCuenta){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Este método se utiliza para crear una nueva cuenta de ahorros, recibe los siguientes parámetros 
     * @param tipoDeCuenta es el tipo de cuenta
     * @param nombre es el nombre del usuario de la cuenta 
     * @param direccion es la direccion del cliente
     * @param email es el email con el que se registró el cliente
     * @param telefono es el teléfono del cliente
     * @param numeroCuenta es el número de cuenta y debe de ser único
     * @param saldo es el saldo de la cuenta 
     * @return retorna true cuando pudimos registrar sin problemas y false cuando hay algún error
     */
    public static boolean crearCuentaDeAhorros(String tipoDeCuenta, String nombre, String direccion, String email, String telefono, int numeroCuenta, double saldo){
    
        
        try { 
       
            cuentasAhorros.add(new CuentaAhorro(tipoDeCuenta, nombre, direccion, email, telefono, numeroCuenta, saldo));

            return true;
            
        } catch (Exception e) {
            System.out.println("Error al intentar crear una cuenta de ahorro");
            return false;
        }
       
    }
    
    /**
     *  Este método nos ayuda a buscar una cuenta dentro del arrayList a partir de recibir el numero de cuenta buscada 
     * @param numeroCuentaBuscada es un entero y es la cuenta que vamos a buscar
     * @return retorna el objeto CuentaAhorro con los datos de la cuenta buscada o retorna un objeto con -1 cuando no 
     * encuentra una cuenta con ese numero de cuenta buscado
     */
    public static CuentaAhorro buscarCuentaAhorro(int numeroCuentaBuscada){
    
        for (CuentaAhorro cuentaAhorro : cuentasAhorros) {
            if(cuentaAhorro.getNumeroCuenta() == numeroCuentaBuscada)
                return cuentaAhorro;
            
        }
        
        return new CuentaAhorro("-1", "", "", "", "", -1, 00);
    
    }
    
    /**
     * Este método nos va a regresar todo el arrayList de cuentas de ahorro
     * @return El arrayList completo de cuentasAhorros
     */
    public static ArrayList<CuentaAhorro> getTodasLasCuentasDeAhorros(){
        return cuentasAhorros;
    }
    
    /**
     * Método que busca en el arrayList un numeroCuentaViejo y si lo encuentra lo cambia por todos los nuevosValores
     * @param nuevoTipoDeCuenta nuevoTipoDeCuenta que se va a registrar
     * @param nuevoNombre nuevo nombre de la cuenta
     * @param nuevaDireccion nueva direccion de la cuenta 
     * @param nuevoEmail nuevo email a cambiar 
     * @param nuevoTelefono nuevo telefono
     * @param nuevoNumeroCuenta nuevo numero de cuenta es importante que no se confunda con la cuenta vieja y que se revise antes que ese nuevo número no este repetido
     * @param nuevoSaldo es el nuevo saldo que le pondré a la cuenta 
     * @param viejoNumeroDeCuenta es el numero de cuenta con el que se buscó en un primer momento a la cuenta
     * @return retorna true si pudo actualizar o false cuando hay un error 
     */
    public static boolean editarCuentaDeAhorro(String nuevoTipoDeCuenta, String nuevoNombre, String nuevaDireccion, String nuevoEmail, String nuevoTelefono, int nuevoNumeroCuenta, double nuevoSaldo, int viejoNumeroDeCuenta){

        for (CuentaAhorro cuentaAhorro : cuentasAhorros) {
            if(cuentaAhorro.getNumeroCuenta() == viejoNumeroDeCuenta){
            
                cuentaAhorro.setTipoDeCuenta(nuevoTipoDeCuenta);
                cuentaAhorro.setNombre(nuevoNombre);
                cuentaAhorro.setDireccion(nuevaDireccion);
                cuentaAhorro.setEmail(nuevoEmail);
                cuentaAhorro.setTelefono(nuevoTelefono);
                cuentaAhorro.setNumeroCuenta(nuevoNumeroCuenta);
                cuentaAhorro.setSaldo(nuevoSaldo);
                
                return true;
            
            }
        }
        System.out.println("No existe una cuenta con ese número de cuenta");
        return false;
    
    }
    
    /**
     * Es el método que elimina a una cuenta de ahorro, recibe como parámetro la numero de cuenta a eliminar
     * @param numeroCuentaParaEliminar numero de cuenta con el que buscaremos en el ArrayList 
     * @return retorna true cuando si puedo eliminar al usuario y false cuando hay algún error
     */
    public static boolean eliminarCuentaDeAhorro(int numeroCuentaParaEliminar){
    
        for (CuentaAhorro cuentaAhorro : cuentasAhorros) {
            if(cuentaAhorro.getNumeroCuenta() == numeroCuentaParaEliminar){
            
                cuentasAhorros.remove(cuentaAhorro);
                return true;
            
            }
        }
        
        System.out.println("No existe una cuenta con ese número de cuenta");
        return false;
    }
    
    /**
     * Este método intentará guardar un archivo en nuestro directorio 
     * Si el archivo existe solo lo actualizará, si no, lo creará
     * @return verdadero cuando pudo guardar y falso cuando no puede guardar
     */
    public static boolean guardarArchivo(){
        try {
          FileWriter myWriter = new FileWriter("cuentasDeAhorro.txt");
          
          
            for (CuentaAhorro cuentasAhorro : cuentasAhorros) {
                myWriter.write(cuentasAhorro.getNumeroCuenta()+"|");
                myWriter.write(cuentasAhorro.getNombre()+"|");
                myWriter.write(cuentasAhorro.getDireccion()+"|");
                myWriter.write(cuentasAhorro.getEmail()+"|");
                myWriter.write(cuentasAhorro.getTelefono()+"|");
                myWriter.write(cuentasAhorro.getSaldo()+"|");
                myWriter.write(cuentasAhorro.getTipoDeCuenta()+"|\n");
                
            }
         
          
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
          return true;
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
          return false;
        }
        
    }
    
    /**
     * Intentará leer un achivo o lo creará si no existe,
     * @return verdadero cuando pudo leer y falso cuando no puede leer
     */
    public static boolean leerArchivo(){
        
        int contadorDeCaracterEspecial = 0;
        String numeroCuenta;
        String nombre = "";
        String direccion = "";
        String email = "";
        String telefono = "";
        String tipoDeCuenta = "";
        String saldo;
        double saldoDouble =0;
        int numeroDecuentaInt = -1;
               
        try {
            File myArchivo = new File("cuentasDeAhorro.txt");
            Scanner myReader = new Scanner(myArchivo);
            while (myReader.hasNextLine()) {
              contadorDeCaracterEspecial = 0;
              String registro = myReader.nextLine();
              String acumuladorCaracteres = "";
                for (char caracter : registro.toCharArray()) {
                    
                    if(caracter != '|'){
                        
                        acumuladorCaracteres += caracter;
                    }else{
                        contadorDeCaracterEspecial++;
                        switch (contadorDeCaracterEspecial) {
                            case 1 :
                                numeroCuenta = acumuladorCaracteres;
                                
                                try {
                                    numeroDecuentaInt = Integer.parseInt(numeroCuenta);
                                    
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                               
                                break;
                            case 2 :
                                nombre = acumuladorCaracteres;
                               
                                break;
                            case 3 :
                                direccion = acumuladorCaracteres;
                                
                                break;
                            case 4 :
                                email = acumuladorCaracteres;
                                
                                break;
                            case 5 :
                                telefono = acumuladorCaracteres;
                               
                                break;
                            case 6 :
                                saldo = acumuladorCaracteres;
                                
                                try {
                                    saldoDouble = Double.parseDouble(saldo);
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                
                                break;
                            case 7 :
                                tipoDeCuenta = acumuladorCaracteres;
                               
                                break;
                              
                           
                        }
                         acumuladorCaracteres = "";
                    }
                }
                
                 
                cuentasAhorros.add(new CuentaAhorro(tipoDeCuenta, nombre, direccion, email, telefono, numeroDecuentaInt, saldoDouble));
              
            }
            myReader.close();
            return true;
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
        
        
    }
    
    
    public static void crearArchivo(){
    
        try {
            File myFile = new File("cuentasDeAhorro.txt");
            if (myFile.createNewFile()) {
              System.out.println("File created: " + myFile.getName());
            } else {
              System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    
    }
    
    
    
}
