import java.util.Scanner;

public class MaquinaExpendedora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Productos
        double saldo = 0.0, max_saldo = 5.0;
        String[] prods = {"Coca-Cola","Chips","Chocolate","Agua"};
        double[] precios = {1.50,1.00,1.25,0.75};
        int[] stock = {10,8,12,15};
        
        
        // Monedas
        double[] mon_val = {0.10, 0.20, 0.50, 1.0, 2.0};
        
        System.out.println("Maquina Expendedora v1.0");
        
        while (true) {
            System.out.println(); // Separador
            System.out.println("Productos Disponibles");
            for (int i = 0; i < prods.length; i++) {
                System.out.println((i + 1) + ". " + prods[i] + " | Precio: " + precios[i] + "eur | Stock: " + stock[i]);
            }
            
            System.out.println(); // Separador
            
            System.out.printf("Saldo actual: %.2f€ (Max. %.2f€)%n", saldo, max_saldo_maq);
            System.out.print("[1] Insertar moneda (Validas: ");
            for (double m : mon_val) System.out.print(m + " ");
            System.out.println(")");
            }
            System.out.println(")");
            System.out.println("[2] Seleccionar producto");
            System.out.println("[3] Salir y recuperar cambio");
            System.out.print("Opcion: ");
            int opt = sc.nextInt();
            
            if (opt == 1) {
                System.out.print("Introduce moneda: ");
                double m = sc.nextDouble();
                boolean m_valida = esMonedaValida(m, mon_val);
            
                if (m_valida) {
                    if (saldo + m > max_saldo_maq) {
                        System.out.println("ERROR: La maquina no acepta mas de " + max_saldo_maq + " euros. Se devuelve " + m + " euros.");
                    } else {
                        saldo = saldo + m;
                        System.out.println("Moneda aceptada.");
                    }
                } else {
                    System.out.println("Moneda no valida. Se devuelve " + m + " euros.");
                }
            }
            
                }
            }if (opt == 2) {
                saldo = procesarCompra(sc, saldo, stock, precios);
            } else if (opt == 3) {
                if (saldo > 0) {
                    System.out.printf("No olvides recoger tu cambio: %.2f€.%n", saldo);
                }
                System.out.println("Gracias por tu visita. ¡Hasta pronto!");
                sc.close(); // Cerrar Scanner al salir
                break;
            } else {
                System.out.println("Opcion no valida.");
            }
            
            // Método para procesar la compra
            public static double procesarCompra(Scanner sc, double saldo, int[] stock, double[] precios) {
                System.out.print("Introduce el numero del producto: ");
                int sel = sc.nextInt() - 1;
            
                if (sel < 0 || sel >= stock.length) {
                    System.out.println("Seleccion invalida.");
                } else if (stock[sel] <= 0) {
                    System.out.println("Lo sentimos, producto agotado.");
                } else if (saldo < precios[sel]) {
                    System.out.printf("Saldo insuficiente. Necesitas %.2f€.%n", precios[sel]);
                } else {
                    saldo -= precios[sel];
                    stock[sel]--;
                    System.out.printf("¡Gracias! Producto %d entregado.%n", sel + 1);
                }
            
                return saldo;
            }
            
    }
}

