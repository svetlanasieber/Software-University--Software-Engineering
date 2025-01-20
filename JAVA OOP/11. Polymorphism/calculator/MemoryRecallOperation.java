package calculator;

public class MemoryRecallOperation implements  Operation{

    private MemoryStorageOperation memoryStorageOperation;

    public MemoryRecallOperation(MemoryStorageOperation memoryStorageOperation) {
        this.memoryStorageOperation = memoryStorageOperation;
    }

    private int result;
    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return this.memoryStorageOperation.getResult();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
