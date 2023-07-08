.class public HelloWorld
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 10
    .limit locals 10

    
    .var 0 is n I
    .var 1 is q I
    .var 2 is w I
    .var 3 is z I

    
    ldc 13
    istore 0  ; n
    ldc 5
    istore 1  ; q

   
    iload 0  ; n
    iload 1  ; q
    invokestatic HelloWorld/divMod(II)[I
    dup
    iconst_1
    iaload
    istore 2  ; w

    
    iload 2  ; w
    iconst_2
    imul
    iconst_1
    iadd
    istore 3  ; z

    
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Z:"
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

    
    iload 3  ; z
    invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

    
    getstatic java/lang/System/out Ljava/io/PrintStream;
    invokevirtual java/io/PrintStream/println()V

    return
.end method

.method public static divMod(II)[I
    .limit stack 10
    .limit locals 10

    
    .var 0 is n I
    .var 1 is q I
    .var 2 is result [I

    
    ldc 2
    newarray int
    astore 2

    
    iload 0  ; n
    iload 1  ; q
    idiv
    aload 2  ; result
    iconst_0
    swap
    iastore

    
    iload 0  ; n
    iload 1  ; q
    irem
    aload 2  ; result
    iconst_1
    swap
    iastore


    aload 2  ; result
    areturn
.end method
