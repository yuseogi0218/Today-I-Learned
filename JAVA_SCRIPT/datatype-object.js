// Object - 按眉

var person = {
    name: ['Bob', 'Smith'],
    age: 32,
    gender: 'male',
    interests: ['music', 'skiing'],
    bio: function () {
        console.log(this.name[0] + ' ' + this.name[1] + ' is ' + this.age + ' years old. He likes ' + this.interests[0] + ' and ' + this.interests[1] + '.');
    },
    greeting: function () {
        console.log('Hi! I\'m ' + this.name[0] + '.');
    }
};

person.bio();

/*
 * property(加籍) - 按眉俊 家加等 函荐
 * method(皋家靛) - 按眉俊 家加等 窃荐
 * */