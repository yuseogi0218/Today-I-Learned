var objects = {
	"a": 1,
	"b": 2,
	"c_list" : [1,2,3,4,5]
}

for (var key in objects) {
	console.log(key); // 키값 접근
	console.log(objects[key]); // 키에 해당하는 데이터에 접근
}