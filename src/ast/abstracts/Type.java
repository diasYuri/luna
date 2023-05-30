package src.ast.abstracts;

import src.ast.abstracts.BinOp;
import src.ast.abstracts.Expr;
import src.ast.abstracts.Node;

public abstract class Type extends Node {
      
      public Type(int l,int c){
      super(l,c);
      }
      
      public abstract boolean match(Type t);
}
