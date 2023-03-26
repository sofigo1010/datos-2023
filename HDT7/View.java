import java.util.Scanner;

public class View {
    String answ;
    int answer;
    Scanner sc = new Scanner(System.in);

    /** para recibir la dirección del archivo que contiene las palabras en todos los idiomas
     * @return String
     */
    public String inicioescogerdiccionario (){
        System.out.println("Bienvenido al traductor enchilada nicolita! Ingrese la dirección del archivo que contiene el diccionario");
        answ = sc.nextLine();
        answ += sc.next();
        return answ;
    }

    /** para recibir la dirección del archivo que contiene la oración a traducir
     * @return String
     */
    public String iniciotextoatraducir(){
        System.out.println("Ahora ingrese la dirección del archivo que contiene el texto que desea traducir");
        answ = sc.nextLine();
        answ += sc.next();
        return answ;
    }
    

}
