package practicum;

import java.util.List;


public class Algorithms {

    /**
     *
     * В задачах, в которых заранее не оговорен состав символов в строках,
     * строки могут содержать русские и английские буквы,
     * а также пробелы, знаки препинания, кавычки и скобки.
     *
     * Не использовать при решении регулярные выражения, методы стандартных библиотек
     * java.util.Collections, java.util.Arrays, java.lang.Math, а также методы
     * replace и replaceAll, reverce, equals, indexOf, toLowerCase, toUpperCase
     * split, substring из java.lang.String.
     * Можете использовать циклы, условные операторы,
     * простые типы данных и их обертки.
     *
     * Как изменится сложность ваших решений, если убрать
     * ограничения по использованию функций Java API?
     */

    /**
     * Вычислите максимальное, минимальное и среднее число для списка чисел
     * Верните их сумму
     * Список гарантированно содежит элементы
     */
    public static double maxMinAvr(List<Integer> numbers) {
        double i = 0;
        double min = 0;
        double max = 0;
        double count = 0;
        for (double element : numbers) {
            count += element;
            if (i == 0) {
                min = element;
                max = element;
            }
            if (element < min) {
                min = element;
            } else if (element > max) {
                max = element;
            }
            i++;
        }
        return max + min + (count / i);
    }


    /**
     * Найдите второе максимальное значение в массиве,
     * если такого нет, то вернуть первое
     * Массив гарантировано содержит элементы
     */
    public static Integer max2(List<Integer> list) {
        int iter = 0;
        int firstNumber = 0;
        int thrMax = 0;
        int secMax = 0;
        int firstMax = 0;
        for (int element : list) {
            if (iter == 0) {
                firstNumber = element;
                thrMax = element;
                secMax = element;
                firstMax = element;
            }
            if (element > thrMax) {
                if (element > secMax) {
                    if (element > firstMax) {
                        thrMax = secMax;
                        secMax = firstMax;
                        firstMax = element;
                    } else {
                        if (element != firstMax) {
                            thrMax = secMax;
                            secMax = element;
                        }
                    }
                } else {
                    thrMax = element;
                }
            }
            iter++;
        }
        if (thrMax == secMax || secMax == firstMax || thrMax == firstNumber) {
            return firstNumber;
        } else {
            return secMax;
        }
    }

