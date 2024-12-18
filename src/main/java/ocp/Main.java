package ocp;

public class Main {
    public static void main(String[] args) {
        // Crear las notificaciones específicas
        Notification emailNotification = new EmailNotification();
        Notification smsNotification = new SMSNotification();
        Notification pushNotification = new PushNotification();

        // Crear el servicio de notificaciones
        NotificationService service = new NotificationService();

        // Enviar las notificaciones
        service.sendNotification(emailNotification, "Hello via Email!");
        service.sendNotification(smsNotification, "Hello via SMS!");
        service.sendNotification(pushNotification, "Hello via Push Notification!");

        // Si intentas pasar un objeto incorrecto, por ejemplo, un FaxNotification, el código no lo permitirá
        // porque FaxNotification no implementa Notification.
    }
}
