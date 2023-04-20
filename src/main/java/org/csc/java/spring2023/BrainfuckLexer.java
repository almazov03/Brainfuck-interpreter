package org.csc.java.spring2023;

public final class BrainfuckLexer implements Lexer {

  @Override
  public Token[] tokenize(String programText) {
    int length = programText.length();

    Token[] tokens = new Token[length];
    for (int i = 0; i < length; ++i) {
      tokens[i] = switch (programText.charAt(i)) {
        case '>' -> Token.NEXT;
        case '<' -> Token.PREVIOUS;
        case '+' -> Token.INCREASE;
        case '-' -> Token.DECREASE;
        case '.' -> Token.OUTPUT;
        case ',' -> Token.INPUT;
        case '[' -> Token.LEFT_BRACKET;
        case ']' -> Token.RIGHT_BRACKET;
        default -> Token.UNRECOGNIZED_TOKEN;
      };
    }

    return tokens;
  }
}