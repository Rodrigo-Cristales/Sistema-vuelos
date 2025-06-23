package builder;

public class ReservationDirector {
    private FlightReservationBuilder builder;

    public ReservationDirector(FlightReservationBuilder builder){
        this.builder = builder;
    }

    public FlightReservation crearReservacion(String name, String type, String asiento){
        builder.setNombrePasjero(name);
        builder.setTipoVuelo(type);
        builder.setAsiento(asiento);
        return builder.build();
    }
}
