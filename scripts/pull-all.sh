#!/bin/bash

#set -x
pushd /home/cjones/dev/ >/dev/null 2>&1

arr=( $(find -L ./ | grep .git/HEAD | sort) )

DIR=`pwd`
for var in "${arr[@]}"
do
    #echo "$DIR/${var/\.git\/HEAD/}"
    pushd $DIR/${var/\.git\/HEAD/} >/dev/null 2>&1
    git status
    popd >/dev/null 2>&1
done

echo -n "Proceed with 'git pull' (Y/N)? "
read -e CONTINUE

if [ "Y" == $CONTINUE -o "y" == $CONTINUE ]; then 
    for var in "${arr[@]}" 
    do 
        echo pulling $DIR/${var/\.git\/HEAD/}
        pushd $DIR/${var/\.git\/HEAD/} >/dev/null 2>&1
        git pull # -q
        popd >/dev/null 2>&1
    done 
fi

popd >/dev/null 2>&1
