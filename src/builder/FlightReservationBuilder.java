package builder;

public  interface FlightReservationBuilder {
    void setNombrePasjero(String name);

    void setTipoVuelo(String type);

    void setAsiento(String seat);

    FlightReservation build();
}
