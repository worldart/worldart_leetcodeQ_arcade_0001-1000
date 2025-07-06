//1ms




var reverseWords = function(s) {
    s = s.trim();
    let words = s.split(/\s+/);
    let reversedWords = words.reverse();
    return reversedWords.join(' ');
};





//1ms






/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
  return s
    .trim()                 // Remove leading/trailing spaces
    .split(/\s+/)           // Split by one or more spaces using RegEx
    .reverse()              // Reverse the array of words
    .join(" ");             // Join back with a single space
}





//1ms





/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    
let word = s.trim().split(/\s+/);
let hello =""
for (let i = word.length-1; i>=0; i--) {
  hello +=(word[i]+ " ")


}
hello =hello.trim()

return hello;
};
