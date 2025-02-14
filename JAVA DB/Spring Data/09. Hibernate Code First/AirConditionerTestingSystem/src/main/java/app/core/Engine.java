package app.core;

import app.core.commands.Command;
import app.ios.Reader;
import app.ios.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Engine implements CommandLineRunner {

    private final Writer writer;

    private final Reader reader;

    private final Dispatcher dispatcher;

    @Autowired
    public Engine(Writer writer, Reader reader, Dispatcher dispatcher) {
        this.writer = writer;
        this.reader = reader;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run(String... strings) throws Exception {
        while (true) {
            String input = this.reader.readLine();

            String[] tokens = input.split(" ");
            String commandType = tokens[0];
            String[] commandTokens = tokens[1]
                    .replace("(", "")
                    .replace(")", "")
                    .split(",");

            Command command = this.dispatcher.dispatch(commandType, commandTokens);
            String result = command.execute();

            this.writer.writeLine(result);
        }
    }
}
