#!/bin/sh
pwd=`pwd`
cd "${0%/*}"
java -Xmx512M -DNOSECURITY=true -cp libs/robocode.jar:libs/encog-core-3.1.0.jar robocode.Robocode $*
cd "${pwd}"
