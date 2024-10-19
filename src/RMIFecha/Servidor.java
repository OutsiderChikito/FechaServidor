/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RMIFecha;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor extends UnicastRemoteObject implements Fecha {

    public Servidor() throws RemoteException {
        super();
    }

    @Override
    public void horaActual(String a) throws RemoteException {
        System.out.println("La fecha y hora actual son: " + a);
    }

    public static void main(String[] args) {
        try {
            // Crear el objeto servidor
            Servidor servidor = new Servidor();

            // Registrar el servicio en el registro RMI
            Registry registry = LocateRegistry.createRegistry(8080);
            registry.bind("FechaService", servidor);

            System.out.println("Servidor listo.");
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }

}
