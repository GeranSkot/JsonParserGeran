package by.intexsoft.json.parser;

import java.util.ArrayList;

/**
 * Проверяет сами строки в json файле на наличие двойных разделителных ковычек и двоеточия, разделяющего ключ-значение.
 * @author Geran
 */
class Element extends MagicSymbols{
  int matchElement(ArrayList<Character> jsonString, int index) throws ParserException {
    if (jsonString.get(index) != DUAL_QUOTES) {
      throw new ParserException("Missing beginning \" at location " + index);
    }
    index++;

    Terminal terminal = new Terminal();
    index = terminal.matchAlphanum(jsonString, index);

    if (jsonString.get(index) != COLON) {
      throw new ParserException("Missing ':' for key:value pair at location " + index);
    }
    index++;

    Value value = new Value();
    index = value.matchValue(jsonString, index);

    if (jsonString.get(index) == COMMA) {
      index++;
      index = matchElement(jsonString, index);
    }

    return index;
  }
}
