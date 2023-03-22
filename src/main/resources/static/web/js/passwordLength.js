document.addEventListener("DOMContentLoaded", function() {
  var slider = document.getElementById("passwordLength");
  var output = document.getElementById("passwordLengthValue");
  output.innerHTML = slider.value;

  // Send a POST request with the default value of 8 when the page loads
  var formData = new FormData();
  formData.append("passwordLength", 8);
  fetch("/take-password", {
    method: "POST",
    body: formData
  });

  slider.oninput = function() {
    output.innerHTML = this.value;
    var formData = new FormData();
    formData.append("passwordLength", this.value);
    fetch("/take-password", {
      method: "POST",
      body: formData
    });
  }
});
