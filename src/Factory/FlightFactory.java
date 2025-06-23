package Factory;

// Crear objetos de  vuelos sin especificar clase exacta

public class FlightFactory {

    public  static  Flight vuelos(String type){
        switch(type.toLowerCase()){
            case "economy":
                return  new EconomyFlight();
            case "business":
                return  new BusinessFlight();
            default:
                throw  new IllegalArgumentException("Tipo de vuelo no reconocida, escoja una opcion valida");
        }
    }

}
