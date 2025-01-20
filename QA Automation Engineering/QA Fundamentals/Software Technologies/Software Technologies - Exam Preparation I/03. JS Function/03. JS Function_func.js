function solve(input) {
    let matrix = input.map(v => v.split(' ').map(x => Number(x)));

    let mainIDiagonalSum = 0;
    let secondaryDiagonalSum = 0;

    for (let d = 0; d < matrix.length; d++) {
        mainIDiagonalSum += matrix[d][d];
    }

    let index = matrix.length;
    for (let s = 0; s < matrix.length; s++) {
        index--;
        secondaryDiagonalSum += matrix[s][index];
    }

    if (mainIDiagonalSum == secondaryDiagonalSum) {
        for (let row = 0; row < matrix.length; row++) {
            for (let col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    continue;
                } else if (col == (matrix[row].length - 1 - row)) {
                    continue;
                } else {
                    matrix[row][col] = mainIDiagonalSum;
                }
            }
        }
    }

    matrix.forEach(element => {
        console.log(element.join(' '));
    });
}

input = ['5 3 12 3 1'];