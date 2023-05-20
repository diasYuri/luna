// Generated from ../src/parser/LunaLang.g4 by ANTLR 4.8

    package src.parser;

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
	 * Enter a parse tree produced by {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(LunaLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(LunaLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LunaLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LunaLangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(LunaLangParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(LunaLangParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterRexp(LunaLangParser.RexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitRexp(LunaLangParser.RexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterAexp(LunaLangParser.AexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitAexp(LunaLangParser.AexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void enterMexp(LunaLangParser.MexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void exitMexp(LunaLangParser.MexpContext ctx);
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
	 * Enter a parse tree produced by the {@code ignore}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterIgnore(LunaLangParser.IgnoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ignore}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitIgnore(LunaLangParser.IgnoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void enterPexp(LunaLangParser.PexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void exitPexp(LunaLangParser.PexpContext ctx);
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
	 * Enter a parse tree produced by {@link LunaLangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(LunaLangParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LunaLangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(LunaLangParser.LvalueContext ctx);
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