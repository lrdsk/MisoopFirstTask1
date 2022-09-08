import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x1 = 0;
        double x2 = 0;
        double diskr = 0;

        System.out.println("Введите коэффициенты квадратного уравнения (в формате a,b,c): ");
        String s = input.nextLine();

        String[] tempArray = s.split(",");
        int sizeArray = tempArray.length;

        if(sizeArray == 3){
            double[] coef = fillArrayDouble(tempArray);
            if(coef[0] == 0){
                System.out.println("Это не квадратное уравнение");
            } else if(coef[1] != 0 & coef[2] != 0){
                diskr = Math.sqrt(coef[1]*coef[1] - 4*coef[0]*coef[2]);
                x1 = (-coef[1] - diskr) / (2 * coef[0]);
                x2 = (-coef[1] + diskr) / (2 * coef[0]);
            } else if(coef[2] == 0 & coef[1]!= 0){
                x1 = 0;
                x2 = -coef[1]/coef[0];
            } else if(coef[1] == 0 & coef[2] != 0 && coef[2] <= 0){
                x1 = -coef[2]/coef[0];
                x1 = Math.sqrt(x1);
                x2 = -x1;
            }
            System.out.println("x1 = "+ x1 + "\n"+ "x2 = " + x2);
        }
        else{
            System.out.println("Неправильный формат ввода чисел.");
            System.exit(0);
        }
    }

    static double[] fillArrayDouble(String[] arrayTemp){
        int sizeArray = arrayTemp.length;
        double[] coef = new double[sizeArray];
        for(int i = 0; i < sizeArray; ++i){
            try {
                coef[i] = Double.parseDouble(arrayTemp[i]);
                return coef;
            } catch (NumberFormatException e) {
                System.out.println("Input String cannot be parsed to Double.");
                System.exit(0);
            }
        }
        return coef;
    }
}
