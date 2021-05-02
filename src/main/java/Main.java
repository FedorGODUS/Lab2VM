import GraphModules.GraphModule;
import IOModules.Error;
import IOModules.IOModule;
import IOModules.ResultResponse;
import IOModules.ResultSystemResponse;
import MathModules.Function;
import MathModules.FunctionSystem;
import MathModules.MethodHalving;
import MathModules.MethodNewton;
import MathModules.MethodTangent;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        IOModule ioModule = new IOModule();Function function = new Function();
        FunctionSystem functionSystem = new FunctionSystem();
        Error error = new Error();

        Double left=null;
        Double right=null;
        double accuracy;
        Double appX1=null;
        Double appX2=null;
        int number = ioModule.inputNumber();
        GraphModule graphModule = new GraphModule(number);
        if (number>0 && number<=3){
            left= ioModule.inputLeft();
            right=ioModule.inputRight();
            graphModule.drawGraphFunction( function.getFunctionString(number));
        }
        else if (number>3 && number<=5){
            appX1= ioModule.inputApproximationForX1();
            appX2=ioModule.inputApproximationForX2();
            graphModule.drawGraphSystem(functionSystem.getFunctionString(number)[0],functionSystem.getFunctionString(number)[1]);
        }
        accuracy=ioModule.inputAccuracy();


        if (number <= 3){
            System.out.println("HalvingMethod");
            MethodHalving methodHalving= new MethodHalving();
            ResultResponse resultResponseHalving = methodHalving.solve(left,right,accuracy,number);
            if (resultResponseHalving.getX()>=left && resultResponseHalving.getX()<=right){
                ioModule.printResult(resultResponseHalving);
            }
            else error.createError(4);
            System.out.println();
            System.out.println("TangentMethod");
            MethodTangent methodTangent = new MethodTangent();
            ResultResponse resultResponseTangent = methodTangent.solve(left,right,accuracy,number);
            if (resultResponseTangent.getX()>=left && resultResponseTangent.getX()<=right){
                ioModule.printResult(resultResponseTangent);
            }
            else error.createError(4);        }
        else {
            MethodNewton methodNewton = new MethodNewton();
            ResultSystemResponse resultSystemResponse = methodNewton.solve(number,appX1,appX2,accuracy);
            ioModule.printSystemResult(resultSystemResponse);
        }

    }
}
