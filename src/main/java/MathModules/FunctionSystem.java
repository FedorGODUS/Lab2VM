package MathModules;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FunctionSystem {


    public double getFirstFunctionFromSystem(int number, double x1, double x2){
        switch (number){
            case 4:
                return Math.sin(x1)+3*x2+2;
            case 5:
                return 2*x1+x2+8;
            default:
                return 0;
        }
    }

    public double getSecondFunctionFromSystem(int number, double x1, double x2){
        switch (number){
            case 4:
                return Math.pow(Math.E,x1)+4*x2+10;
            case 5:
                return Math.pow(x1,2)+2*x2+1;
            default:
                return 0;
        }
    }

    public double[] getFirstDerivativeFromFirstFunction(int number, double x1, double x2){
        switch (number){
            case 4:
                return new double[]{Math.cos(x1),3};
            case 5:
                return new double[]{2,1};
            default:
                return new double[2];
        }
    }
    public double[] getFirstDerivativeFromSecondFunction(int number, double x1, double x2){
        switch (number){
            case 4:
                return new double[]{Math.pow(Math.E,x1),4};
            case 5:
                return new double[]{2*x1,2};
            default:
                return new double[2];
        }
    }

    public static double[] getFunction(int number, double x) {
        switch (number) {
            case 4:
                return new double[]{(Math.sin(x)+2)/-3,(Math.pow(Math.E,x)+8)/-4};
            case 5:
                return new double[]{-2*x-8,(Math.pow(x,2)+1)/-2};
            default: return new double[2];
        }
    }

    public static String[] getFunctionString(int number) {
        switch (number) {
            case 4:
                return new String[]{"sin(x1) + 3x2 + 2","e^(x1) + 4x2 + 10"};
            case 5:
                return new String[]{"2x1 + x2 + 8","(x1)^2 + 2x2 + 1"};
            default: return new String[2];
        }
    }



}
