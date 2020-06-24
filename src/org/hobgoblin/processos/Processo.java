package org.hobgoblin.processos;

public class Processo {
	private Status status;
    private Command command;


    public void setStatus(Status status) {
        this.status = status;
    }
    public Status getStatus() {
        return this.status;
    }
    public void setCommand(Command command) {
        this.command = command;
    }
    public Command getCommand() {
        return this.command;
    }  
}
