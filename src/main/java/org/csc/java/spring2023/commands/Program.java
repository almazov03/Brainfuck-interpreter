package org.csc.java.spring2023.commands;

import java.util.ArrayList;
import org.csc.java.spring2023.IOContext;
import org.csc.java.spring2023.Memory;

public final class Program implements Command {

  ArrayList<Command> commands;

  public Program(ArrayList<Command> commands) {
    this.commands = commands;
  }

  @Override
  public void execute(IOContext context, Memory memory) {
    commands.forEach(command -> command.execute(context, memory));
  }
}
