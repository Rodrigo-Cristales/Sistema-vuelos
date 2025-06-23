package strategy;

//cambiar dinamicamente la forma de pagar
public class CreditCardPayment implements PaymentStrategy {
        private String numero_de_tarjeta;
        private String titular_de_tarjeta;

        public  CreditCardPayment(String numero_de_tarjeta, String titular_de_tarjeta){
            this.numero_de_tarjeta = numero_de_tarjeta;
            this.titular_de_tarjeta = titular_de_tarjeta;
            }

            public void pay(double cantidad){
                System.out.println("Pagando $ " + cantidad + " con tarjeta de credito de " + titular_de_tarjeta);
            }
}
