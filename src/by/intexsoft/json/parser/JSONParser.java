package by.intexsoft.json.parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Указываем путь и начинает творить все в array list. Далее идет вся работа под капотом, и добавление в ArrayList
 * char символов. Выводит строкой, что занес в лист. Далее идет проверка на валидность JSON, т.е. все ли скобки на месте.
 * @author Geran
 */

public class JSONParser {
  public static void main(String[] args) throws IOException {
    FileReader fileReader = new FileReader("C:/repo/JsonYea.json");
    int integerValue;
    char charValue;
    String stringValue = "";
    ArrayList<Character> jsonList = new ArrayList<Character>();
    while ((integerValue = fileReader.read()) != -1) {
      charValue = (char) integerValue;
      if (!Character.isWhitespace(charValue)) {
        stringValue += charValue;
        jsonList.add(charValue);
      }
    }
    System.out.println(stringValue);
    fileReader.close();
    try {
      Start start = new Start();
      int index = start.matchStart(jsonList, 0);
      if (index + 1 == jsonList.size()) {
        System.out.println("Valid JSON");
//        char Olshevsky = 'o';
      } else
        System.out.println("Invalid JSON");
    } catch (ParserException exception) {
      System.out.println(exception.getMessage());
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }
}