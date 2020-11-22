import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
    static Map<Integer, String> romanUnitsMap = new HashMap<>();    // Карта единиц
    static Map<Integer, String> romanTensMap = new HashMap<>();     // Карта десятков

    private static String[] romanUnits = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};     // Массив из единиц
    private static String[] romanTens = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};      // Массив из десяток

    // Метод формирования карт ключ-значение для единиц и десяток
    public static void maps() {
        for (int i = 1; i <= 10; i++) {
            romanUnitsMap.put(i, romanUnits[i - 1]);
            romanTensMap.put(i * 10, romanTens[i - 1]);
        }
    }

    // Метод конвертации римских цифр в арабские
    public static int romanToArab(String romanNumber) {
        return getKey(romanUnitsMap, romanNumber);
    }

    // Метод конвертации арабских цифр в римские
    public static String arabToRoman(int arabNumber) {
        int units = arabNumber % 10;                // Выявление единиц в числе
        if (units == 0)                             // Если единиц нет, то введённое число - это какой-либо десяток.
            return romanTensMap.get(arabNumber);    // Возвращает введённое число
        else {
            int tens = arabNumber - units;          // Выявляем десятки
            if (tens == 0)                              // если десятков нет, значит число - однозначное
                return romanUnitsMap.get(arabNumber);   // Возвращаем римскую цифру-значение
            return romanTensMap.get(tens) + romanUnitsMap.get(units);   // Возвращаем рискую цифру сложенную из десятков и единиц
        }
    }

    // Метод выуживания ключа по значению (ключ - инт)
    public static <Integer, String> Integer getKey(Map<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    // Метод для проверки введена ли подходящая римская цифра
    public static boolean inputCheck(String input) {
        return romanUnitsMap.containsValue(input);
    }
}

