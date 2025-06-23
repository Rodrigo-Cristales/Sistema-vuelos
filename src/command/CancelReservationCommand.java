package command;


public class CancelReservationCommand implements  Command {

    private  String userName;

    public CancelReservationCommand(String userName){
        this.userName = userName;
    }

    public void execute(){
        System.out.println("La reserva de " + userName + " Ha sido cancelada con exio");
    }


}
