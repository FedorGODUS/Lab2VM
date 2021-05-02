package MathModules;

import IOModules.ResultResponse;

public class MethodTangent {

    Function function = new Function();

    public ResultResponse solve(double left, double right, double accuracy, int number) {
        ResultResponse resultResponse = new ResultResponse();
        double x;
        long s = System.currentTimeMillis();
        if (function.getFunction(number, left) * function.getDerivative(number, left) < 0) x = left;
        else x = right;

        double steps = 0;
        double counter = Math.abs(function.getDerivative(number, x));
        while (counter > accuracy) {
            x = (x - (function.getFunction(number, x) / function.getDerivative(number, x)));
            steps++;
            counter--;
        }
        long f = System.currentTimeMillis();
        resultResponse.setSteps(steps);
        resultResponse.setTime(f - s);
        resultResponse.setX(x);
        return resultResponse;
    }

}
