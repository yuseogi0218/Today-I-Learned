var objects = {
	"a": 1,
	"b": 2,
	"c_list" : [1,2,3,4,5]
}

for (var key in objects) {
	console.log(key); // Ű�� ����
	console.log(objects[key]); // Ű�� �ش��ϴ� �����Ϳ� ����
}