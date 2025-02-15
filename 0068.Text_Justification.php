//0ms

class Solution {
    /**
     * @param String[] $words
     * @param Integer $maxWidth
     * @return String[]
     */
    function fullJustify($words, $maxWidth) {
        $result = [];
        $line = [];
        $lineWidth = 0;
        
        foreach ($words as $word) {
            // Check if adding the next word exceeds maxWidth
            if ($lineWidth + count($line) + strlen($word) > $maxWidth) {
                $formattedLine = $this->formatLine($line, $lineWidth, $maxWidth);
                $result[] = $formattedLine;
                
                $line = [];
                $lineWidth = 0;
            }
            
            $line[] = $word;
            $lineWidth += strlen($word);
        }
        
        // Handle the last line
        $lastLine = implode(' ', $line);
        $lastLine .= str_repeat(' ', $maxWidth - strlen($lastLine));
        $result[] = $lastLine;
        
        return $result;
    }
    
    // Helper function to format a line
    private function formatLine($line, $lineWidth, $maxWidth) {
        $numWords = count($line);
        $numSpaces = $maxWidth - $lineWidth;
        
        if ($numWords === 1) {
            return $line[0] . str_repeat(' ', $numSpaces);
        }
        
        $avgSpaces = floor($numSpaces / ($numWords - 1));
        $extraSpaces = $numSpaces % ($numWords - 1);
        
        $formattedLine = $line[0];
        
        for ($i = 1; $i < $numWords; $i++) {
            $numPaddingSpaces = $avgSpaces + ($i <= $extraSpaces ? 1 : 0);
            $formattedLine .= str_repeat(' ', $numPaddingSpaces) . $line[$i];
        }
        
        return $formattedLine;
    }
}
