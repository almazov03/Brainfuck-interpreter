package org.csc.java.spring2023;

public final class UnknownCharacterLintProblem implements LintProblem {

  int position;
  String programText;

  public UnknownCharacterLintProblem(int position, String programText) {
    this.position = position;
    this.programText = programText;
  }

  @Override
  public int getPosition() {
    return position;
  }

  @Override
  public String getMessage() {
    return "\n " + programText + "\n " + " ".repeat(position) + "^\n"
        + "SyntaxError: unexpected character '" + programText.charAt(position) + "'\n";
  }
}
