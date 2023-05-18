package org.dissan.restaurant.patterns.behavioral.state.cli;

import org.dissan.restaurant.cli.utils.InStream;
import org.dissan.restaurant.cli.utils.OutStream;
import org.dissan.restaurant.patterns.behavioral.state.cli.exceptions.CommandParseException;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Logger;

public abstract class CliState {

    protected final Logger logger = Logger.getLogger(this.getClass().getSimpleName().toUpperCase(Locale.ROOT));
    protected static final String CONF = "Conf.json";
    protected JSONObject allowedCommands;
    protected String pageName;

    protected CliState() {
        InStream.setInput();
        OutStream.setOutput();
    }

    protected CliState(String name){
        this();
        JSONTokener jsonTokener;
        this.allowedCommands = new JSONObject();
        final String ex = "exit";
        final String hlp = "help";
        int i = 1;
        String path = name + CliState.CONF;
            try (
        InputStream reader = CliState.class.getResourceAsStream(path)) {
            jsonTokener = new JSONTokener(Objects.requireNonNull(reader));
            JSONObject object = new JSONObject(jsonTokener);
            if (object.isEmpty()){
                throw new NullPointerException();
            }
                for (String j:
                     object.keySet()) {
                    addCmd(object.getString(j));
                }
        } catch (IOException | NullPointerException e) {
            this.logger.warning("load conf function: error ->" + e.getMessage() + " path issue: " + path);
        }
        addCmd(hlp);
        addCmd(ex);
        this.setPageName(name);
    }

    protected void addCmd(String cmd){
        Set<String> keys = this.allowedCommands.keySet();
        int size =  keys.size() +  1;

        for (String k:
             keys) {
            if (this.allowedCommands.getString(k).equals(cmd)){
                return;
            }
        }
        this.allowedCommands.put(String.valueOf(size), cmd);

    }
    public void setPageName(String name) {
        this.pageName = '{' + name + '}';
    }
    public abstract void updateUi();
    protected String getUserInput(){
        return this.getUserInput("insert command");
    }
    protected String getUserInput(String msg) {
        this.out(msg + " >> ");
        return InStream.getLine();
    }

    /**
     *
     * @param cmd can be passed key or cmd
     * @return true if cmd is valid else false
     */
    protected boolean parseCmd(String cmd)  {
        try {
            boolean valid = false;

            Set<String> keys = this.allowedCommands.keySet();
            boolean validKey = keys.contains(cmd);
            //Check for command instead of key
            if (!validKey) {
                for (String k :
                        keys) {
                    if (this.allowedCommands.get(k).equals(cmd)) {
                        valid = true;
                    }
                }
            }

            if (!validKey && !valid){
                throw new CommandParseException();
            }
        } catch (CommandParseException e) {
            this.help();
            this.outline(cmd + ' ' + e.getMessage());
            return true;
        }
        return false;
    }
    protected void changeState(@NotNull CliState state){
        state.updateUi();
    }
    protected String getPageName() {
        return this.pageName;
    }
    protected void exit() {
        System.exit(0);
    }

    protected void help() {
        Set<String> commandSet = this.allowedCommands.keySet();
        this.outline("ALLOWED COMMAND");
        StringBuilder builder = new StringBuilder();
        for (String k:
                commandSet) {
            builder.append(k).append(": ").append(this.allowedCommands.get(k)).append("\n");
        }
        out("commands:\n" + builder);
    }


    protected void outline(String message) {
        OutStream.println(getPageName() + " " + message);
    }

    protected void out(String message){
        OutStream.print(getPageName() + " " + message);
    }
}
