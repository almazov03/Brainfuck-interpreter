package org.csc.java.spring2023.lint;


public final class BracketSequenceLintProblem implements LintProblem {

  private final int position;
  private final String programText;

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