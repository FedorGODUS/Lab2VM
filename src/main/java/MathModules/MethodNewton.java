package MathModules;

import IOModules.Error;
import IOModules.ResultSystemResponse;
import lombok.Data;

import java.util.Objects;

@Data
public class MethodNewton {
    FunctionSystem functionSystem = new FunctionSystem();
    Error error = new Error();

    private double yakobian(double x1, double x2, int number) {
        double[] derivativeFirst = functionSystem.getFirstDerivativeFromFirstFunction(number, x1, x2);
        double[] derivativeSecond = functionSystem.getFirstDerivativeFromSecondFunction(number, x1, x2);
        return derivativeFirst[0] * derivativeSecond[1] - derivativeFirst[1] * derivativeSecond[0];
    }

    private double[][] inverseYakobian(double x1, double x2, int number) {
        double[] derivativeFirst = functionSystem.getFirstDerivativeFromFirstFunction(number, x1, x2);
        double[] derivativeSecond = functionSystem.getFirstDerivativeFromSecondFunction(number, x1, x2);
        double yakob = yakobian(x1, x2, number);
        if (yakob != 0) {
            return new double[][]{
                    {derivativeSecond[1] / yakob, -derivativeFirst[1] / yakob},
                    {-derivativeSecond[0] / yakob, derivativeFirst[0] / yakob}
            };
        }
        return null;
    }

    public ResultSystemResponse solve(int number, double accX1, double accX2, double accuracy) {
        ResultSystemResponse resultSystemResponse = new ResultSystemResponse();
        double steps = 0;
        double x1;
        double x2;
        double x01 = accX1;
        double x02 = accX2;
        while (true) {
            long s= System.currentTimeMillis();
            if (steps < 1000) {
                double[][] inverseYakob = inverseYakobian(x01, x02, number);
                if (Objects.nonNull(inverseYakob)) {
                    ++steps;
                    double h1 = inverseYakob[0][0] * functionSystem.getFirstFunctionFromSystem(number, x01, x02) + inverseYakob[0][1] * functionSystem.getSecondFunctionFromSystem(number, x01, x02);
                    double h2 = inverseYakob[1][0] * functionSystem.getFirstFunctionFromSystem(number, x01, x02) + inverseYakob[1][1] * functionSystem.getSecondFunctionFromSystem(number, x01, x02);
                    x1 = x01 - h1;
                    x2 = x02 - h2;

                    if (Math.max(Math.abs(x1 - x01), Math.abs(x2 - x02)) <= accuracy) {
                        long f= System.currentTimeMillis();
                        resultSystemResponse.setSteps(steps);
                        resultSystemResponse.setTime(s-f);
                        resultSystemResponse.setX1(x1);
                        resultSystemResponse.setX2(x2);
                        break;
                    }
                    x01 = x1;
                    x02 = x2;
                } else {
                    long f= System.currentTimeMillis();
                    resultSystemResponse.setSteps(steps);
                    resultSystemResponse.setTime(s-f);
                    error.createError(5);
                    return null;
                }
            }
            else {
                long f= System.currentTimeMillis();
                resultSystemResponse.setSteps(steps);
                resultSystemResponse.setTime(s-f);
                error.createError(2);
                return null;
            }


        }
        return resultSystemResponse;

    }
}
