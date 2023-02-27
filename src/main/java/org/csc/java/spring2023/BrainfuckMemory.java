package org.csc.java.spring2023;

public final class BrainfuckMemory implements Memory {

  Byte[] memory;
  int pointer;

  public BrainfuckMemory(int memorySize) {
    memory = new Byte[memorySize];
    for (int i = 0; i < memorySize; ++i) {
      memory[i] = 0;
    }
    pointer = 0;
  }

  @Override
  public void shiftRight() {
    pointer++;
  }

  @Override
  public void shiftLeft() {
    pointer--;
  }

  @Override
  public void setByte(byte value) throws MemoryAccessException {
    if (pointer < 0 || pointer >= memory.length) {
      throw new MemoryAccessException(pointer);
    }
    memory[pointer] = value;
  }

  @Override
  public byte getByte() throws MemoryAccessException {
    if (pointer < 0 || pointer >= memory.length) {
      throw new MemoryAccessException(pointer);
    }
    return memory[pointer];
  }

  @Override
  public int getSize() {
    return memory.length;
  }
}
