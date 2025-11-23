"use strict";

const usernameInput = document.getElementById("username");
const passwordInput = document.getElementById("password");
const submitButton = document.querySelector("input[type=submit]");

usernameInput.addEventListener("input", (event) => {
    if (usernameInput.validity.patternMismatch) {
        usernameInput.setCustomValidity("Username must be between 4 and 25 characters.")
    } else {
        usernameInput.setCustomValidity("");
    }
    usernameInput.reportValidity();
    usernameInput.focus();
});

passwordInput.addEventListener("input", (event) => {
    if (passwordInput.validity.patternMismatch) {
        passwordInput.setCustomValidity("Password must be at least 12 characters long.");
    } else {
        passwordInput.setCustomValidity("");
    }
    passwordInput.reportValidity();
    passwordInput.focus();
});

usernameInput.focus();