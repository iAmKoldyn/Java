#!/usr/bin/bash
a="$(date)"
k=1
> test_bash5
exec 6>&1
exec 1>test_bash5
while [[ $k -lt 2**18 ]]
do
  echo "$((2**$k))"
  k=$(($k+1))
done
b="$(date)"
echo "$a"
echo "$b"
exec 1>&-
exec 1>&6
exec 6>&-
