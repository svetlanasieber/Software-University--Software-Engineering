package harvesters;

import harvesters.core.Controller;
import harvesters.core.ControllerImpl;
import harvesters.core.Engine;
import harvesters.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}