package token;

public class Token {
  private TOKEN_TYPE _token_type;
  private String _value;
  private int _line, _column;

    public Token(TOKEN_TYPE token_type, int line, int column){
        _token_type = token_type;
        _line = line;
        _column = column;
    }

    public Token(TOKEN_TYPE token_type, String value, int line, int column){
        _token_type = token_type;
        _line = line;
        _column = column;
        _value = value;
    }

    @Override
    public String toString(){
        return "[("+_line+","+ _column+ ") : <"
                + _token_type.toString()  + ">] : "
                + (_value != null ? _value : _token_type.value);
    }
}