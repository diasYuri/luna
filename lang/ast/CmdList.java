package lang.ast;

import java.util.ArrayList;
import java.util.List;


public class CmdList extends Cmd{
    /**
     * ---- Regra
     * cmd: OPEN_BRACES cmd* CLOSE_BRACES      # CommandsList
    */

    private List<Cmd> commands;

    public CmdList(int line, int column, List<Cmd> commands){
        super(line, column);
        this.commands = commands;
    }

    public CmdList(int line, int column){
        super(line, column);
        this.commands = new ArrayList<Cmd>();
    }

    public List<Cmd> getCmds(){
        return (this.commands);
    }

    public void setCmds(List<Cmd> cmd){
        this.commands = cmd;
    }

    public void addCmd(Cmd cmd){
        commands.add(cmd);
    }


}