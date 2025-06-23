package command;
//Controlador para mantener una sola instancia global en todo el sistema de reservas

public class ReservationInvoker {
    private  Command command;

        public void setCommand(Command command){
            this.command = command;
        }

        public void executeCommand(){
            if(command != null){
                command.execute();
            }
        }

}
