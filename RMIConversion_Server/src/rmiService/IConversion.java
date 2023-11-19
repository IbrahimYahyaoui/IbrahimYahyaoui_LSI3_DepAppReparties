package rmiService;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface définissant un service de conversion RMI
public interface IConversion extends Remote {

    // Méthode permettant de convertir un montant
    // Cette méthode peut lever une exception RemoteException en cas d'erreur de communication
    double convertirMontant(double mt) throws RemoteException;
}
