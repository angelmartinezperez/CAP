#!/usr/bin/env bash

EXERCISE="$1"

if [ -z "$EXERCISE" ]; then
    echo "Usage: ./test.sh <exercise-directory>"
    exit 1
fi

if [ ! -d "$EXERCISE" ]; then
    echo "Error: Directory '$EXERCISE' does not exist."
    exit 1
fi

cd "$EXERCISE" || exit 1

if clojure -M -e '(do (with-out-str (load-file "solution.clj")) (doseq [line (line-seq (clojure.java.io/reader "input.txt"))] (println (eval (read-string line)))) )' > actual.txt; then
    diff -u expected.txt actual.txt
    RESULT=$?
    if [ "$RESULT" -eq 0 ]; then
        echo "Tests passed: $EXERCISE"
    else
        echo "Tests failed: $EXERCISE"
        exit 1
    fi
else
    echo "Clojure execution failed"
    exit 1
fi