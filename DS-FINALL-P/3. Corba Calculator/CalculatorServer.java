import CalculatorModule.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

public class CalculatorServer {
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            CalculatorImpl calcImpl = new CalculatorImpl();
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(calcImpl);

            NamingContextExt ncRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));

            NameComponent path[] = ncRef.to_name("Calculator");
            ncRef.rebind(path, ref);

            System.out.println("Calculator Server is ready...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
