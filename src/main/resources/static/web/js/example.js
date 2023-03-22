document.addEventListener("DOMContentLoaded", function() {
  fetchData();
  document.getElementById("regenerate-btn").addEventListener("click", function() {
    fetchData();
  });
});

function fetchData() {

fetch("/name")
    .then(response => response.text())
    .then(name => {
        document.getElementById("name").textContent = name;
        return fetch("/surname");
    })
    .then(response => response.text())
    .then(surname => {
        document.getElementById("surname").textContent = surname;
        return fetch("/tcno");
    })
    .then(response => response.text())
    .then(tcno => {
        document.getElementById("tcno").textContent = tcno;
        return fetch("/age");
    })
    .then(response => response.text())
    .then(age => {
        document.getElementById("age").textContent = age;
        return fetch(`/email?name=${document.getElementById("name").textContent}&surname=${document.getElementById("surname").textContent}&age=${age}`);
    })
    .then(response => response.text())
    .then(email => {
        document.getElementById("email").textContent = email;
        return fetch(`/password`);
    })
    .then(response => response.text())
    .then(password => {
        document.getElementById("password").textContent = password;
        return fetch(`/dateOfBirth?age=${document.getElementById("age").textContent}`);
    })
    .then(response => response.text())
    .then(dateOfBirth => {
        document.getElementById("dateOfBirth").textContent = dateOfBirth;
        return fetch(`/phoneNumber`);
    })
    .then(response => response.text())
    .then(phoneNumber => {
        document.getElementById("phoneNumber").textContent = phoneNumber;
        return fetch(`/city`);
    })
    .then(response => response.text())
    .then(city => {
        document.getElementById("city").textContent = city;
        return fetch(`/citycode`);
     })
        .then(response => response.text())
        .then(citycode => {
        document.getElementById("citycode").textContent = citycode;
        return fetch(`/district?cityCode=${document.getElementById("citycode").textContent}`);
    })
    .then(response => response.text())
    .then(district => {
        document.getElementById("district").textContent = district;
        return fetch(`/neighborhood?cityCode=${document.getElementById("citycode").textContent}&district=${document.getElementById("district").textContent}`);
    })
    .then(response => response.text())
    .then(neighborhood => {
        document.getElementById("neighborhood").textContent = neighborhood;
        return fetch(`/address`);
    })
    .then(response => response.text())
    .then(address => {
        document.getElementById("address").textContent = address;
        return fetch(`/region?city=${document.getElementById("city").textContent}`);
    })
    .then(response => response.text())
    .then(region => {
        document.getElementById("region").textContent = region;
        return fetch(`/gender`);
    })
    .then(response => response.text())
    .then(gender => {

           if (gender === "M") {
                document.getElementById("gender-image").src = "/web/images/Male.png";
              }
             if (gender === "F") {
                           document.getElementById("gender-image").src = "/web/images/Female.png";
                         }
        document.getElementById("gender").textContent = gender;
        return fetch(`/height?age=${document.getElementById("age").textContent}&gender=${document.getElementById("gender").textContent}`);
    })
    .then(response => response.text())
    .then(height => {
        document.getElementById("height").textContent = height;
        return fetch(`/weight?age=${document.getElementById("age").textContent}&gender=${document.getElementById("gender").textContent}`);
    })
    .then(response => response.text())
    .then(weight => {
        document.getElementById("weight").textContent = weight;
    })
    .catch(error => console.error(error));
}