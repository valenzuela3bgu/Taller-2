import java.util.Scanner;

public class ReservaAsientos {
    public static void main(String[] args) {
        
        int asientos_disponibles = 100;
        int TR = 24;       // horas
        int TC = 12;       // horas (no se usa, pero puede añadirse si se requiere)
        int LC = 2;        // maletas
        int LP = 23;       // kg
        double M = 0.20;   // 20%
        double P = 0;      // Precio del boleto
        int Bags = 0;      // Cantidad de maletas
        int Weight = 0;    // Peso del equipaje (kg)

        // Crear un objeto Scanner para la entrada de datos
        Scanner scanner = new Scanner(System.in);

        // Entrada de datos del pasajero
        System.out.println("Ingrese información del pasajero:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Número de cédula: ");
        String numero_cedula = scanner.nextLine();

        System.out.print("Precio del boleto (P): ");
        P = scanner.nextDouble();

        System.out.print("Hora de reserva (H): ");
        int H = scanner.nextInt();

        System.out.print("Cantidad de maletas (Bags): ");   
        Bags = scanner.nextInt();

        System.out.print("Peso del equipaje (Weight en kg): ");
        Weight = scanner.nextInt();

        System.out.print("Número de asiento: ");
        int numero_asiento = scanner.nextInt();

        // Verificar disponibilidad de asientos
        if (asientos_disponibles > 0) {
            // Verificar tiempo de reserva
            if (H <= TR) {
                // Verificar restricciones de equipaje
                if (Bags <= LC && Weight <= LP) {
                    // Reserva exitosa
                    System.out.println("Cliente con reserva exitosa");
                    asientos_disponibles -= 1;

                    // Verificar tipo de boleto
                    if (P >= 50) {
                        System.out.println("Su boleto es de Primera clase con destino a Miami, señor/a " + nombre);
                    } else {
                        System.out.println("Su boleto es de clase Turista con destino a Orlando, señor/a " + nombre);
                    }
                } else {
                    System.out.println("Error: Equipaje excede límites permitidos");
                }
            } else {
                // Penalización por reserva tardía
                double monto_multa = P * M;
                System.out.println("Penalización aplicada: $" + String.format("%.2f", monto_multa));

                // Verificar tipo de boleto
                if (P >= 50) {
                    System.out.println("Su boleto es de Primera clase con destino a Miami, señor/a " + nombre);
                } else {
                    System.out.println("Su boleto es de clase Turista con destino a Orlando, señor/a " + nombre);
                }
            }
        } else {
            System.out.println("No hay asientos disponibles");
        }
        scanner.close();
    }
}
