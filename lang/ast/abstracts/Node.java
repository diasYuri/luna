package lang.ast.abstracts;

import lang.ast.SuperNode;

public class Node extends SuperNode {
    private final int line;
    private final int column;

    public Node(int l, int c){
        line = l;
        column = c;
    }

    public int getLine(){ return line;}
    public int getColumn(){ return column;}
}

