//0ms

var setZeroes = function(matrix) {
    const m = matrix.length;
    const n = matrix[0].length;
    const zeros = Array(m + n).fill(0); // Marker array

    // Mark rows and columns to be zeroed
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === 0) {
                zeros[i] = 1;
                zeros[m + j] = 1;
            }
        }
    }

    // Set matrix elements to zero based on marker array
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (zeros[i] === 1 || zeros[m + j] === 1) {
                matrix[i][j] = 0;
            }
        }
    }
};
