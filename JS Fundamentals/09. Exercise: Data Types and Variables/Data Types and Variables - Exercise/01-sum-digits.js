function sumDigits(num) {
    let numAsString = num + ''; //let numAsString = String(num);
    let sum = 0;

    for(let character of numAsString){
       let digit = Number(character)
        sum += digit;
    }

    console.log(sum);
}

sumDigits(245678)
