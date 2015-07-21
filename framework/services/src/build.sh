#!/bin/sh
DIR=`dirname $0`
cd "$DIR"
PWDP=`pwd -P`
cd "$PWDP"
../../../../common/build/bootstrap-build.sh $*
