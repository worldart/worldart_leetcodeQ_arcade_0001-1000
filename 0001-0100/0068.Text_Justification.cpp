//0ms

class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> result;
        int i = 0;
        
        while (i < words.size()) {
            int lineLen = words[i].size();
            int j = i + 1;
            
            // Find the words that can fit in the current line
            while (j < words.size() && lineLen + 1 + words[j].size() <= maxWidth) {
                lineLen += 1 + words[j].size();
                j++;
            }
            
            int numWords = j - i;
            int totalSpaces = maxWidth - lineLen + numWords - 1;
            
            // Construct the formatted line
            string line = words[i];
            if (numWords == 1 || j == words.size()) { // Left-justify
                for (int k = i + 1; k < j; k++) {
                    line += " " + words[k];
                }
                line += string(maxWidth - line.size(), ' '); // Pad with spaces
            } else { // Fully justify
                int spacesBetweenWords = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);
                for (int k = i + 1; k < j; k++) {
                    int spaces = k - i <= extraSpaces ? spacesBetweenWords + 1 : spacesBetweenWords;
                    line += string(spaces, ' ') + words[k];
                }
            }
            
            result.push_back(line);
            i = j;
        }
        
        return result;
    }
};
