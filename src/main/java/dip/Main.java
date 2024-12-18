package dip;

public class Main {
    public static void main(String[] args) {
        // Usamos diferentes implementaciones de PaymentMethod

        PaymentMethod creditCard = new CreditCardPayment();
        PaymentProcessor processor1 = new PaymentProcessor(creditCard);
        processor1.makePayment(150.0);  // Pago con tarjeta de crédito

        PaymentMethod paypal = new PayPalPayment();
        PaymentProcessor processor2 = new PaymentProcessor(paypal);
        processor2.makePayment(200.0);  // Pago con PayPal

        PaymentMethod crypto = new CryptoPayment();
        PaymentProcessor processor3 = new PaymentProcessor(crypto);
        processor3.makePayment(500.0);  // Pago con criptomonedas
    }
}
