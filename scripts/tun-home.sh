#!/bin/bash

# elaine:6789       nzbget
# elaine:80         nas admin
# rpi-bplus1:8081   sb
# rpi-bplus1:5050   cp
# george:32400      pms

FWD="-L6789:elaine:6789 -L8081:rpi-bplus1:8081 -L5050:rpi-bplus1:5050 -L5555:elaine:80 -L32400:george:32400"
CMD="ssh -N -f $FWD cj@sarcastico.net"

PID=( $(ps -ef | grep "ssh" | grep "elaine" | grep -v "$0" | awk '{ print $2 }') )

# if no param, fire up the forwarding
if [ -z "$1" ] || [ "status" = "$1" ]; then
    if [ -z "$PID" ]; then
        echo "not running"
    else
        echo "already running, pid $PID. to stop: $0 stop"
    fi
elif [ "$1" = "stop" ]; then
    if [ -z "$PID" ]; then
        echo "not running"
    else
        echo "stopping proc $PID";
        kill -9 $PID
    fi
elif [ "$1" = "start" ]; then
    if [ -z "$PID" ]; then
        echo "starting... $FWD";
        $CMD
    else
        echo "not running"
    fi
else
    echo "don't know what to do with '$1'"
fi

exit
