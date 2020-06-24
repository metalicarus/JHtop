package org.hobgoblin.processos;


public class Command {
	private String command;
    
    public String getCommand() {
    	return this.command;
    }
    
    private void setCommand(String command) {
    	this.command = command;
    }
    
    public Command factory(String command) {
    	 Command factory = new Command();
    	 factory.setCommand(command);
    	 return factory;
    }
   
}
