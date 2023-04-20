package org.csc.java.spring2023;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import org.csc.java.spring2023.commands.Command;
import org.csc.java.spring2023.commands.DecreaseCommand;
import org.csc.java.spring2023.commands.IncreaseCommand;
import org.csc.java.spring2023.commands.InputCommand;
import org.csc.java.spring2023.commands.LoopCommand;
import org.csc.java.spring2023.commands.OutputCommand;
import org.csc.java.spring2023.commands.Program;
import org.csc.java.spring2023.commands.ShiftLeftCommand;
import org.csc.java.spring2023.commands.ShiftRightCommand;

public final class BrainfuckParser implements Parser {

  @Override
  public Command parse(Token[] tokens) {
    Deque<ArrayList<Command>> stackCommands = new ArrayDeque<>();
    stackCommands.addLast(new ArrayList<>());
    for (var token : tokens) {
      switch (token) {
        case NEXT -> stackCommands.getLast().add(new ShiftRightCommand());
        case PREVIOUS -> stackCommands.getLast().add(new ShiftLeftCommand());
        case INCREASE -> stackCommands.getLast().add(new IncreaseCommand());
        case DECREASE -> stackCommands.getLast().add(new DecreaseCommand());
        case OUTPUT -> stackCommands.getLast().add(new OutputCommand());
        case INPUT -> stackCommands.getLast().add(new InputCommand());
        case LEFT_BRACKET -> stackCommands.addLast(new ArrayList<>());
        case RIGHT_BRACKET -> {
          var loop = new LoopCommand(stackCommands.pollLast());
          stackCommands.getLast().add(loop);
        }
        default -> {
          assert (false);
        }
      }
    }

    return new Program(stackCommands.getLast());
  }
}