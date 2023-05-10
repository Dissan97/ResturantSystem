package org.dissan.restaurant.patterns.behavioral.state.cli;


import org.dissan.restaurant.cli.utils.InStream;
import org.dissan.restaurant.cli.utils.OutStream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HomeCliState extends CliState{

    public HomeCliState() {
        super();
        List<String> hello = new ArrayList<>();
        hello.add("come");
        hello.add("stai");
        super.commandAndArguments.put("ciao", hello);
    }

    @Override
    public void updateUi() {
        OutStream.println("HOME");
        OutStream.print("Insert cmd >> ");
        String cmd = InStream.getLine();
        assert cmd != null;
        List <String> parsed = super.parseCommand(cmd);

        if (super.commandAndArguments.containsKey(parsed.get(0))){
            if (new HashSet<>(super.commandAndArguments.get(parsed.get(0))).containsAll(parsed.subList(0, parsed.size() - 1))){
                OutStream.print("BRAVO");
            }
        }

    }

    @Override
    protected void changeState(CliState state){

    }
}
