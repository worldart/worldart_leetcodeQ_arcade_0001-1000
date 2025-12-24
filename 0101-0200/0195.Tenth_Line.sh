//28ms



# Read from the file file.txt and output the tenth line to stdout.
awk 'NR == 10 {print; exit}' file.txt



//17ms



#!/bin/bash
# Read from the file file.txt and output the tenth line to stdout.
count=0
while read -r line; do
    ((count++))
    if [ "$count" -eq 10 ]; then
        echo "$line"  # or echo "$line" if you want to print the 10th line
    fi
done < file.txt



//24ms




# Read from the file file.txt and output the tenth line to stdout.
cnt=0
while read line && [ $cnt -le 10 ]; do
  let 'cnt = cnt + 1'
  if [ $cnt -eq 10 ]; then
    echo $line
    exit 0
  fi
done < file.txt





//21ms





# Read from the file file.txt and output the tenth line to stdout.
sed -n '10p' file.txt
