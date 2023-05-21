package src.ast.abstracts;

public class Node {
    private final int line;
    private final int col;

    public Node(int l, int c){
        line = l;
        col = c;
    }

    public int getLine(){ return line;}
    public int getCol(){ return col;}
}

