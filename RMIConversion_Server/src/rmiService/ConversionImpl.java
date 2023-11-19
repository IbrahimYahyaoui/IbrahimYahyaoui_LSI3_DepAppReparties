package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implémentation de l'interface IConversion pour le service de conversion RMI
public class ConversionImpl extends UnicastRemoteObject implements IConversion {

    // Constructeur par défaut qui appelle le constructeur de la classe parente
    public ConversionImpl() throws RemoteException {
    }

    // Méthode d'implémentation de la conversion
    // Multiplie le montant donné par 3.3 pour simuler une conversion arbitraire
    @Override
    public double convertirMontant(double mt) throws RemoteException {
        return mt * 3.3;
    }
}
