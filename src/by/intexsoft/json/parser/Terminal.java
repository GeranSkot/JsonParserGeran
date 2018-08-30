package by.intexsoft.json.parser;

import java.util.ArrayList;

/**
 * Тут уже интереснее, проверяет само значение на валидность.
 * @author Geran
 */
class Terminal extends MagicSymbols{
  int matchAlphanum(ArrayList<Character> jsonString, int index) throws ParserException {
    char token = jsonString.get(index);
    while (token != DUAL_QUOTES) {
      if (token == LATERAL_LINE) {
        index++;
      }
      index++;
      if (index >= jsonString.size()) {
        throw new ParserException("Missing closing \" at location " + index);
      }
      token = jsonString.get(index);
    }
    index++;
    return index;
  }

  int matchConstant(ArrayList<Character> jsonString, int index) throws ParserException {
    String stringValue = "";
    int integerIndex;
    switch (jsonString.get(index)) {
      case TRUE:
        integerIndex = index;
        for (int i = 0; i < 4; i++) {
          stringValue += jsonString.get(integerIndex);
          integerIndex++;
        }
        if (!stringValue.equals(TRUE_STRING)) {
          throw new ParserException(
              "Expecting 'String', 'Number', 'null', 'true', 'false', '{', '[', got 'undefined'");
        }
        index += 4;
        break;
      case FALSE:
        integerIndex = index;
        for (int i = 0; i < 5; i++) {
          stringValue += jsonString.get(integerIndex);
          integerIndex++;
        }
        if (!stringValue.equals(FALSE_STRING)) {
          throw new ParserException(
              "Expecting 'String', 'Number', 'null', 'true', 'false', '{', '[', got 'undefined'");
        }
        index += 5;
        break;
      case NULL:
        integerIndex = index;
        for (int i = 0; i < 4; i++) {
          stringValue += jsonString.get(integerIndex);
          integerIndex++;
        }
        if (!stringValue.equals(NULL_STRING)) {
          throw new ParserException(
              "Expecting 'String', 'Number', 'null', 'true', 'false', '{', '[', got 'undefined'");
        }
        index += 4;
        break;
      case DASH:
        index++;
      case '0':
        index++;
        if (Character.isDigit(jsonString.get(index))) {
          throw new ParserException("Cannot proceed digit by 0");
        }
        if (jsonString.get(index) == DOT) {
          do {
            index++;
          } while (Character.isDigit(jsonString.get(index)));
        }
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
        int count = 0;
        while (Character.isDigit(jsonString.get(index))) {
          index++;
          if (jsonString.get(index) == DOT) {
            if (count == 0 && Character.isDigit(jsonString.get(index + 1))) {
              index++;
              count++;
            } else {
              throw new ParserException("Invalid use of decimal point");
            }
          }
        }
        break;
      default:
        throw new ParserException(
            "Expecting 'String', 'Number', 'null', 'true', 'false', '{', '[', got 'undefined'");
    }
    return index;
  }
}
