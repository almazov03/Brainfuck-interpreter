package org.csc.java.spring2023.lint;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.csc.java.spring2023.Token;

public final class BrainfuckLinter implements Linter {

  @Override
  public List<LintProblem> lint(Token[] tokens, String programText) {
    int length = tokens.length;
    List<LintProblem> problems = new ArrayList<>();

    for (int i = 0; i < length; ++i) {
      if (tokens[i] == Token.UNRECOGNIZED_TOKEN) {
        problems.add(new UnknownCharacterLintProblem(i, programText));
      }
    }

    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < length; ++i) {
      if (tokens[i] == Token.LEFT_BRACKET) {
        stack.addLast(i);
      }

      if (tokens[i] == Token.RIGHT_BRACKET) {
        if (stack.size() > 0) {
          stack.pollLast();
        } else {
          problems.add(new BracketSequenceLintProblem(i, programText));
        }
      }
    }

    stack.forEach(index -> problems.add(new BracketSequenceLintProblem(index, programText)));

    return problems;
  }
}