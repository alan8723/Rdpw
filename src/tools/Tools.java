package tools;

import java.util.Scanner;

/**
 *
 * @author Alhann
 * herramientas para aguilizar el codigo del programa (validacion, obtener datos del usuario, etc)
 */
public class Tools {
    /**
     *@param mensaje String que se muestra en pantalla
     * @param mensajeError String que se muestra en caso deun error
     * @return respuesta numero entero que ingresa el usuario
     **/
    public static int getInt(String mensaje, String mensajeError){
        String buffer;      
        Scanner sc = new Scanner(System.in);  
        System.out.println(mensaje);
        buffer = sc.nextLine();

        while(validarEntero(buffer) == false){
            System.out.println(mensajeError);
            buffer = sc.nextLine();
        }
        
        int respuesta = Integer.valueOf(buffer);

        return respuesta;
    }
    
    public static String getString(String mensaje){
        String buffer;      
        Scanner sc = new Scanner(System.in);  
        System.out.println(mensaje);
        buffer = sc.nextLine();
        
        String respuesta = buffer;

        return respuesta;
    }
    /**
     *@param numero String buffer de entrada para validar si contiene solo numeros
     *@return boolean (true) si contiene solo numeros (false) si no contiene solo numeros
     **/
    public static boolean validarEntero(String numero){
        int number;
        try{
            number = Integer.valueOf(numero);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
