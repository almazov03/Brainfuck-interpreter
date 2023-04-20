package org.csc.java.spring2023;

public final class BrainfuckMemory implements Memory {

  private final byte[] memory;
  private int pointer;

  public BrainfuckMemory(int memorySize) {
    memory = new byte[memorySize];
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

  private void checkPointer() {
    if (pointer < 0 || pointer >= memory.length) {
      throw new MemoryAccessException(pointer);
    }
  }

  @Override
  public void setByte(byte value) throws MemoryAccessException {
    checkPointer();
    memory[pointer] = value;
  }

  @Override
  public byte getByte() throws MemoryAccessException {
    checkPointer();
    return memory[pointer];
  }

  @Override
  public int getSize() {
    return memory.length;
  }
}