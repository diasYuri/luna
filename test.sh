java -jar ./lib/jflex-full-1.9.1.jar ./src/lexer/luna-lang.flex &&\
javac -d target $(find src -name "*.java") &&\
java -cp target Tests