    /**
     * Удалите число из массива.
     * Верните массив не содержащий этого элемента,
     * но и не содержащий "пропусков" на месте удаленных элементов
     * Например, если из массива [0, 6, 0 ,5, 0] нужно удалить элемент 0,
     * то возвращаться должен массив содержащий два элемента [6, 5]
     */
    public static int[] removeElementFromArray(int[] numbers, int value) {
        int count = 0;
        for(int element: numbers){
            if(element == value){
                count++;
            }
        }
        int[] result = new int[numbers.length - count];
        int j = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] != value){
                result[j] = numbers[i];
                j++;
            }
        }
        return result;
    }


    /**
     * Удалите все гласные из строки.
     * Например, "мАма Мыла раму" -> "мм Мл рм"
     */
    public static String removeVowels(String str) {
        String[] first = new String[str.length()];
        String result = "";
        for(int i = 0; i < str.length(); i++){
            if(!isVowels(str.charAt(i))){
                result = result + str.charAt(i);
            }
        }
        return result;
    }

    private static boolean isVowels(char el) {
        if(el == 'а' || el == 'А' || el == 'о' || el == 'О' || el == 'у' || el == 'У' || el == 'э' || el == 'Э'
                || el == 'ы' || el == 'Ы' || el == 'я' || el == 'Я' || el == 'ё' || el == 'Ё' || el == 'ю'
                || el == 'Ю' || el == 'е' || el == 'Е' || el == 'и' || el == 'И' || el == 'a' || el == 'A'
                || el == 'e' || el == 'E' || el == 'i' || el == 'I' || el == 'u' || el == 'U' || el == 'y'
                || el == 'Y' || el == 'o' || el == 'O'){
            return true;
        }
        return false;
    }
    /**
     * Убрать повторяющиеся подряд символы в строке
     * например "ммммоолллокко" -> "молоко"
     * (*) - в этой задаче нужно учитывать сочетания
     * повторяющихся букв разного регистра,
     * при этом в выходной строке остается первая буква,
     * например, "мМммооЛллокКОоо" -> "моЛокО",
     */
    public static String removeDublicates(String str) {
        char last = '0';
        String result = "";
        for(int i = 0; i < str.length();i++){
            if(!(last == str.charAt(i) || (last | 32) == (str.charAt(i) | 32))){
                result = result + str.charAt(i);
            }
            last = str.charAt(i);
        }
        return result;
    }

    /**
     * Сжать строку, удаляя повторяющиеся символы
     * и указывая количество повторов для каждого символа
     * например "мооолооооккооо" -> "м1о3л1о4к2о2"
     */
    public static String zipStr(String str) {
        str = str + "&";
        int count = 1;
        int a = 1;
        String result = "";
        char last = str.charAt(0);
        while(a != str.length()){
            if(str.charAt(a) == last){
                count++;
            } else {
                result = result + last + count;
                count = 1;
            }
            last = str.charAt(a);
            a++;
        }
        return result;
    }


    /**
     * Выяснить является ли строка палиндромом,
     * то есть  одинаково читается в обоих направлениях.
     * Например, слово "топот" - палиндром, а слово "топор" нет.
     * Строка "А роза упала на лапу Азора" тоже палиндром,
     * а строка "А роза уколола лапу Азора" нет.
     * "A man, a plan, a canal-Panama", тоже палиндром
     *
     * (!) Так как запрещены регулярные выражения
     * и методы преобразования регистра символов из java.lang.String
     * обратите внимание таблицу кодов символов UTF-8
     * (лучше убрать эту подсказку и выдать ее в процессе)
     */
    public static boolean isPalindrom(String str) {
        String fullPalidrom = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' ' && str.charAt(i) != '\"' && str.charAt(i) != '–' && str.charAt(i) != '\''
                    && str.charAt(i) != ',' && str.charAt(i) != '.' && str.charAt(i) != '?' && str.charAt(i) != '!'
                    && str.charAt(i) != '-'){
                fullPalidrom += str.charAt(i) ;
            }
        }
        for(int i = 0; i < fullPalidrom.length() / 2; i++){
            if((fullPalidrom.charAt(i) | 32) != (fullPalidrom.charAt((fullPalidrom.length() - 1) - i) | 32)){
                return false;
            }
        }
        return true;
    }


    /**
     * Перевернуть все слова в предложении
     * "Кот лакал молоко" -> "тоК лакал околом"
     */
    public static String reverseWordsInSentence(String sentence) {
        int all = 0;
        String result = "";
        while(all != sentence.length()){
            String forReverse = "";
            while(sentence.charAt(all) != ' ' && all != sentence.length()){
                forReverse += sentence.charAt(all);
                if((all+ 1) < sentence.length()){
                    all++;
                } else {
                    break;
                }
            }
            String punctuation = "";
            for(int i = forReverse.length() - 1; i >= 0; i--){
                if(forReverse.charAt(i) == '.' ||  forReverse.charAt(i) == '!' || forReverse.charAt(i) == ','){
                    punctuation += forReverse.charAt(i);
                } else {
                    result += forReverse.charAt(i);
                }
            }
            result += punctuation;
            if(all < sentence.length() && sentence.charAt(all) == ' '){
                result += " ";
            }
            all++;
        }
        return result;
    }

    /**
     * Отсортируйте символы в массиве,
     * не используйте дополнительные структуры данных.
     * При вводе массива символов {'c', 'a', 'b'},
     * возвращаться должен тот же отсортированный массив {'a', 'b', 'c'}
     */
    public static char[] sortSymbols(char[] symbols) {
        for (int left = 0; left < symbols.length; left++) {
            char value = symbols[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < symbols[i]) {
                    symbols[i + 1] = symbols[i];
                } else {
                    break;
                }
            }
            symbols[i + 1] = value;
        }
        return symbols;
    }


    /**
     *
     * Выясните являются ли две строки анограммами.
     * Строки являются анограммами, если они состоят из одних и тех же букв
     * Например, слова "кот" и "ток" анограммы, а слова "кот" и  "кит" нет.
     */
    public static boolean isAnogramOf(String word, String anogram) {
        if(word.length() != anogram.length()){
            return false;
        }
        char[] wordForCheck = new char[word.length()];
        char[] anogramForCheck = new char[anogram.length()];
        for(int i = 0; i < word.length();i++){
            wordForCheck[i] = word.charAt(i);
            anogramForCheck[i] = anogram.charAt(i);
        }
        wordForCheck = sortSymbols(wordForCheck);
        anogramForCheck = sortSymbols(anogramForCheck);
        for(int i = 0; i < wordForCheck.length; i++){
            if((wordForCheck[i] | 32) != (anogramForCheck[i] | 32)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Выясните, все ли символы в строке встречаются один раз.
     * Если строка содержит повторябщиеся символы,
     * то возвращать false, если не содержит - true
     * Нельзя использовать дополнительные структуры данных.
     *
     * (!) В этой задаче строка может содержать
     * любой символ из таблицы ASCII (127 символов)
     *
     * (!!) Сложность - O(n)
     * */

    public static boolean hasUniqueChars(String str) {
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(val > 256){
                return false;
            }
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

}
