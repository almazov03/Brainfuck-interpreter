package org.csc.java.spring2023;

import java.util.ArrayList;
import java.util.Stack;
import org.csc.java.spring2023.commands.Command;
import org.csc.java.spring2023.commands.DecreaseCommand;
import org.csc.java.spring2023.commands.IncreaseCommand;
import org.csc.java.spring2023.commands.InputCommand;
import org.csc.java.spring2023.commands.LoopCommand;
import org.csc.java.spring2023.commands.OutputCommand;
import org.csc.java.spring2023.commands.Program;
import org.csc.java.spring2023.commands.ShiftLeftCommand;
import org.csc.java.spring2023.commands.ShiftRightCommand;

public class BrainfuckParser implements Parser {

  @Override
  public Command parse(Token[] tokens) {
    Stack<ArrayList<Command>> stackCommands = new Stack<>();
    stackCommands.push(new ArrayList<>());

    for (var token : tokens) {
      switch (token) {
        case NEXT -> stackCommands.lastElement().add(new ShiftRightCommand());
        case PREVIOUS -> stackCommands.lastElement().add(new ShiftLeftCommand());
        case INCREASE -> stackCommands.lastElement().add(new IncreaseCommand());
        case DECREASE -> stackCommands.lastElement().add(new DecreaseCommand());
        case OUTPUT -> stackCommands.lastElement().add(new OutputCommand());
        case INPUT -> stackCommands.lastElement().add(new InputCommand());
        case LEFT_BRACKET -> stackCommands.add(new ArrayList<>());
        case RIGHT_BRACKET -> {
          var loop = new LoopCommand(stackCommands.pop());
          stackCommands.lastElement().add(loop);
        }
        default -> {
          assert (false);
        }
      }
    }

    return new Program(stackCommands.lastElement());
  }
}
