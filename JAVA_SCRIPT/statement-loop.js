var number = [1, 400, 12, 34]; // 배열 생성
var i = 0;
var total = 0;
while (i < number.length) { // 배열 길이만큼 반복
    total = total + number[i]; // 배열의 합
    i = i + 1;
}
console.log(`total : ${total}`);

var result_ = 0;
for (var l in number) { // in 배열 -> 배열의 index에 접근
    result_ = result_ + number[l];
}
console.log(`total : ${result_}`);

var result = 0;
for (var j of number) { // of 배열 -> 배열의 값에 접근
    result = result + j;
}

console.log(`total : ${result}`);