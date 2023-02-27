package org.csc.java.spring2023.commands;

import org.csc.java.spring2023.IOContext;
import org.csc.java.spring2023.Memory;

public final class ShiftRightCommand implements Command {

  @Override
  public void execute(IOContext context, Memory memory) {
    memory.shiftRight();
  }
}
