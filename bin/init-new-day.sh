#!/usr/bin/env bash

if [ $# -ne 2 ]
  then
    echo "Wrong number of args. Usage: $0 <year> <day>"
    exit 1
fi

REQ_YEAR=$1
REQ_DAY=$2

# create README.md file and folder
README_FOLDER="docs/$REQ_YEAR/$REQ_DAY"
mkdir "$README_FOLDER"
README_FILE="$README_FOLDER/README.md"
if test -f "$README_FILE"; then
    echo "$README_FILE already exists."
else
  echo "creating $README_FILE"
  echo "# AoC | Year $REQ_YEAR | Day $REQ_DAY challenge " > "$README_FILE"
fi

# create input.txt file and folder
INPUT_FOLDER="src/main/resources/$REQ_YEAR/$REQ_DAY"
mkdir "$INPUT_FOLDER"
INPUT_FILE="$INPUT_FOLDER/input.txt"
if test -f "$INPUT_FILE"; then
    echo "$INPUT_FILE already exists."
else
  echo "creating $INPUT_FILE"
  echo "" > "$INPUT_FILE"
fi



