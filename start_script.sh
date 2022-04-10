#!/bin/bash

ant
STATUS=$?
if [ $STATUS = "2" ];
then
  ./start_script.sh
fi