package lang.interpreter.types;

public abstract class LunaComparable implements LunaEquatable {
    public abstract int compare(LunaComparable obj);
    @Override
    public LunaBoolean equal(LunaEquatable obj) {
        if (obj.getClass() != this.getClass()) throw new RuntimeException();
        return new LunaBoolean(this.compare((LunaComparable)obj) == 0);
    }

    public LunaBoolean lt(LunaEquatable obj) {
        if (obj.getClass() != this.getClass()) throw new RuntimeException();
        return new LunaBoolean(this.compare((LunaComparable)obj) < 0);
    }
}

