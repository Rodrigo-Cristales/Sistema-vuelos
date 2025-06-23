package strategy;
//cambiar dinamicamente la forma de pagar

public class PayPalPayment implements PaymentStrategy {

    private  String email;

        public  PayPalPayment(String email ){
            this.email = email;
        }

        public void pay(double cantidad){
            System.out.println("Pagando $ " + cantidad + " Usando PayPal con la cuenta : " + email);
        }

}
