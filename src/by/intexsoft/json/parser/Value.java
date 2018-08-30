package by.intexsoft.json.parser;

import java.util.ArrayList;

/**
 * Все творит. Видит открытую фигурную скобку, погнал Start(). Видит квадратную, погнал ArrayClass(). Видит двойные
 * ковычки, погнал Terminal(). Возвращяет индекс.
 * @author Geran
 */
class Value extends MagicSymbols{
  int matchValue(ArrayList<Character> jsonString, int index) throws ParserException {
    switch (jsonString.get(index)) {
      case OPEN_FIGURE_BRACKET:
        Start start = new Start();
        index = start.matchStart(jsonString, index);
        if (jsonString.get(index) != CLOSE_FIGURE_BRACKET) {
          throw new ParserException("Missing } at location " + index);
        }
        index++;
        break;
      case OPEN_ARRAY_BRACKET:
        index++;
        ArrayClass arrayClass = new ArrayClass();
        index = arrayClass.matchArray(jsonString, index);
        break;
      case DUAL_QUOTES:
        index++;
        Terminal terminal = new Terminal();
        index = terminal.matchAlphanum(jsonString, index);
        break;
      default:
        Terminal terminal1 = new Terminal();
        index = terminal1.matchConstant(jsonString, index);
        break;
    }
    return index;
  }
}
