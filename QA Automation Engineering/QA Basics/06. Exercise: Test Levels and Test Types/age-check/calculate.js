function calculate(age) {

    let result = "";
    if (age < 0 || age >=150){
      result = "error"
    }else if (age >= 0 && age <13){
        result = "child"
    }else if (age >= 13 && age < 20){
        result = "teenager" 
    }else if (age >= 20 && age < 65){
        result = "adult"
    }else if (age > 64){
        result = "elder" 
    }
    return result;
}