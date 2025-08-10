package harvesters.core;

import harvesters.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {

    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }

    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        result = switch (command) {
            case AddField -> addField(data);
            case AddHarvester -> addHarvester(data);
            case GoHarvesting -> goHarvesting(data);
            case GetStatistics -> getStatistics();
            case Exit -> Command.Exit.name();
        };

        return result;
    }

    private String addField(String[] data) {
        return controller.addField(data[0], data[1], Integer.parseInt(data[2]));
    }

    private String addHarvester(String[] data) {
        return controller.addHarvester(data[0], data[1], data[2]);
    }

    private String goHarvesting(String[] data) {
        return controller.goHarvesting(data[0]);
    }

    private String getStatistics() {
        return controller.getStatistics();
    }
}
