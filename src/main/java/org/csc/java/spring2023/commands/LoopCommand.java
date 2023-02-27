package org.csc.java.spring2023.commands;

import java.util.ArrayList;
import org.csc.java.spring2023.IOContext;
import org.csc.java.spring2023.Memory;

public final class LoopCommand implements Command {

  ArrayList<Command> commands;

  public LoopCommand(ArrayList<Command> commands) {
    this.commands = commands;
  }

  @Override
  public void execute(IOContext context, Memory memory) {
    while (memory.getByte() != 0) {
      commands.forEach(command -> command.execute(context, memory));
    }
  }
}
