import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import java.rmi.server.*;

public class Servant extends UnicastRemoteObject implements ServerInterface {
    protected Servant() throws RemoteException {
        super();
    }

    @Override
    public String concat(String a, String b) throws RemoteException {
        System.out.println("Received String 1 from Client, " + a );
        System.out.println("Received String 2 from Client, " +  b);
        return a + b;
    }
}