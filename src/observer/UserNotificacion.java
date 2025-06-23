package observer;

public class UserNotificacion implements Observer {
    private String userName;

    public  UserNotificacion(String userName){
        this.userName = userName;
    }

    public  void update(String menssage){
        System.out.println("Notificacion para " + userName + ": " +menssage);
    }
}
