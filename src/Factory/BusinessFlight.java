package Factory;

//implementaciones concretas de vuelos
public class BusinessFlight implements  Flight {
    @Override
    public String getDescripcion() {
        return "Vuelo Ejecutivo";
    }
}

