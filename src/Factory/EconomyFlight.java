package Factory;

// implementaciones concretas de vuelos
public class EconomyFlight implements  Flight {

    @Override
    public String getDescripcion() {
        return "Vuelo Economico";
    }
}
