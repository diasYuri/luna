#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Informe o arquivo"
    exit 1
fi

BUILD_DIR="../target"
LIB_ANTLR="../lib/antlr-4.8-complete.jar"

./compile.sh $BUILD_DIR

java -cp $LIB_ANTLR:$BUILD_DIR lang.Main $1
