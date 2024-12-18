package dip;

public class PaymentProcessor {
    private PaymentMethod paymentMethod;  // Dependencia de la interfaz PaymentMethod

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;  // Se pasa la implementación específica en el constructor
    }

    public void makePayment(double amount) {
        paymentMethod.processPayment(amount);  // Usamos el método polimórfico
    }
}
