package org.csc.java.spring2023;

public final class BracketSequenceLintProblem implements LintProblem {

  int position;
  String programText;

  public BracketSequenceLintProblem(int position, String programText) {
    this.position = position;
    this.programText = programText;
  }

  @Override
  public int getPosition() {
    return position;
  }

  @Override
  public String getMessage() {
    return "\n " + programText + "\n " + " ".repeat(position) + "^\n" + "SyntaxError: unmatched '"
        + programText.charAt(position) + "'\n";
  }
}
