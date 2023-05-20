#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Informe o diretório"
    exit 1
fi

PROJECT_DIR="../src/"
BUILD_DIR=$1
PARSER_DIR="../src/parser/LunaLang.g4"
LIB_ANTLR="../lib/antlr-4.8-complete.jar"

mkdir -p $BUILD_DIR

java -jar $LIB_ANTLR $PARSER_DIR
java -jar $LIB_ANTLR -no-listener -visitor $PARSER_DIR
javac -cp .:$LIB_ANTLR -d $BUILD_DIR $(find $PROJECT_DIR -name "*.java")

if [ $? -ne 0 ]; then
    echo "Erro ao compilar o projeto"
    exit 1
fi
