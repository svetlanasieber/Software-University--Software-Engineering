function solve(input) {
    let message = input[0];

    for (let i = 1; i < input.length; i++) {
        let line = input[i];

        if (line === "Buy") {
            console.log(`The cryptocurrency is: ${message}`);
            break;
        }

        let parts = line.split("?");
        let command = parts[0];

        if (command === "TakeEven") {
            let newMessage = "";
            for (let j = 0; j < message.length; j++) {
                if (j % 2 === 0) {
                    newMessage += message[j];
                }
            }
            message = newMessage;
            console.log(message);

        } else if (command === "ChangeAll") {
            let substring = parts[1];
            let replacement = parts[2];
            while (message.includes(substring)) {
                message = message.replace(substring, replacement);
            }
            console.log(message);

        } else if (command === "Reverse") {
            let substring = parts[1];
            let index = message.indexOf(substring);
            if (index !== -1) {
                message = message.slice(0, index) + message.slice(index + substring.length);
                let reversed = substring.split("").reverse().join("");
                message += reversed;
                console.log(message);
            } else {
                console.log("error");
            }
        }
    }
}


solve([
    "z2tdsfndoctsB6z7tjc8ojzdngzhtjsyVjek!snfzsafhscs",
    "TakeEven",
    "Reverse?!nzahc",
    "ChangeAll?m?g",
    "Reverse?adshk",
    "ChangeAll?z?i",
    "Buy"
]);
