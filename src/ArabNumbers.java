public class ArabNumbers {

    // Метод проверки того, что ввели цифру из допустимого диапазона
    public static boolean numberValidation(int number) {
        return number > 0 && number < 11;
    }

    // Метод перевода введённой строки в цифру
    public static int stringToInt(String string) throws NumberFormatException {
        int newInt = Integer.parseInt(string);
        return newInt;
    }

    // Метод проверки символа и выдачи соответствующего результата
    public static int result(String symbol, int firstNumber, int secondNumber) {
        switch (symbol) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                return firstNumber / secondNumber;
            default:
                return 0;
        }
    }
}


