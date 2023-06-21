package lang.semantics;

import java.util.ArrayList;

public interface Analyzed {
    void showErrors();
    void showEnvType();
    ArrayList<String> getErrors();
}
