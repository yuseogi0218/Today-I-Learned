var number = [1, 400, 12, 34]; // �迭 ����
var i = 0;
var total = 0;
while (i < number.length) { // �迭 ���̸�ŭ �ݺ�
    total = total + number[i]; // �迭�� ��
    i = i + 1;
}
console.log(`total : ${total}`);

var result_ = 0;
for (var l in number) { // in �迭 -> �迭�� index�� ����
    result_ = result_ + number[l];
}
console.log(`total : ${result_}`);

var result = 0;
for (var j of number) { // of �迭 -> �迭�� ���� ����
    result = result + j;
}

console.log(`total : ${result}`);