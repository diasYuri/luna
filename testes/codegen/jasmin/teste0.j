.class public HelloWorld
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 10
    .limit locals 10

    ; Definir o número de linhas (nlines)
    ldc 5
    istore_0

    ; Definir o valor inicial de i
    iload_0
    istore_1

    ; Loop externo (iterar nlines vezes)
    outer_loop:
    iload_0
    ifle done_outer_loop

    ; Loop interno (iterar i vezes)
    inner_loop:
    iload_1
    ifle done_inner_loop

    ; Imprimir '*'
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "*"
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

    ; Decrementar i
    iinc 1 -1
    goto inner_loop

    done_inner_loop:
    ; Pular para uma nova linha
    getstatic java/lang/System/out Ljava/io/PrintStream;
    invokevirtual java/io/PrintStream/println()V

    ; Decrementar nlines
    iinc 0 -1
    goto outer_loop

    done_outer_loop:
    return

.end method
