.class public HelloWorld
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 10
    .limit locals 10

    ; Definir as variáveis locais
    .var 0 is nlines I
    .var 1 is i I
    .var 2 is j I

    ; Inicializar nlines
    ldc 5
    istore 0  ; nlines

    ; Inicializar i com nlines
    iload 0  ; nlines
    istore 1  ; i

    outer_loop:
    iload 1  ; i
    ifle done_outer_loop

    ; Inicializar j com 0
    iconst_0
    istore 2  ; j

    inner_loop:
    iload 2  ; j
    iload 1  ; i
    if_icmpge done_inner_loop

    ; Imprimir '*'
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "*"
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

    ; Incrementar j
    iinc 2 1
    goto inner_loop

    done_inner_loop:
    ; Imprimir nova linha
    getstatic java/lang/System/out Ljava/io/PrintStream;
    invokevirtual java/io/PrintStream/println()V

    ; Decrementar i
    iinc 1 -1
    goto outer_loop

    done_outer_loop:
    return
.end method