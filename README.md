# Задание №2. Brainfuck

[Brainfuck](https://en.wikipedia.org/wiki/Brainfuck) -- turing-complete programming language,
invented by Urban Mueller. The language contains only eight commands `><+-.,[]`. The program in the language
Brainfuck works with a simple machine
(similar to a Turing machine), consisting of a set of memory cells and a pointer to the current cell.

Command Description:

* `>` Move the pointer to the next cell of the array.
* `<` Move the pointer to the previous cell of the array.
* `+` Increase the value in the current cell of the array by one.
* `-` Decrease the value in the current cell of the array by one.
* `.` Output the current value of the array cell to the output stream.
* `,` Read the value from the input stream.
* `[` Go to the instruction following `]` if the value in the current cell is zero, otherwise
  go to the next instruction in order.
* `]` Switch to steam `[`.

The interpreter consists of six parts:

1) Lexer -- turns the program text into a set of tokens
2) Linter -- checks the token set for correctness and displays error messages
3) Parser -- takes a valid set of tokens as input and turns them into a set of commands
4) A memory device is an entity that completely encapsulates the logic of working with machine memory
   Brainfuck
5) An I/O device is an entity that allows you to read from an input stream and write to an output stream
6) Interpreter -- uses all the parts written before and executes the program
