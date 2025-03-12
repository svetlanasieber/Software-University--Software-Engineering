function calculate(age, income) {
    
    let ageResult = calculateAge(age);
    let incomeResult = calculateIncome(income);

    let ageRisk = 0;
    if(ageResult == "child") {
      ageRisk = 100;
     } else if (ageResult == "teenager") {
      ageRisk = 60;
    } else if (ageResult == "adult") {
      ageRisk = 10;
    } else if (ageResult == "elder") {
      ageRisk = 20;
    }

    let incomeRisk = 0;
    if(incomeResult == "low") {
      incomeRisk = 50;
     } else if (incomeResult == "mid") {
      incomeRisk = 30;
    } else if (incomeResult == "high") {
      incomeRisk = 10;
    }

  let ageRiskPercent = ageRisk / 100;
  let incomeRiskPercent = incomeRisk / 100;
  
    return ageRiskPercent + incomeRiskPercent - (ageRiskPercent * incomeRiskPercent);
}

function calculateAge(age) {
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

function calculateIncome(income) {
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