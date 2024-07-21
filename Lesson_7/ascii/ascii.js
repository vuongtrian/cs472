var defaultSpeed = 250;
var time = null;
var temp = 0;
var word = "";

window.onload = function () {
  var ani = document.getElementById("animation");
  ani.onchange = changeAnimation;
  ani.disabled = false;

  var biggieSmalls = document.getElementById("fontsize");
  biggieSmalls.onchange = changeSize;

  var start = document.getElementById("start");
  start.onclick = startButton;
  start.disabled = false;

  var stop = document.getElementById("stop");
  stop.onclick = stopButton;
  stop.disabled = true;

  var amphetamine = document.getElementById("turbo");
  amphetamine.onchange = gottaGoFast;
};

function startButton() {
  var ani = document.getElementById("animation");
  var contents = ANIMATIONS[ani.value];
  var box = document.getElementById("text-area");

  word = box.value;

  var aniArray = contents.split("=====\n");
  var length = aniArray.length;

  ani.disabled = false;
  document.getElementById("start").disabled = true;
  document.getElementById("stop").disabled = false;
  time = setInterval(aniFrames, defaultSpeed, aniArray, length);
}

function stopButton() {
  var box = document.getElementById("text-area");

  box.value = word;
  word = "";
  clearInterval(time);
  time = null;
  temp = 0;
  document.getElementById("animation").disabled = false;
  document.getElementById("start").disabled = false;
  document.getElementById("stop").disabled = true;
}

function aniFrames(array, length) {
  var box = document.getElementById("text-area");
  box.value = array[temp % length];
  temp++;
}

function changeAnimation() {
  var ani = document.getElementById("animation");
  document.getElementById("text-area").value = ANIMATIONS[ani.value];
}

function changeSize() {
  var biggieSmalls = document.getElementById("fontsize");
  var box = document.getElementById("text-area");
  box.style.fontSize = biggieSmalls.value;
}

function gottaGoFast() {
  if (this.checked) {
    time = 50;
  } else {
    time = 250;
  }
}
