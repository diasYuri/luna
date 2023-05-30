#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Informe o arquivo"
    exit 1
fi

MAIN_CLASS="Main"

PROJECT_DIR=".."
BUILD_DIR="$PROJECT_DIR/target/"
LIB_ANTLR="../lib/antlr-4.8-complete.jar"

./compile.sh $BUILD_DIR

java -cp $LIB_ANTLR:$BUILD_DIR src.Main $1
