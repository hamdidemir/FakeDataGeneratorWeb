document.addEventListener("DOMContentLoaded", function() {
var minAgeSlider = document.getElementById("minAge");
var minAgeOutput = document.getElementById("minAgeValue");

var maxAgeSlider = document.getElementById("maxAge");
var maxAgeOutput = document.getElementById("maxAgeValue");
maxAgeOutput.innerHTML = maxAgeSlider.value;

// Set the initial values of the sliders
minAgeOutput.innerHTML = minAgeSlider.value;
maxAgeOutput.innerHTML = maxAgeSlider.value;

// Send a POST request with the default values of 0 and 100 when the page loads
var formData = new FormData();
formData.append("minAge", 18);
formData.append("maxAge", 65);
fetch("/take-age-range", {
  method: "POST",
  body: formData
});

// When the user moves the slider, update the slider value and submit the form
minAgeSlider.oninput = function() {
  if (parseInt(this.value) >= parseInt(maxAgeSlider.value)) {
    this.value = maxAgeSlider.value;
  }
  minAgeOutput.innerHTML = this.value;
  submitForm();
}

// Ensure that the max slider is not moved to the left of the min slider
maxAgeSlider.oninput = function() {
  if (parseInt(this.value) <= parseInt(minAgeSlider.value)) {
    this.value = minAgeSlider.value;
  }
  maxAgeOutput.innerHTML = this.value;
  submitForm();
}

function submitForm() {
  var formData = new FormData();
  formData.append("minAge", minAgeSlider.value);
  formData.append("maxAge", maxAgeSlider.value);
  fetch("/take-age-range", {
    method: "POST",
    body: formData
  });
}
});