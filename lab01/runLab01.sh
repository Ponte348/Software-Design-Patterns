#!/bin/bash
# check if current path is the same as the script to avoid errors
if [ ! -f "runLab01.sh" ]; then
    echo "Please run the script from the same directory as the script"
    exit 1
fi

echo -e "Lab I"

# compile everything
javac src/*.java

# run the generator for the 3 wordlists
echo -e "\n\n--------------------Running the generator for 3 puzzles--------------------"
cd src
echo -e "\n---------- Puzzle 1 ----------"
java WordSearchGenerator -i ../inputs/wordlist_1.txt -s 12 -o ../inputs/sdl_01.txt
echo -e "\n---------- Puzzle 2 ----------"
java WordSearchGenerator -i ../inputs/wordlist_2.txt -s 20 -o ../inputs/sdl_02.txt
echo -e "\n---------- Puzzle 3 ----------"
java WordSearchGenerator -i ../inputs/wordlist_3.txt -s 15 -o ../inputs/sdl_03.txt

# run solver for the puzzles created
echo -e "\n\n--------------------Running the solver for the 3 puzzles--------------------"
echo -e "\n---------- Puzzle 1 ----------"
java WordSearchSolver ../inputs/sdl_01.txt ../outputs/out1.txt
echo -e "\n---------- Puzzle 2 ----------"
java WordSearchSolver ../inputs/sdl_02.txt ../outputs/out2.txt
echo -e "\n---------- Puzzle 3 ----------"
java WordSearchSolver ../inputs/sdl_03.txt ../outputs/out3.txt

rm *.class
