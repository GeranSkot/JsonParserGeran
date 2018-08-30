package by.intexsoft.json.parser;

import java.util.ArrayList;

/**
 * После предворительных проверок, если в поле-значении массив не закрываеться, выводит ошибку об
 * "не закрытости" массива. Кароче, о невалидности массива в значении.
 * @author Geran
 */
public class ArrayClass extends MagicSymbols{
  int matchArray(ArrayList<Character> jsonString, int index) throws ParserException {
    if (jsonString.get(index) != CLOSE_ARRAY_BRACKET) {
      Value value = new Value();
      index = value.matchValue(jsonString, index);
      while (jsonString.get(index) != CLOSE_ARRAY_BRACKET) {
        if (jsonString.get(index) != COMMA) {
          throw new ParserException("Missing , or ] in array at location " + index);
        }
        index++;
        if (index >= jsonString.size()) {
          throw new ParserException("Missing ] for array at location " + index);
        }
        {
          Value valueNumberOne = new Value();
          index = valueNumberOne.matchValue(jsonString, index);
        }
      }

    }
    if (jsonString.get(index) != CLOSE_ARRAY_BRACKET) {
      throw new ParserException("Missing ] for array at location " + index);
    }
    index++;
    return index;
  }
}
