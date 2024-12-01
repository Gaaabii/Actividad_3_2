package actividad3_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase Calculadora proporciona operaciones matemáticas básicas
 * como suma, resta, multiplicación, división, y cálculo de potencias.
 * También permite ver y limpiar el historial de operaciones realizadas.
 */
public class Calculadora {

    private ArrayList<String> historial;

    /**
     * Constructor de la clase Calculadora. Inicializa el historial de operaciones.
     */
    public Calculadora() {
        historial = new ArrayList<>();
    }

    /**
     * Realiza la suma de dos números enteros.
     * 
     * @param a Primer número para sumar.
     * @param b Segundo número para sumar.
     * @return El resultado de la suma de a y b.
     */
    public int sumar(int a, int b) {
        int resultado = a + b;
        historial.add("Suma: " + a + " + " + b + " = " + resultado);
        return resultado;
    }

    /**
     * Realiza la resta de dos números enteros.
     * 
     * @param a Primer número para restar.
     * @param b Segundo número para restar.
     * @return El resultado de la resta de a y b.
     */
    public int restar(int a, int b) {
        int resultado = a - b;
        historial.add("Resta: " + a + " - " + b + " = " + resultado);
        return resultado;
    }

    /**
     * Realiza la multiplicación de dos números enteros.
     * 
     * @param a Primer número para multiplicar.
     * @param b Segundo número para multiplicar.
     * @return El resultado de la multiplicación de a y b.
     */
    public int multiplicar(int a, int b) {
        int resultado = a * b;
        historial.add("Multiplicación: " + a + " * " + b + " = " + resultado);
        return resultado;
    }

    /**
     * Realiza la división de dos números enteros. Si el divisor es 0, lanza una excepción.
     * 
     * @param a Numerador de la división.
     * @param b Denominador de la división.
     * @return El resultado de la división de a entre b.
     * @throws ArithmeticException Si el denominador es 0.
     */
    public double dividir(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        double resultado = (double) a / b;
        historial.add("División: " + a + " / " + b + " = " + resultado);
        return resultado;
    }

    /**
     * Realiza el cálculo de la potencia de un número con un exponente no negativo.
     * 
     * @param base La base de la potencia.
     * @param exponente El exponente de la potencia.
     * @return El resultado de base elevado a la potencia de exponente.
     * @throws IllegalArgumentException Si el exponente es negativo.
     */
    public double potencia(int base, int exponente) throws IllegalArgumentException {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente no puede ser negativo.");
        }
        double resultado = Math.pow(base, exponente);
        historial.add("Potencia: " + base + " ^ " + exponente + " = " + resultado);
        return resultado;
    }

    /**
     * Devuelve el historial de operaciones realizadas.
     * 
     * @return Un ArrayList con las operaciones realizadas en formato de texto.
     */
    public ArrayList<String> verHistorial() {
        return historial;
    }

    /**
     * Limpia el historial de operaciones.
     */
    public void limpiarHistorial() {
        historial.clear();
        System.out.println("El historial ha sido limpiado.");
    }

    /**
     * Método principal que ejecuta el menú de la calculadora y permite al usuario realizar operaciones.
     * 
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        boolean salir = false;

        while (!salir) {
            System.out.println("=== Calculadora Avanzada ===");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Potencia");
            System.out.println("6. Ver historial");
            System.out.println("7. Limpiar historial");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el primer número: ");
                    int a = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    int b = scanner.nextInt();
                    System.out.println("Resultado: " + calculadora.sumar(a, b));
                    break;
                case 2:
                    System.out.print("Ingrese el primer número: ");
                    a = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    b = scanner.nextInt();
                    System.out.println("Resultado: " + calculadora.restar(a, b));
                    break;
                case 3:
                    System.out.print("Ingrese el primer número: ");
                    a = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    b = scanner.nextInt();
                    System.out.println("Resultado: " + calculadora.multiplicar(a, b));
                    break;
                case 4:
                    System.out.print("Ingrese el primer número: ");
                    a = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    b = scanner.nextInt();
                    try {
                        System.out.println("Resultado: " + calculadora.dividir(a, b));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la base: ");
                    int base = scanner.nextInt();
                    System.out.print("Ingrese el exponente: ");
                    int exponente = scanner.nextInt();
                    try {
                        System.out.println("Resultado: " + calculadora.potencia(base, exponente));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Historial de operaciones:");
                    for (String operacion : calculadora.verHistorial()) {
                        System.out.println(operacion);
                    }
                    break;
                case 7:
                    calculadora.limpiarHistorial();
                    break;
                case 8:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}

