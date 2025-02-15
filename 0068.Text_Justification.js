//0ms

var fullJustify = function(words, maxWidth) {
    let result = [];
    
    let line = [];
    let lineLength = 0;
    
    for(let i = 0; i < words.length; i++) {
        let w = words[i];
        
        if(lineLength === 0 && w.length <= maxWidth) {
			// Note: We add first word assuming no space will be added after it. As we know this is not the case. 
			//       The space for first word will be accounted for by our last word in the line & 
			//       the lack of space after last word is accounted for by this first word.
            line.push(w);
            lineLength += w.length;
        } else if(lineLength + w.length + 1 <= maxWidth){
			// we add word and consider it's length plus a space following it
            line.push(w);
            lineLength += (w.length + 1);
        } else {
			//OUR LINE IS FULL AND SHOULD BE ADDED TO THE RESULT
			
            // add the required single space after each word except last one
            line = addMinSpace(line);
            
            // find remaining space to distribute
            let remainingSpace = maxWidth - lineLength;
            
            // add remaining space to each word expect last one
            line = distributeSpaces(line, remainingSpace);

            // turn array into a single string
            let temp = line.join("")
            
            // If the line only had one large word, we add remaining spaces to it's end just like how we would later do for last line
            if(line.length === 1) temp = addRemainingSpaces(temp, remainingSpace)
            
            result.push(temp);
            
            // reset the line and it's length
            line = [];
            lineLength = 0;
            
            // add this new word like it's the first one
            line.push(w);
            lineLength += w.length;
        }
    }
    
    
    // pad our final line
    line = addMinSpace(line);
    
    // create final string
    let temp = line.join("")
    
    // find remaining padding 
    let remainingSpace = maxWidth - lineLength;
    
    // add remaining padding to end of our final line
    temp = addRemainingSpaces(temp, remainingSpace)
    
    // add final line to result
    result.push(temp);
 
    // return result
    return result;
    
	// Adds single space after each word except last one
    function addMinSpace(line) {
        for(let i = 0; i < line.length - 1; i++) line[i] += " ";
        return line;
    }
    
	// add remaining spaces to end of line
    function addRemainingSpaces(line, spaces) {
        while(spaces > 0) {
            line += " ";
            spaces--;
        }
        return line;
    }
    
	// distribute remaining spaces from left to right
    function distributeSpaces(arr, spaces) {
        while(spaces > 0 && arr.length > 1) {
           for(let i = 0; i < arr.length - 1; i++) {
                if(spaces <= 0) break;
                arr[i] = arr[i] + " ";
                spaces --;
            } 
        }
        return arr;
    }
};
