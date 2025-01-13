//57.69% RT
class Solution {
public:
    string countAndSay(int n) { // Function to generate the nth term of the count-and-say sequence
        string ans = "1"; // Initialize the first term of the sequence as "1"
        for(int i = 2;i <= n;i++) // Loop to generate subsequent terms of the sequence up to nth term
        {
            string temp = ""; // Temporary string to hold the current term being generated
            int j = 0; // Initialize index for traversing the current term
            while(j < ans.size()) // Loop to iterate through the current term
            {
                int cnt = 0; // Counter to keep track of the number of consecutive digits
                char ch = ans[j]; // Current character being examined
                while(j <= ans.size() && ans[j]==ch) // Loop to count the number of consecutive occurrences of the current character
                {
                    cnt++; // Increment the count
                    j++; // Move to the next character
                }
                temp += to_string(cnt)+ ch; // Append the count followed by the character to the temporary string
            }
            ans = temp; // Update the current term with the newly generated term
        }
        return ans; // Return the nth term of the count-and-say sequence
    }
};
