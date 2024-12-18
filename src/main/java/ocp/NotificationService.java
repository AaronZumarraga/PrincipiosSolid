package ocp;

public class NotificationService {

    // Método para enviar una notificación de acuerdo con el tipo de notificación.
    public void sendNotification(Notification notification, String message) {
        notification.send(message);
    }
}
