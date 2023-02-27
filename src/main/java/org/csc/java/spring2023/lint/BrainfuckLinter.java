package org.csc.java.spring2023.lint;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.csc.java.spring2023.BracketSequenceLintProblem;
import org.csc.java.spring2023.LintProblem;
import org.csc.java.spring2023.Token;
import org.csc.java.spring2023.UnknownCharacterLintProblem;

public final class BrainfuckLinter implements Linter {

  @Override
  public List<LintProblem> lint(Token[] tokens, String programText) {
    int length = tokens.length;
    ArrayList<LintProblem> problems = new ArrayList<>();

    for (int i = 0; i < length; ++i) {
      if (tokens[i] == Token.UNRECOGNIZED_TOKEN) {
        problems.add(new UnknownCharacterLintProblem(i, programText));
      }
    }

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < length; ++i) {
      if (tokens[i] == Token.LEFT_BRACKET) {
        stack.push(i);
      }

      if (tokens[i] == Token.RIGHT_BRACKET) {
        if (stack.size() > 0) {
          stack.pop();
        } else {
          problems.add(new BracketSequenceLintProblem(i, programText));
        }
      }
    }

    stack.forEach(index -> problems.add(new BracketSequenceLintProblem(index, programText)));

    return problems;
  }
}
