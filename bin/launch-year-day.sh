#!/usr/bin/env bash

if [ $# -ne 2 ]
  then
    echo "Wrong number of args. Usage: $0 <year> <day>"
    exit 1
fi

sbt test

sbt "run $1 $2"