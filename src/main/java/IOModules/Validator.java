package IOModules;

import MathModules.Function;

public class Validator {

    Function function = new Function();
    Error error = new Error();

    public boolean checkAnswers(double f, double s, int number){
        double functionFirst = function.getFunction(number,f);
        double functionSecond = function.getFunction(number,s);
        if (functionFirst*functionSecond<0){
            return true;
        }
        else {
            error.createError(4);
            return false;
        }
    }
}
