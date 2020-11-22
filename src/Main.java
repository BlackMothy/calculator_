import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Калькулятор.");
        System.out.println("Введите операцию (пример: 4 + 8 или IV * X) и нажмите Enter.\n" + "" +
                "(Калькулятор работает с арабскими и римскими цифрами от 1 до 10)");
        try {
            Scanner scanner = new Scanner(scan.nextLine());     // Пользователь вводит операцию
            String firstNumber = scanner.next();                // Получаем первое число введённого выражения
            String symbol = scanner.next();                     // Получаем символ операции
            String secondNumber = scanner.next();               // Получаем второе число введённого выражени
            int firstNumberInt;
            int secondNumberInt;
            int finalResult;
            RomanNumbers.maps();                                // Создаются карты римских цифр.

            // Проверяем, что именно ввёл пользователь
            if (RomanNumbers.inputCheck(firstNumber) && RomanNumbers.inputCheck(secondNumber)) {
                // Если пользователь ввёл римские цифры,
                firstNumberInt = RomanNumbers.romanToArab(firstNumber);     // переводим первую римскую цифру в арабскую
                secondNumberInt = RomanNumbers.romanToArab(secondNumber);   // переводим вторую римскую цифру в арабскую

                finalResult = ArabNumbers.result(symbol, firstNumberInt, secondNumberInt);
                if (finalResult == 0)
                    throw new Exception();
                else
                    System.out.println(RomanNumbers.arabToRoman(finalResult));      // Вывод римской цифры на экран
            } else {  // Если пользователь ввёл арабские цифры,
                firstNumberInt = ArabNumbers.stringToInt(firstNumber);      // переводим первую введённую строку в число
                secondNumberInt = ArabNumbers.stringToInt(secondNumber);   // переводим вторую введённую строку в число

                if (ArabNumbers.numberValidation(firstNumberInt) && ArabNumbers.numberValidation(secondNumberInt)) {
                    // Если введённые цифры соответствуют диапазону,
                    finalResult = ArabNumbers.result(symbol, firstNumberInt, secondNumberInt);
                    if (finalResult == 0)
                        throw new Exception("Введена неверная операция");
                    else
                        System.out.println(finalResult);        // выводим результат на экран

                } else
                    throw new Exception();
            }
        } catch (Exception e) {
           System.out.println("Введена неверная операция.");
        }
    }
}
