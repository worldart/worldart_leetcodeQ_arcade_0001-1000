//56ms





# Read from the file file.txt and output all valid phone numbers to stdout.

grep -e "^[0-9]\{3\}\-[0-9]\{3\}\-[0-9]\{4\}$" -e "^([0-9]\{3\}) [0-9]\{3\}\-[0-9]\{4\}$" file.txt







//45ms





//# Read from the file file.txt and output all valid phone numbers to stdout.
p1='\([0-9][0-9][0-9]\)\ [0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]'
p2='[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]'

while read line; do
  case "$line" in
  $p1 | $p2) echo "$line" ;;
  esac
done <file.txt
