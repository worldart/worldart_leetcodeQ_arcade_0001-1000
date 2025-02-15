//0ms


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
char ** fullJustify(char ** words, int wordsSize, int maxWidth, int* returnSize) {
    char **result = (char **)malloc(sizeof(char *) * wordsSize);
    *returnSize = 0;
    
    int start = 0;  // Index of the first word in the current line.
    
    while (start < wordsSize) {
        int end = start;  // Index of the last word in the current line.
        int lineLength = 0;  // Length of the words and spaces in the current line.
        
        // Calculate the number of words and total length that can fit in the current line.
        while (end < wordsSize && lineLength + strlen(words[end]) + end - start <= maxWidth) {
            lineLength += strlen(words[end]);
            end++;
        }
        
        // Calculate the total number of spaces needed in the line.
        int totalSpaces = maxWidth - lineLength;
        
        // If it's the last line or only one word in the line, left-justify.
        if (end == wordsSize || end - start == 1) {
            result[*returnSize] = (char *)malloc(sizeof(char) * (maxWidth + 1));
            int idx = 0;
            for (int i = start; i < end; i++) {
                strcpy(result[*returnSize] + idx, words[i]);
                idx += strlen(words[i]);
                if (i != end - 1) {
                    result[*returnSize][idx++] = ' ';
                }
            }
            while (idx < maxWidth) {
                result[*returnSize][idx++] = ' ';
            }
            result[*returnSize][maxWidth] = '\0';
        } else {
            int spaceBetweenWords = totalSpaces / (end - start - 1);
            int extraSpaces = totalSpaces % (end - start - 1);
            
            result[*returnSize] = (char *)malloc(sizeof(char) * (maxWidth + 1));
            int idx = 0;
            for (int i = start; i < end; i++) {
                strcpy(result[*returnSize] + idx, words[i]);
                idx += strlen(words[i]);
                if (i != end - 1) {
                    int spaces = spaceBetweenWords + (extraSpaces > 0 ? 1 : 0);
                    extraSpaces--;
                    for (int j = 0; j < spaces; j++) {
                        result[*returnSize][idx++] = ' ';
                    }
                }
            }
            result[*returnSize][maxWidth] = '\0';
        }
        
        (*returnSize)++;
        start = end;
    }
    
    return result;
}
