#!/bin/bash

BUILD_DIR="target"
LIB_ANTLR="lib/antlr-4.8-complete.jar"

./scripts/compile.sh $BUILD_DIR

java -cp $LIB_ANTLR:$BUILD_DIR lang.LangCompiler $1 $2