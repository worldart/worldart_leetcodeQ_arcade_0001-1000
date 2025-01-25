//100%RT

void transpose(int ** matrix, int matrixSize){
    int i, j, temp;
    for(i = 0; i < matrixSize; i++){
        for(j = i; j < matrixSize; j++){
            temp = matrix[i][j];
            matrix[i][j] =  matrix[j][i];
            matrix[j][i] = temp;
            
        }
    }
}

void reverseRows(int ** matrix, int matrixSize){
    int i, start, end, temp;
    for(i = 0; i < matrixSize; i++){
        start = 0;
        end = matrixSize - 1;
        while(start < end){
            temp = matrix[i][start];
            matrix[i][start++] = matrix[i][end];
            matrix[i][end--] = temp;
            
        }
    }

}

void rotate(int** matrix, int matrixSize, int* matrixColSize) {
    transpose(matrix, matrixSize);
    reverseRows(matrix, matrixSize);
}
