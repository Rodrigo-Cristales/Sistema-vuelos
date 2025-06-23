package command;

import builder.*;

public class MakeReservationCommand implements  Command {

    private FlightReservation reservation;

    public  MakeReservationCommand(FlightReservation reservation){
        this.reservation = reservation;
    }

    public void execute(){
        System.out.println("Reserva realizada");
        System.out.println(reservation.getDetalles());
    }
}
