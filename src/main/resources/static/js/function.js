// Funkcja odpowiadająca za wybór podkategorii zależnie od wyboru kategorii
function selector() {
    var category = document.getElementById("options").value;
    var business = document.getElementById("selected")
    var other = document.getElementById("other")
    if (category === "służbowy") {
        business.removeAttribute("disabled");
        other.disabled = true;
    }
    else if (category === "prywatny") {
        business.disabled = true;
        other.disabled = true;
    }
    else if (category === "inny") {
        other.removeAttribute("disabled");
        business.disabled = true;
    }
}
// Funkcja odpowiadająca za sprawdzenie poprawności bezpieczeństwa wpisanego hasła przy rejestracji
function checkPassword(event) {
    var pass = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
    var input = document.getElementById("pass").value;
    if (!input.match(pass)) {
        alert('Hasło musi zawierac minimum 8 znaków, w tym minimum 1 literę oraz cyfrę.')
        event.preventDefault();
    }
}
// Funkcja pokazująca/ukrywająca szczegóły elementu
function toggleVisibility(hide) {
    var e = document.getElementsByClassName(hide);
    for (var i = 0; i < e.length; i++) {
        if (e[i].style.display == '')
            e[i].style.display = 'none';
        else
            e[i].style.display = '';
    }
}