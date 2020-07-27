package com.epam.izh.rd.online.service;

import static java.lang.StrictMath.sqrt;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if(value1 == value2)
            return 0;
        else if(value1 < value2)
            return -1;
        else
            return 1;
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {

        if(value1 >= value2)
            return value1;
        else
            return value2;
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int number = values[0];
        for(int item : values){
            if(item > number)
                number = item;
        }
        return number;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;
        for(int item: values){
            sum+=item;
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int count = 0;

        for(int i=0; i<values.length; i++){
            if(values[i]%2==0)
                count++;
        }
        int[] newArray = new int[count];
        int j=0;

        for(int i=0; i<values.length; i++){
            if(values[i]%2==0){
                newArray[j] = values[i];
                j++;}
        }
        return newArray;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        if( initialVal <= 1 )
            return 1;
        else
            return initialVal * calcFactorial( initialVal - 1 );
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        int last = 1;
        int next = 1;
        int result = 0;
        if(number==0)
            return 0;
        else if (number <= 2)
            return 1;
        else{
            for (int i = 2; i < number; i++) {
                result = last + next;
                last = next;
                next = result;
            }
        }
        return result;
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */

    @Override
    public int[] sort(int[] values) {

        for (int i = values.length - 1; i >= 1; i--) {
            for (int y = 0; y < i; y++) {
                if (values[y] > values[y + 1]) {
                    int number = values[y];
                    values[y] = values[y + 1];
                    values[y + 1] = number;
                }
            }
        }
        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        if (number < 2)
            return false;
        double sn = sqrt(number);
        for (int i = 2; i <= sn; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int [] newValues = new int [values.length];
        for (int i=0; i<values.length; i++ ){
            newValues[i]=values[values.length-i-1];
        }
        return newValues;
    }
}
