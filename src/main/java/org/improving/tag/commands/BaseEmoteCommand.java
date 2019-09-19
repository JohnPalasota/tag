package org.improving.tag.commands;

public abstract class BaseEmoteCommand implements Command {
    private String cmdText;
    private String cmdResponse;

    public BaseEmoteCommand(String cmdText, String cmdResponse){
        this.cmdText = cmdText;
        this.cmdResponse = cmdResponse;
    }
    @Override //Tells java that we intend for it to do this.
    public boolean isValid(String input) {
        return input.equals(cmdText);
    }

    @Override
    public void execute(String input) {
        System.out.println(cmdResponse);
    }
}
