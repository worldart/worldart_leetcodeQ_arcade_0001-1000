//1ms 99.43%RT


class Solution 
{
    public boolean hasSpecialSubstring(String s, int k) 
    {
        int len = s.length();

        // Step 1: Iterate over all possible substrings of length k
        for (int i = 0; i <= len - k; i++)
        {
            char curr = s.charAt(i);
            boolean flag = true;

            // Step 2: Check if all characters in substring are the same
            for (int j = i; j < i + k; j++)
            {
                if (s.charAt(j) != curr)
                {
                    flag = false;
                    break;
                }
            }

            // Step 3: Check isolation conditions
            if (flag)
            {
                if (i > 0 && s.charAt(i - 1) == curr) // Step 3.1: Check previous character
                {
                    continue;
                }

                if (i + k < len && s.charAt(i + k) == curr) // Step 3.2: Check next character
                {
                    continue;
                }

                return true; // Step 4: Found a valid substring
            }
        }

        return false; // Step 5: No special substring found
    }
}
