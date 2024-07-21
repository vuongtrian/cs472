// Exe 1
String.prototype.filter = function (bannedWords) {
  let words = this.split(" ");
  let filterWords = words.filter((word) => !bannedWords.includes(word));
  return filterWords.join(" ");
};

console.log("This house is not nice!".filter(["not"]));
console.log("This house is not nice and not clean!".filter(["not", "and"]));

// Exe 2
Array.prototype.bubbleSort = function () {
  let i, j, temp;
  let swapped;
  let len = this.length;
  for (i = 0; i < len - 1; i++) {
    swapped = false;
    for (j = 0; j < len - i - 1; j++) {
      if (this[j] > this[j + 1]) {
        temp = this[j];
        this[j] = this[j + 1];
        this[j + 1] = temp;
        swapped = true;
      }
    }
    if (swapped == false) break;
  }
  return this;
};
console.log([6, 4, 0, 3, -2, 1].bubbleSort());

// Exe 3
function Person(name) {
  this.name = name;
}
Person.prototype.getName = function () {
  return this.name;
};

function Teacher(name) {
  Person.call(this, name);
}
Teacher.prototype = Object.create(Person.prototype);
Teacher.prototype.constructor = Teacher;
Teacher.prototype.teach = function (subj) {
  console.log(`${this.name} is now teaching ${subj}`);
};
const john = new Teacher("John");
john.teach("Math");

// Exe 4
function Person(name, age) {
  this.name = name;
  this.age = age;
}
Person.prototype.greeting = function () {
  console.log(
    `Greetings, my name is ${this.name} and I am ${this.age} years old.`
  );
};
Person.prototype.salute = function () {
  console.log(
    "Good morning!, and in case I don't see you, good afternoon, good evening and good night!"
  );
};

function Student(name, age, major) {
  Person.call(name, age);
  this.major = major;
}
Student.prototype = Object.create(Person.prototype);
Student.prototype.constructor = Student;
Student.prototype.greeting = function () {
  console.log(`Hey, my name is ${this.name} and I am studying ${this.major}.`);
};

function Professor(name, age, department) {
  Person.call(this, name, age);
  this.department = department;
}
Professor.prototype = Object.create(Person.prototype);
Professor.prototype.constructor = Professor;
Professor.prototype.greeting = function () {
  console.log(
    `Good day, my name is ${this.name} and I am in the ${this.department} department.`
  );
};

const student = new Student("Alice", 20, "Computer Science");
student.greeting();
student.salute();

const professor = new Professor("Dr. Smith", 45, "Physics");
professor.greeting();
professor.salute();
