package task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * @author Патарая Астан
 * @version 1.0
 * Класс для проверки номера телефона
 */
public class Check {
  /*
   * Регулярное выражение для проверки
   */
  final static String REGULAR_EXPRESSION = "^(\\+7|7|8)((\\(\\d{3}\\))|(\\d{3}))(\\d{3})((\\s)(\\d{2})(\\s)(\\d{2})|(-)(\\d{2})(-)(\\d{2}))$";
  /*
   * Метод проверки номера телефона
   * @param text - Строка содержащая номер телефона
   * @return Возращает True если номер коректен
   */
  public static boolean phoneNumber(String text) {
    Pattern pattern = Pattern.compile(REGULAR_EXPRESSION);
    Matcher matcher = pattern.matcher(text);
    return matcher.find();
  }
}
