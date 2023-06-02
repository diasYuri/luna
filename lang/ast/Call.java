package lang.ast;

import lang.ast.abstracts.Expr;

public class Call extends Expr {
    private String name;
    private Expr[] args;

    public Call(int l, int c, String name, Expr[] xs) {
        super(l, c);
        this.name = name;
        args = xs;
    }

    public String getName() {
        return name;
    }

    public Expr[] getArgs() {
        return args;
    }


    //@Override
    public String toString() {
        String s = name + "(";
        if (args.length > 0) {
            s += args[0].toString();
            for (int i = 1; i < args.length; i++) {
                s += "," + args[i].toString();
            }
        }
        s += ")";
        return s;
    }
}
