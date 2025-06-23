package builder;

public class ConcreteFlightReservationBuilder implements FlightReservationBuilder {

    private FlightReservation reservation;

    public  ConcreteFlightReservationBuilder(){
        reservation = new FlightReservation();
    }

    @Override
    public void setNombrePasjero(String name) {
        reservation.setNombrePasjero(name);
    }

    @Override
    public void setTipoVuelo(String type) {
        reservation.setTipoVuelo(type);
    }

    @Override
    public void setAsiento(String seat) {
        reservation.setAsiento(seat);
    }

    @Override
    public FlightReservation build() {
        return reservation;
    }
}
