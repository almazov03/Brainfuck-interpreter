package org.csc.java.spring2023;

import java.util.List;
import org.csc.java.spring2023.lint.BrainfuckLinter;
import org.csc.java.spring2023.lint.Linter;

public class Interpreter {

  /**
   * Исполняет программу programText, написанную на языке Brainfuck, используя ioContext в качестве
   * устройства ввода-вывода. Для отладки предлагается передавать ConsoleIOContext, он использует
   * System.in и System.out
   *
   * @throws IllegalArgumentException если на вход дан некорректный текст программы. Текст сообщения
   *                                  – конкатенация сообщений об ошибках LintProblem#getMessage
   */
  public static void run(IOContext ioContext, String programText) throws IllegalArgumentException {
    BrainfuckLexer lexer = new BrainfuckLexer();
    BrainfuckLinter linter = new BrainfuckLinter();
    BrainfuckParser parser = new BrainfuckParser();
    BrainfuckMemory memory = new BrainfuckMemory(1024);

    Token[] tokens = lexer.tokenize(programText);
    List<LintProblem> lintProblems = linter.lint(tokens, programText);

    if (!lintProblems.isEmpty()) {
      StringBuilder message = new StringBuilder();
      lintProblems.forEach(lintProblem -> message.append(lintProblem.getMessage()));
      throw new IllegalArgumentException(message.toString());
    }

    parser.parse(tokens).execute(ioContext, memory);
  }

  public static Lexer createLexer() {
    return new BrainfuckLexer();
  }

  public static Parser createParser() {
    return new BrainfuckParser();
  }

  public static Memory createMemory(int memorySize) {
    return new BrainfuckMemory(memorySize);
  }

  public static Linter createLinter() {
    return new BrainfuckLinter();
  }
}
