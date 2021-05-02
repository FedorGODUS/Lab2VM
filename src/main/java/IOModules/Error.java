package IOModules;

public class Error {

    public void createError(int errorNumber){
        switch (errorNumber){
            case 1:
                System.out.println("не монотонна");
                break;
            case 2:
                System.out.println("no solutions, steps are out of available");
                break;
            case 3:
                System.out.println("no sxodimost");
                break;
            case 4:
                System.out.println("no x");
                break;
            case 5:
                System.out.println("yakob=null");
                break;
            default:
        }
    }
}
