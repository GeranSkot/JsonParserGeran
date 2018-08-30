package by.intexsoft.json.parser;

import java.util.ArrayList;

/**
 * Тут стартует и проверяет на фигурные скобки. Т.е. не массивы, а сами фигурные скобки формата JSON.
 * @author Geran
 */
class Start extends MagicSymbols{
  int matchStart(ArrayList<Character> jsonString, int index) throws ParserException {
    if (jsonString.get(index) != OPEN_FIGURE_BRACKET) {
      throw new ParserException("Missing { at location " + index);
    }
    index++;
    if (jsonString.get(index) != CLOSE_FIGURE_BRACKET) {
      Element element = new Element();
      index = element.matchElement(jsonString, index);
    }
    if (jsonString.get(index) != CLOSE_FIGURE_BRACKET) {
      throw new ParserException("Missing } at location " + index);
    }
    return index;
  }
}
