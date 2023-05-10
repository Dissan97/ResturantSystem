package org.dissan.restaurant.patterns.behavioral.state.cli;

import org.dissan.restaurant.cli.utils.InStream;
import org.dissan.restaurant.cli.utils.OutStream;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CliState {

    protected Map<String, List<String>> commandAndArguments = new HashMap<>();

    public CliState() {
        InStream.setInput();
        OutStream.setOutput();
    }

    public abstract void updateUi();
    protected String getUserInput(){
        return InStream.getLine();
    }

    protected @NotNull List<String> parseCommand(@NotNull String cmd){
        String[] parsed = cmd.split(" ");
        return new ArrayList<>(List.of(parsed));
    }
    protected abstract void changeState(CliState state);
}
