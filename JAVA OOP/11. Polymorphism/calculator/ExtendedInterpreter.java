package calculator;

public class ExtendedInterpreter extends InputInterpreter {
    private MemoryStorageOperation memoryStorageOperation;

    public ExtendedInterpreter(CalculationEngine engine) {
        super(engine);
        this.memoryStorageOperation = new MemoryStorageOperation();
    }

    @Override
    public Operation getOperation(String operation) {
        if (operation.equals("/")) {
            return new DivideOperation();
        } else if (operation.equals("ms")) {
            return this.memoryStorageOperation;
        } else if (operation.equals("mr")) {
            return new MemoryRecallOperation(memoryStorageOperation);
        } else {
            return super.getOperation(operation);
        }

    };
}
