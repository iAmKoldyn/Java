package input_output_number;
/*
Создать программу, позволяющую вводить с клавиатуры число, сохранять его в целочисленной переменной
и затем выводить переменную на консоль. 
Надо учесть, что пользователь может ввести любую строку.
Если среди значащих символов есть только цифры, + или -, то строка должна быть преобразована в число.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutputNumber {

    public static void main(String[] args) {
        int number = getInt();
        System.out.println(number);
    }

    public static int getInt() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        try {
            while (true) {
                System.out.print("Введите число: ");
                String text = reader.readLine();
                if (text.matches("[+-]?[0-9]+")) {
                    result = Integer.parseInt(text);
                    break;
                } else {
                    System.out.println("Вы ввели не число! Попробуйте ещё раз!");
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }
}
