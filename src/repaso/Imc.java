package repaso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Imc {
    static String name;
    static String email;
    static String password;
    static double weight;
    static double height;
    static boolean state;
    static boolean isActivate;
    public static List<Double> imcs = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isOn = turnSystem();
        while (isOn) {
            isOn = menu();
        }

    }

    public static void toRegistrer() {
        System.out.println("Ingrese su nombre");
        name = sc.next();
        System.out.println("Ingrese su correo");
        email = sc.next();
        System.out.println("Ingrese su password");
        password = sc.next();
    }

    public static void login() {
        System.out.println("Ingrese su correo");
        String userName = sc.next();
        System.out.println("Ingrese su contraseña");
        String pass = sc.next();
        if (userName.equals(email) && pass.equals(password)) {
            System.out.println("Puedes pasar");
            isActivate = true;
            do {
                isActivate = menuApp();
            }while (isActivate);

        } else {
            System.out.println("Usuarios o contraseña incorrectas");
            menu();
        }
    }

    public static boolean menu() {
        System.out.println("Bienvenido al programa para calcular el imc: \n 1:Registrar \n 2:Login \n 3:Apagar sistema");
        int opt = sc.nextInt();
        switch (opt) {
            case 1:
                toRegistrer();
                break;
            case 2:
                login();
                break;
            case 3:
                System.out.println("Se eligio apagar el sistema");
                state = false;

                break;
            default:
                System.out.println("Por favor elija un opcion correcta");
        }
        return state;
    }

    public static boolean turnSystem() {
        System.out.println("Desea encender el sistema? \n 1:Si\n2:No");
        int opt = sc.nextInt();
        if (opt == 1) {
            state = true;
        }
        return state;
    }

    public static void calculateImc() {
        System.out.println("Ingrese su peso");
        weight = sc.nextDouble();
        System.out.println("Ingrese su altura");
        height = sc.nextDouble();
        double imc = weight / (height * height);
        System.out.println(imc);
        if (imc <= 18.5) {
            System.out.println("Bajo");
        } else if (imc > 18.5 && imc <= 24.9) {
            System.out.println("Normal");
        } else if (imc > 24.9 && imc <= 29.9) {
            System.out.println("Sobrepeso");
        } else {
            System.out.println("Sobrepeso");
        }
        imcs.add(imc);
    }

    public static boolean menuApp() {
        System.out.println("1:Ingresar Imc \n2:Listar Imc \n3:Volver al menu");
        int opt = sc.nextInt();
        switch (opt) {
            case 1:
                calculateImc();
                break;
            case 2:
                System.out.println("Listar todos los imc");
                listarImcs();
                break;
            case 3:
                System.out.println("Volviendo al menu");
                isActivate = false;
                break;
        }
        return isActivate;
    }

    private static void listarImcs() {
        int index = 1;
        for (Double imc :imcs) {
            System.out.println("Registro " + index + " imc es: " + imc);
            index++;
        }
    }
}
