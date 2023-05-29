// Generated from ../src/parser/LunaLang.g4 by ANTLR 4.8

    package src.parser;
    import src.ast.*;
    import src.ast.abstracts.*;
    import src.ast.types.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LunaLangParser}.
 */
public interface LunaLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LunaLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LunaLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(LunaLangParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(LunaLangParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(LunaLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(LunaLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(LunaLangParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(LunaLangParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(LunaLangParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(LunaLangParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cmdscope}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmdscope(LunaLangParser.CmdscopeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cmdscope}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmdscope(LunaLangParser.CmdscopeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterIf(LunaLangParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitIf(LunaLangParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iterate}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterIterate(LunaLangParser.IterateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iterate}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitIterate(LunaLangParser.IterateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code read}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterRead(LunaLangParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code read}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitRead(LunaLangParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterPrint(LunaLangParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitPrint(LunaLangParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterReturn(LunaLangParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitReturn(LunaLangParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attr}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterAttr(LunaLangParser.AttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attr}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitAttr(LunaLangParser.AttrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code call_attr}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCall_attr(LunaLangParser.Call_attrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code call_attr}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCall_attr(LunaLangParser.Call_attrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link LunaLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(LunaLangParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link LunaLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(LunaLangParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeignore}
	 * labeled alternative in {@link LunaLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeignore(LunaLangParser.TypeignoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeignore}
	 * labeled alternative in {@link LunaLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeignore(LunaLangParser.TypeignoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andexp}
	 * labeled alternative in {@link LunaLangParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAndexp(LunaLangParser.AndexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andexp}
	 * labeled alternative in {@link LunaLangParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAndexp(LunaLangParser.AndexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expignore}
	 * labeled alternative in {@link LunaLangParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpignore(LunaLangParser.ExpignoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expignore}
	 * labeled alternative in {@link LunaLangParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpignore(LunaLangParser.ExpignoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lesser_than}
	 * labeled alternative in {@link LunaLangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterLesser_than(LunaLangParser.Lesser_thanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lesser_than}
	 * labeled alternative in {@link LunaLangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitLesser_than(LunaLangParser.Lesser_thanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equals}
	 * labeled alternative in {@link LunaLangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterEquals(LunaLangParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equals}
	 * labeled alternative in {@link LunaLangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitEquals(LunaLangParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notequals}
	 * labeled alternative in {@link LunaLangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterNotequals(LunaLangParser.NotequalsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notequals}
	 * labeled alternative in {@link LunaLangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitNotequals(LunaLangParser.NotequalsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rexpignore}
	 * labeled alternative in {@link LunaLangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterRexpignore(LunaLangParser.RexpignoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rexpignore}
	 * labeled alternative in {@link LunaLangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitRexpignore(LunaLangParser.RexpignoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code add}
	 * labeled alternative in {@link LunaLangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterAdd(LunaLangParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add}
	 * labeled alternative in {@link LunaLangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitAdd(LunaLangParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sub}
	 * labeled alternative in {@link LunaLangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterSub(LunaLangParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sub}
	 * labeled alternative in {@link LunaLangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitSub(LunaLangParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aexpignore}
	 * labeled alternative in {@link LunaLangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterAexpignore(LunaLangParser.AexpignoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aexpignore}
	 * labeled alternative in {@link LunaLangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitAexpignore(LunaLangParser.AexpignoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code div}
	 * labeled alternative in {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void enterDiv(LunaLangParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code div}
	 * labeled alternative in {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void exitDiv(LunaLangParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mult}
	 * labeled alternative in {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void enterMult(LunaLangParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mult}
	 * labeled alternative in {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void exitMult(LunaLangParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mod}
	 * labeled alternative in {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void enterMod(LunaLangParser.ModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mod}
	 * labeled alternative in {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void exitMod(LunaLangParser.ModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mexpignore}
	 * labeled alternative in {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void enterMexpignore(LunaLangParser.MexpignoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mexpignore}
	 * labeled alternative in {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void exitMexpignore(LunaLangParser.MexpignoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nexp}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterNexp(LunaLangParser.NexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nexp}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitNexp(LunaLangParser.NexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minusexp}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterMinusexp(LunaLangParser.MinusexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minusexp}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitMinusexp(LunaLangParser.MinusexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code true}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterTrue(LunaLangParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code true}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitTrue(LunaLangParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code false}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterFalse(LunaLangParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code false}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitFalse(LunaLangParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code null}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterNull(LunaLangParser.NullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code null}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitNull(LunaLangParser.NullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterInt(LunaLangParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitInt(LunaLangParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code float}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterFloat(LunaLangParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code float}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitFloat(LunaLangParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code char}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterChar(LunaLangParser.CharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code char}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitChar(LunaLangParser.CharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pexpignore}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterPexpignore(LunaLangParser.PexpignoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pexpignore}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitPexpignore(LunaLangParser.PexpignoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tuple}
	 * labeled alternative in {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void enterTuple(LunaLangParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tuple}
	 * labeled alternative in {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void exitTuple(LunaLangParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new}
	 * labeled alternative in {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void enterNew(LunaLangParser.NewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new}
	 * labeled alternative in {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void exitNew(LunaLangParser.NewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callValue}
	 * labeled alternative in {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void enterCallValue(LunaLangParser.CallValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callValue}
	 * labeled alternative in {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void exitCallValue(LunaLangParser.CallValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pexpLvalue}
	 * labeled alternative in {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void enterPexpLvalue(LunaLangParser.PexpLvalueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pexpLvalue}
	 * labeled alternative in {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void exitPexpLvalue(LunaLangParser.PexpLvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#exps}.
	 * @param ctx the parse tree
	 */
	void enterExps(LunaLangParser.ExpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#exps}.
	 * @param ctx the parse tree
	 */
	void exitExps(LunaLangParser.ExpsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lvalueAccess}
	 * labeled alternative in {@link LunaLangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalueAccess(LunaLangParser.LvalueAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lvalueAccess}
	 * labeled alternative in {@link LunaLangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalueAccess(LunaLangParser.LvalueAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lvalueId}
	 * labeled alternative in {@link LunaLangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalueId(LunaLangParser.LvalueIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lvalueId}
	 * labeled alternative in {@link LunaLangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalueId(LunaLangParser.LvalueIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lvalueArr}
	 * labeled alternative in {@link LunaLangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalueArr(LunaLangParser.LvalueArrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lvalueArr}
	 * labeled alternative in {@link LunaLangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalueArr(LunaLangParser.LvalueArrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterBtype(LunaLangParser.BtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitBtype(LunaLangParser.BtypeContext ctx);
}