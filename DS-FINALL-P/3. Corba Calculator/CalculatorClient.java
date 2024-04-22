import CalculatorModule.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            Calculator calc = CalculatorHelper.narrow(ncRef.resolve_str("Calculator"));

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number 1: ");
            float num1 = scanner.nextFloat();

            System.out.print("Enter number 2: ");
            float num2 = scanner.nextFloat();

            System.out.println("Result of addition: " + calc.add(num1, num2));
            System.out.println("Result of subtraction: " + calc.subtract(num1, num2));
            System.out.println("Result of multiplication: " + calc.multiply(num1, num2));
            System.out.println("Result of division: " + calc.divide(num1, num2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
