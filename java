let display = document.getElementById('display');
let currentInput = '';
let operator = '';
let operand1 = null;
let operand2 = null;

function appendNumber(number) {
    currentInput += number;
    display.value = currentInput;
}

function appendOperator(op) {
    if (currentInput === '' && op !== '.') return;
    if (currentInput !== '' && operator === '') {
        operand1 = parseFloat(currentInput);
        operator = op;
        currentInput = '';
        display.value = operator;
    } else if (op === '.') {
        if (!currentInput.includes('.')) {
            currentInput += op;
            display.value = currentInput;
        }
    }
}

function calculate() {
    if (currentInput === '') return;
    operand2 = parseFloat(currentInput);
    let result = 0;
    switch (operator) {
        case '+':
            result = operand1 + operand2;
            break;
        case '-':
            result = operand1 - operand2;
            break;
        case '*':
            result = operand1 * operand2;
            break;
        case '/':
            result = operand1 / operand2;
            break;
    }
    display.value = result;
    currentInput = '';
    operator = '';
    operand1 = null;
    operand2 = null;
}

function clearDisplay() {
    currentInput = '';
    operator = '';
    operand1 = null;
    operand2 = null;
    display.value = '';
}
