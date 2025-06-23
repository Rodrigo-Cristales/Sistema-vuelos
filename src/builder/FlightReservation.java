package builder;

public class FlightReservation {
    private String nombrePasajero;
    private String asiento;
    private String Tipo_vuelo;

    public void setNombrePasjero(String nombrePasajero){
        this.nombrePasajero = nombrePasajero;
    }
    public void setTipoVuelo(String Tipo_vuelo){
        this.Tipo_vuelo = Tipo_vuelo;
    }

    public void setAsiento(String asiento){
        this.asiento = asiento;
    }

    public String getDetalles(){
        return "Resevar para: " + nombrePasajero + ", Tipo de vuelo: " + Tipo_vuelo + ", Asiento: " + asiento;
    }

}
