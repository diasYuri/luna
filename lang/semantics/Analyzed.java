package lang.semantics;

import java.util.ArrayList;

public interface Analyzed {
    void showErrors();

    ArrayList<String> getErrors();
}
