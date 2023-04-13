#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Informe o arquivo"
    exit 1
fi

MAIN_CLASS="Main"

PROJECT_DIR="./"

BUILD_DIR="$PROJECT_DIR/target"
FLEX_DIR="./src/lexer/luna-lang.flex"

mkdir -p $BUILD_DIR

java -jar ./lib/jflex-full-1.9.1.jar $FLEX_DIR
javac -d $BUILD_DIR $(find $PROJECT_DIR -name "*.java")

if [ $? -ne 0 ]; then
    echo "Erro ao compilar o projeto"
    exit 1
fi


java -cp $BUILD_DIR $MAIN_CLASS $1
