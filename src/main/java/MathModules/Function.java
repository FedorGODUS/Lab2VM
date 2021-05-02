package MathModules;

import lombok.Data;

@Data
public class Function {


    public static double getFunction(int number, double x) {
        switch (number) {
            case 1:
                return Math.pow(x, 3) - 0.7 * Math.pow(x, 2) + 0.2 * x + 1.5;
            case 2:
                return Math.pow(Math.E, 2 * x) + 5 * x - 10;
            case 3:
                return Math.sin(x) + 0.7 * Math.pow(x, 2);
            default:
                return 0;
        }
    }


    public double getDerivative(int number, double x) {
        switch (number) {
            case 1:
                return 3 * Math.pow(x, 2) - 1.4 * x + 0.2;
            case 2:
                return 2 * Math.pow(Math.E, 2 * x) + 3;
            case 3:
                return Math.cos(x) + 1.4 * x;
            default:
                return 0;
        }
    }

    public String getFunctionString(int number) {
        switch (number) {
            case 1:
                return "x^3-0.7x^2+0.2x+1.5";
            case 2:
                return "e^(2x)+5x-10";
            case 3:
                return "sin(x)+0.7x^2";
            default:
                return "";
        }
    }
}
