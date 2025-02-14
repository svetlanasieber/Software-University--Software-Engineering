package app.ios;

import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
