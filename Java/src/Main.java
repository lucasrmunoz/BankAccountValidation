public class Main {

    public static void main(String[] args) {
        String program = "calculator";

        switch (program.toUpperCase()){
            case "POKEMON":
                Pokemon();
                break;
            case "EXAMPLE":
                Example();
                break;
            case "CALCULATOR":
                Calculator();
                break;
            default:
                System.out.println("Please make a proper selection.");
                break;
        }
    }

    private static void Example(){
        // Example from the book to run

    }

    private static void Calculator(){
        Calculator calculator = new Calculator();
        calculator.AddValues(1, 1);
        calculator.FindEquation("1 + 1");
    }

    private static void Pokemon(){
        Pokemon pokemon = new Pokemon();
        pokemon.Pokemon();
    }
}
