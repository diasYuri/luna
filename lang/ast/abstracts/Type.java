package lang.ast.abstracts;

public abstract class Type extends Node {
      
      public Type(int l,int c){
      super(l,c);
      }
      
      public boolean match(Type t){return false;}
}
