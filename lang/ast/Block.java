package lang.ast;

import lang.ast.abstracts.Cmd;

import java.util.List;

public class Block extends Cmd {
    private List<Cmd> commands;

    public Block(int l, int c, List<Cmd> commands) {
        super(l, c);
        this.commands = commands;
    }

    public List<Cmd> getCommands() {
        return commands;
    }
}