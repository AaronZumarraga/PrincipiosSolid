package isp;

public class Main {
    public static void main(String[] args) {
        // Crear un teléfono y una cámara desechable
        Turnable phone = new Phone();
        Turnable camera = new DisposableCamera();

        // Operar el teléfono
        phone.turnOn();
        if (phone instanceof Chargeable) {
            ((Chargeable) phone).charge();
        }
        phone.turnOff();

        // Operar la cámara desechable
        camera.turnOn();
        camera.turnOff();  // No hay necesidad de comprobar si puede cargarse
    }
}
