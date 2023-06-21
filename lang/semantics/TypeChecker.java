package lang.semantics;

import lang.ast.RootNode;

public class TypeChecker {
    public static void check(RootNode root)  {
        var typeAnalyzer = new TypeAnalyzer();
        var result = typeAnalyzer.Analyzer(root.Ctx());
        result.showErrors();
        result.showEnvType();
    }
}
