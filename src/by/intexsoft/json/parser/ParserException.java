package by.intexsoft.json.parser;

/**
 * Выбрасывает исключение в случае чего
 * @author Geran
 */
class ParserException extends Exception {
  public ParserException(String message) {
    super(message);
  }
}