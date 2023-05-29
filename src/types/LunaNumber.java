package src.types;

public abstract class LunaNumber extends LunaComparable {
    private final Number value;
    public LunaNumber(Number value) {
        this.value = value;
    }
    public Number value(){return this.value;}
    public LunaNumber add(LunaNumber number){
        if(this instanceof LunaFloat || number instanceof LunaFloat){
            return new LunaFloat(this.$float() + number.$float());
        }else{
            return new LunaInteger(this.$int() + number.$int());
        }
    }

    public LunaNumber sub(LunaNumber number){
        if(this instanceof LunaFloat || number instanceof LunaFloat){
            return new LunaFloat(this.$float() - number.$float());
        }else{
            return new LunaInteger(this.$int() - number.$int());
        }
    }

    public LunaNumber mult(LunaNumber number){
        if(this instanceof LunaFloat || number instanceof LunaFloat){
            return new LunaFloat(this.$float() * number.$float());
        }else{
            return new LunaInteger(this.$int() * number.$int());
        }
    }

    public LunaNumber div(LunaNumber number){
        if(this instanceof LunaFloat || number instanceof LunaFloat){
            return new LunaFloat(this.$float() / number.$float());
        }else{
            return new LunaInteger(this.$int() / number.$int());
        }
    }

    public LunaNumber mod(LunaNumber number){
        if(this instanceof LunaFloat || number instanceof LunaFloat){
            return new LunaFloat(this.$float() % number.$float());
        }else{
            return new LunaInteger(this.$int() % number.$int());
        }
    }

    public LunaNumber minus(){
        if(this instanceof LunaFloat){
            return new LunaFloat(value.floatValue()*-1);
        }else{
            return new LunaInteger(value.intValue()*-1);
        }
    }

    public int $int(){
        return value.intValue();
    }

    public float $float(){
        return value.floatValue();
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public int compare(LunaComparable obj) {
        if(this.getClass() != obj.getClass()){throw new RuntimeException();}
        LunaNumber objNumber = (LunaNumber)obj;
        if(value instanceof Float){
            return (int)(this.$float() - objNumber.$float());
        }
        return this.$int() - objNumber.$int();
    }
}