package MathModules;

import IOModules.ResultResponse;

public class MethodHalving {

    Function function = new Function();

    public ResultResponse solve(double left, double right, double accuracy, int number) {
        ResultResponse resultResponse = new ResultResponse();
        double step;
        double x = 0;
        long s = System.currentTimeMillis();
        if (function.getFunction(number, left) == 0) {
            long f = System.currentTimeMillis();
            resultResponse.setSteps(0);
            resultResponse.setX(left);
            resultResponse.setTime(f - s);
            return resultResponse;
        }
        if (function.getFunction(number, right) == 0) {
            long f = System.currentTimeMillis();
            resultResponse.setSteps(0);
            resultResponse.setX(right);
            resultResponse.setTime(f - s);
            return resultResponse;
        }
        int steps = 0;
        while (right - left > accuracy) {
            step = (right - left) / 2.0;
            x = left + step;
            if (checkFun(function.getFunction(number, left)) == checkFun(function.getFunction(number, x))) left = x;
            else right = x;
            steps++;
        }
        long f = System.currentTimeMillis();
        resultResponse.setSteps(steps);
        resultResponse.setX(x);
        resultResponse.setTime(f - s);
        return resultResponse;

    }


    private int checkFun(double x) {
        if (x > 0) return 1;
        else if (x < 0) return -1;
        else return 0;
    }
}
