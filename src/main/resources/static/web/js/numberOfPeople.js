document.addEventListener("DOMContentLoaded", function() {
  var input = document.getElementById("numberOfPeople");

  // Send a POST request with the default value of 100 when the page loads
  var formData = new FormData();
  formData.append("numberOfPeople", input.value);
  fetch("/take-row", {
    method: "POST",
    body: formData
  });

  input.addEventListener("input", function() {
    var formData = new FormData();
    formData.append("numberOfPeople", this.value);
    fetch("/take-row", {
      method: "POST",
      body: formData
    });
  });
});
