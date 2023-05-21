// Generated from ../src/parser/LunaLang.g4 by ANTLR 4.8

    package src.parser;
    import src.ast.*;
    import src.ast.abstracts.*;
    import src.ast.types.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LunaLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LunaLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LunaLangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LunaLangParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LunaLangParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData(LunaLangParser.DataContext ctx);
	/**
	 * Visit a parse tree produced by {@link LunaLangParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(LunaLangParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LunaLangParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(LunaLangParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link LunaLangParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(LunaLangParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cmdignore}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdignore(LunaLangParser.CmdignoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(LunaLangParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iterate}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterate(LunaLangParser.IterateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code read}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(LunaLangParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(LunaLangParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(LunaLangParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attr}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr(LunaLangParser.AttrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code call}
	 * labeled alternative in {@link LunaLangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(LunaLangParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link LunaLangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LunaLangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LunaLangParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(LunaLangParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LunaLangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRexp(LunaLangParser.RexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code add}
	 * labeled alternative in {@link LunaLangParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(LunaLangParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sub}
	 * labeled alternative in {@link LunaLangParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(LunaLangParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aexpignore}
	 * labeled alternative in {@link LunaLangParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpignore(LunaLangParser.AexpignoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code div}
	 * labeled alternative in {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(LunaLangParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mult}
	 * labeled alternative in {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(LunaLangParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mod}
	 * labeled alternative in {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMod(LunaLangParser.ModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mexpignore}
	 * labeled alternative in {@link LunaLangParser#mexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMexpignore(LunaLangParser.MexpignoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nexp}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNexp(LunaLangParser.NexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusexp}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusexp(LunaLangParser.MinusexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code true}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(LunaLangParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code false}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(LunaLangParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code null}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull(LunaLangParser.NullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(LunaLangParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code float}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(LunaLangParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code char}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar(LunaLangParser.CharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pexpignore}
	 * labeled alternative in {@link LunaLangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPexpignore(LunaLangParser.PexpignoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tuple}
	 * labeled alternative in {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(LunaLangParser.TupleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new}
	 * labeled alternative in {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew(LunaLangParser.NewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callValue}
	 * labeled alternative in {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallValue(LunaLangParser.CallValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lvalueignore}
	 * labeled alternative in {@link LunaLangParser#pexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueignore(LunaLangParser.LvalueignoreContext ctx);
	/**
	 * Visit a parse tree produced by {@link LunaLangParser#exps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExps(LunaLangParser.ExpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LunaLangParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(LunaLangParser.LvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LunaLangParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBtype(LunaLangParser.BtypeContext ctx);
}