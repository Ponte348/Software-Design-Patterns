#/bin/bash

# check if current path is the same as the script to avoid errors
if [ ! -f "runVoos.sh" ]; then
    echo "Please run the script from the same directory as the script"
    exit 1
fi

echo -e "Lab III - Voos"

echo -e "\nA compilar..."
javac src/*.java
echo -e "Compilado com sucesso!\n"

# if we have 1 argument, run with java Voos $1, else run with java Voos
if [ $# -eq 1 ]; then
    echo -e "A correr com argumento $1..."
    cd src
    java Voos ../$1
else
    echo -e "A correr sem argumentos..."
    cd src
    java Voos
fi
echo -e "Fim da execução"
