#/bin/bash

# check if current path is the same as the script to avoid errors
if [ ! -f "runJGalo.sh" ]; then
    echo "Please run the script from the same directory as the script"
    exit 1
fi

echo -e "Lab III"

echo -e "\nA compilar..."
javac src/*.java
echo -e "Compilado com sucesso!\n"

echo -e "A correr...\n"

cd src
java JGalo
echo -e "Fim da execução"
