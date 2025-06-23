import Singleton.ReservationSystem;
import Factory.Flight;
import Factory.FlightFactory;
import builder.ConcreteFlightReservationBuilder;
import builder.ReservationDirector;
import builder.FlightReservation;
import strategy.*;
import observer.*;
import command.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner datos = new Scanner(System.in);

        ReservationSystem system = ReservationSystem.getInstance();
        system.log("Bienvenido al sistema de reservas de vuelos");

        System.out.println("Ingrese su nombre: ");
        String name = datos.nextLine();

        // Validar tipo de vuelo
        String tipo_vuelo = "";
        while (true) {
            System.out.println("Ingrese el tipo de vuelo (economy/business): ");
            tipo_vuelo = datos.nextLine().trim().toLowerCase();

            if (tipo_vuelo.equals("economy") || tipo_vuelo.equals("business")) {
                break;
            } else {
                System.out.println("Tipo de vuelo no válido. Intente nuevamente.");
            }
        }

        System.out.println("Número de asiento preferido: ");
        String asiento = datos.nextLine();

        Flight flight;
        double precio = 0;

        try {
            flight = FlightFactory.vuelos(tipo_vuelo);
            system.log("Vuelo creado: " + flight.getDescripcion());

            precio = tipo_vuelo.equals("economy") ? 120.0 : 140.0;
        } catch (IllegalArgumentException e) {
            system.log("Error: " + e.getMessage());
            datos.close();
            return;
        }

        // Builder
        ConcreteFlightReservationBuilder builder = new ConcreteFlightReservationBuilder();
        ReservationDirector director = new ReservationDirector(builder);
        FlightReservation reservation = director.crearReservacion(name, flight.getDescripcion(), asiento);

        // Observer
        ReservationNotifier notifier = new ReservationNotifier();
        UserNotificacion notificacion = new UserNotificacion(name);
        notifier.addObserver(notificacion);
        notifier.notifyObservers("Tu reserva fue registrada con éxito para un " + flight.getDescripcion() + ", asiento " + asiento + ".");

        // Command - Confirmar reserva
        ReservationInvoker invoker = new ReservationInvoker();
        Command confirmarReserva = new MakeReservationCommand(reservation);
        invoker.executeCommand();

        // Precio
        System.out.println("Total a pagar: $" + precio);

        // Strategy - Pago
        PaymentStrategy metodoDePago = null;
        int intentos = 0;
        while (metodoDePago == null && intentos < 3) {
            System.out.println("Seleccione un método de pago (paypal/credit):");
            String metodoPago = datos.nextLine().trim().toLowerCase();

            switch (metodoPago) {
                case "credit":
                    System.out.println("Ingrese número de tarjeta:");
                    String numeroTarjeta = datos.nextLine();
                    System.out.println("Nombre del titular:");
                    String titular = datos.nextLine();
                    metodoDePago = new CreditCardPayment(numeroTarjeta, titular);
                    break;
                case "paypal":
                    System.out.println("Ingrese email de cuenta PayPal:");
                    String email = datos.nextLine();
                    metodoDePago = new PayPalPayment(email);
                    break;
                default:
                    System.out.println("Método de pago no válido. Intente nuevamente.");
                    intentos++;
            }
        }

        if (metodoDePago == null) {
            System.out.println("Demasiados intentos fallidos. Se cancela el pago.");
            datos.close();
            return;
        }

        metodoDePago.pay(precio);

        // Command - Cancelar reserva
        System.out.println("¿Deseas cancelar tu reserva? (si/no)");
        String cancelar = datos.nextLine().trim().toLowerCase();

        if (cancelar.equals("si")) {
            Command cancelCommand = new CancelReservationCommand(name);
            invoker.setCommand(cancelCommand);
            invoker.executeCommand();

            // Notificar cancelación
            notifier.notifyObservers("Tu reserva ha sido cancelada.");
        }

        datos.close();
    }
}
