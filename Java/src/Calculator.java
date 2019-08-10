public class Calculator {
    public int AddValues(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    public void FindEquation(String values){
        System.out.println(values.split(" ")[0]);
        System.out.println(values.split(" ")[1]);
        System.out.println(values.split(" ")[2]);
    }
}
