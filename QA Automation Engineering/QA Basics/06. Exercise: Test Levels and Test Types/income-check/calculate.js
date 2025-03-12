function calculate(income) {

    let result = "";
    if (income < 0){
      result = "error"
    }else if (income < 1000){
        result = "low"
    }else if (income >=1000 && income < 3000){
        result = "mid" 
    }else if (income >= 3000){
        result = "high"
    }
    return result;
}