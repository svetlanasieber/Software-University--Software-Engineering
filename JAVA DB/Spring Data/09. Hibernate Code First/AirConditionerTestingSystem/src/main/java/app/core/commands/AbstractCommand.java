package app.core.commands;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractCommand implements Command {

    private String[] data;

    protected AbstractCommand(String[] data) {
        this.setData(data);
    }

    protected String[] getData() {
        return this.data;
    }

    protected void setData(String[] data) {
        this.data = data;
    }
}
