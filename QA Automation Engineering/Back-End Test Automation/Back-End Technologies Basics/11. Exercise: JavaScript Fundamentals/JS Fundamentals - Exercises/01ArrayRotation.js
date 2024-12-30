function arrayRotation(array, numberOfRotation){

    let effectiveRotations = numberOfRotation % array.length;

    let rotatedPart = array.slice(effectiveRotations); //slice() Method
    let rotatedTail = array.slice(0, effectiveRotations);

    return rotatedPart.concat(rotatedTail).join(' ')
}
