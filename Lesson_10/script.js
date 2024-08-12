document.getElementById("startButton").addEventListener("click", function () {
  const width = parseInt(document.getElementById("width").value);
  const growthAmount = parseInt(document.getElementById("growthAmount").value);
  const growRate = parseInt(document.getElementById("growRate").value);
  const numberCircles = parseInt(
    document.getElementById("numberCircles").value
  );
  const container = document.getElementById("circleContainer");

  container.innerHTML = ""; // Clear existing circles

  for (let i = 0; i < numberCircles; i++) {
    createCircle(width, growthAmount, growRate, container);
  }
});

function createCircle(width, growthAmount, growRate, container) {
  const circle = document.createElement("div");
  circle.classList.add("circle");
  circle.style.width = width + "px";
  circle.style.height = width + "px";

  // Randomly position the circle within the container
  circle.style.left = Math.random() * (container.offsetWidth - width) + "px";
  circle.style.top = Math.random() * (container.offsetHeight - width) + "px";

  container.appendChild(circle);

  const intervalId = setInterval(function () {
    let newWidth = parseInt(circle.style.width) + growthAmount;
    circle.style.width = newWidth + "px";
    circle.style.height = newWidth + "px";
  }, growRate);

  circle.addEventListener("click", function () {
    clearInterval(intervalId);
    circle.remove();
  });
}
