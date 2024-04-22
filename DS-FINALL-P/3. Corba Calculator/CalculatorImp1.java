import CalculatorModule.*;

class CalculatorImpl extends CalculatorPOA {
    public float add(float num1, float num2) {
        System.out.println("Adding " + num1 + " and " + num2);
        return num1 + num2;
    }

    public float subtract(float num1, float num2) {
        System.out.println("Subtracting " + num1 + " and " + num2);
        return num1 - num2;
    }

    public float multiply(float num1, float num2) {
        System.out.println("Multiplying " + num1 + " and " + num2);
        return num1 * num2;
    }

    public float divide(float num1, float num2) {
        System.out.println("Dividing " + num1 + " and " + num2);
        if (num2 != 0) {
            return num1 / num2;
        } else {
            return Float.NaN; // Indicate division by zero
        }
    }
}
