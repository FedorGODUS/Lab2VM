package IOModules;

import java.util.Objects;
import java.util.Scanner;

public class IOModule {
    Scanner scanner = new Scanner(System.in);

    private void printData() {
        System.out.println(
                "1. х^3 – 0.7x^2 + 0,2x + 1.5 = 0\n" +
                        "2. e^(2x) + 5x - 10 = 0\n" +
                        "3. sin(x) + 0.7x^2 = 0\n" +
                        "4.\n" +
                        "| sin(x1) + 3x2 + 2 = 0\n" +
                        "| e^(x1) + 4x2 + 10 = 0\n" +
                        "5.\n" +
                        "| 2x1 + x2 + 8 = 0\n" +
                        "| (x1)^2 + 2x2 + 1 = 0");
    }

    private void printLeft() {
        System.out.println("Введите левую границу отрезка:");
    }

    private void printRight() {
        System.out.println("Введите правую границу отрезка:");
    }

    private void printApproximationForX1() {
        System.out.println("Введите начальное приближение для x1");
    }

    private void printApproximationForX2() {
        System.out.println("Введите начальное приближение для x2");
    }

    private void printAccuracy() {
        System.out.println("Введите точность:");
    }

    public Double inputLeft() {
        printLeft();
        String leftSt = scanner.next();
        try {
            return Double.parseDouble(leftSt);
        } catch (NumberFormatException e) {
            System.out.println("not correct");
            return null;
        }
    }

    public Double inputRight() {
        printRight();
        String rightSt = scanner.next();
        try {
            return Double.parseDouble(rightSt);
        } catch (NumberFormatException e) {
            System.out.println("not correct");
            return null;
        }
    }

    public Double inputApproximationForX1() {
        printApproximationForX1();
        String approximationForX1 = scanner.next();
        try {
            return Double.parseDouble(approximationForX1);
        } catch (NumberFormatException e) {
            System.out.println("not correct");
            return null;
        }
    }

    public Double inputApproximationForX2() {
        printApproximationForX2();
        String approximationForX2 = scanner.next();
        try {
            return Double.parseDouble(approximationForX2);
        } catch (NumberFormatException e) {
            System.out.println("not correct");
            return null;
        }
    }

    public Double inputAccuracy() {
        printAccuracy();
        String accuracy = scanner.next();
        try {
            return Double.parseDouble(accuracy);
        } catch (NumberFormatException e) {
            System.out.println("not correct");
            return null;
        }
    }

    public Integer inputNumber() {
        printData();
        String number = scanner.next();
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("not correct");
            return null;
        }
    }

    public void printResult(ResultResponse resultResponse) {
        System.out.println(
                "time: " + resultResponse.getTime() + "\n" +
                        "steps: " + resultResponse.getSteps() + "\n" +
                        "x: "+resultResponse.getX()
        );
    }

    public void printSystemResult(ResultSystemResponse resultResponse) {
        System.out.println(
                "time: " + resultResponse.getTime() + "\n" +
                        "steps: " + resultResponse.getSteps() + "\n" +
                        "x1: "+resultResponse.getX1()+"\n"+
                        "x2: "+resultResponse.getX2()
        );
    }


}
