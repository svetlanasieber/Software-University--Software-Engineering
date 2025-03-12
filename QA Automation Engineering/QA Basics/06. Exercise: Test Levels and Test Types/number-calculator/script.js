let num1Field = document.getElementById('number1');
let num2Field = document.getElementById('number2');
let operationField = document.getElementById('operation');
let resultField = document.getElementById('result');

document.getElementById('calcButton').onclick = calculate;
document.getElementById('resetButton').onclick = resetNumbers;

function calculate() {
  let num1 = parseFloat(num1Field.value);
  let num2 = parseFloat(num2Field.value);
  let op = operationField.value;
  let result;
  if (Number.isNaN(num1) || Number.isNaN(num2))
    result = "<i>invalid input</i>";
  else  if (op == '+')
    result = num1 + num2;
  else if (op == '-')
    result = num1 - num2;
  else if (op == '*')
    result = num1 * num2;
  else if (op == '/')
    result = num1 / num2;
  else
    result = "<i>invalid operation</i>";
  if (Number.isNaN(result))
    result = "<i>invalid calculation</i>";
  if (typeof(result) == "number")
    result = '<pre>' + parseFloat(result.toPrecision(12)) + '</pre>';
  resultField.innerHTML = "<h4>Result:</h4> " + result;
}

function resetNumbers() {
  resultField.innerHTML = '';
}
