package lang.interpreter;

public class ContextSignal {
    private boolean hasSignal;

    public boolean listingSignal(boolean removeSignal) {
        if (this.hasSignal) {
            if (removeSignal) {
                this.hasSignal = false;
            }
            return true;
        }
        return false;
    }

    public void emitSignal() {
        hasSignal = true;
    }
}
