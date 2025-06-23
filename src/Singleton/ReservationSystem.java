package Singleton;

//Controlar que exista una sola instancia global del sistema de reservas
public class ReservationSystem {

    private static ReservationSystem instance;

    private ReservationSystem(){
        System.out.println("Sistema de reservas para vuelos");
    }

    public static  ReservationSystem getInstance(){
        if(instance == null){
            instance = new ReservationSystem();
        }
        return  instance;
    }

    public  void log(String message){
        System.out.println(message);
    }
}
