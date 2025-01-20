package climbers;

import climbers.core.Controller;
import climbers.core.ControllerImpl;
import climbers.core.Engine;
import climbers.core.EngineImpl;
import climbers.models.climber.Climber;
import climbers.models.climber.WallClimber;

public class Main {

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();



    }
}
