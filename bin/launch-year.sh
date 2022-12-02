#!/usr/bin/env bash

if [ $# -ne 1 ]
  then
    echo "Wrong number of args. Usage: $0 <year>"
    exit 1
fi

sbt test

sbt "run $1"