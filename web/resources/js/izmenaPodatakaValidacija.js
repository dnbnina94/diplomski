/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('[data-toggle="tooltip"]').tooltip();

$("#input_izmena_podataka\\:nazivOrg").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_izmena_podataka\\:nazivOrg").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Naziv organizacije' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#input_izmena_podataka\\:nazivOrg").addClass("login-form-input-error");
        $("#nazivOrgGreska").removeClass("input-error-message-hidden");
        $("#nazivOrgGreska").html(greska);
        $("#izmena_podataka\\:saveButtonNazivOrg").css("margin-top", "0px");
    } else {
        $("#input_izmena_podataka\\:nazivOrg").removeClass("login-form-input-error");
        $("#nazivOrgGreska").addClass("input-error-message-hidden");
        $("#izmena_podataka\\:saveButtonNazivOrg").css("margin-top", "-5px");
    }
});

$("#input_izmena_podataka\\:opisOrg").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_izmena_podataka\\:opisOrg").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Opis organizacije' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#input_izmena_podataka\\:opisOrg").addClass("custom-textarea-error");
        $("#opisOrgGreska").removeClass("input-error-message-hidden");
        $("#opisOrgGreska").html(greska);
    } else {
        $("#input_izmena_podataka\\:opisOrg").removeClass("custom-textarea-error");
        $("#opisOrgGreska").addClass("input-error-message-hidden");
    }
});

$("#input_izmena_podataka\\:oblastDelovanja").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_izmena_podataka\\:oblastDelovanja").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Oblast delovanja' ne sme ostati prazno.";
    } else {
        if (!/^[a-zA-ZčćšđžČĆŠĐŽ ]+$/.test(val)) {
            greska = "Polje 'Oblast delovanja' ne sme sadržati numerike i specijalne karaktere.";
        }
    }

    if (greska !== "") {
        $("#input_izmena_podataka\\:oblastDelovanja").addClass("login-form-input-error");
        $("#oblastDelovanjaGreska").removeClass("input-error-message-hidden");
        $("#oblastDelovanjaGreska").html(greska);
    } else {
        $("#input_izmena_podataka\\:oblastDelovanja").removeClass("login-form-input-error");
        $("#oblastDelovanjaGreska").addClass("input-error-message-hidden");
    }
});

/*$("#input_registracija\\:webStranica").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_registracija\\:webStranica").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Web stranica organizacije' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#input_registracija\\:webStranica").addClass("login-form-input-error");
        $("#webStranicaGreska").removeClass("input-error-message-hidden");
        $("#webStranicaGreska").html(greska);
    } else {
        $("#input_registracija\\:webStranica").removeClass("login-form-input-error");
        $("#webStranicaGreska").addClass("input-error-message-hidden");
    }
});*/

$("#input_izmena_podataka\\:mestoOrg").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_izmena_podataka\\:mestoOrg").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Mesto' ne sme ostati prazno.";
    } else {
        if (!/^[a-zA-ZčćšđžČĆŠĐŽ ]+$/.test(val)) {
            greska = "Polje 'Mesto' ne sme sadržati numerike i specijalne karaktere.";
        }
    }

    if (greska !== "") {
        $("#input_izmena_podataka\\:mestoOrg").addClass("login-form-input-error");
        $("#mestoGreska").removeClass("input-error-message-hidden");
        $("#mestoGreska").html(greska);
    } else {
        $("#input_izmena_podataka\\:mestoOrg").removeClass("login-form-input-error");
        $("#mestoGreska").addClass("input-error-message-hidden");
    }
});

$("#input_izmena_podataka\\:ulicaOrg").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_izmena_podataka\\:ulicaOrg").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Ulica' ne sme ostati prazno.";
    } else {
        if (!/^[a-zA-zčćšđžČĆŠĐŽ0-9 ]+$/.test(val)) {
            greska = "Polje 'Ulica' sme sadržati samo slova i numeričke karaktere.";
        }
    }

    if (greska !== "") {
        $("#input_izmena_podataka\\:ulicaOrg").addClass("login-form-input-error");
        $("#ulicaGreska").removeClass("input-error-message-hidden");
        $("#ulicaGreska").html(greska);
    } else {
        $("#input_izmena_podataka\\:ulicaOrg").removeClass("login-form-input-error");
        $("#ulicaGreska").addClass("input-error-message-hidden");
    }
});

$("#input_izmena_podataka\\:kontaktOsoba").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_izmena_podataka\\:kontaktOsoba").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Kontakt osoba' ne sme ostati prazno.";
    } else {
        if (!/^[a-zA-ZčćšđžČĆŠĐŽ ]+$/.test(val)) {
            greska = "Polje 'Kontakt osoba' ne sme sadržati numerike i specijalne karaktere.";
        }
    }

    if (greska !== "") {
        $("#input_izmena_podataka\\:kontaktOsoba").addClass("login-form-input-error");
        $("#kontaktOsobaGreska").removeClass("input-error-message-hidden");
        $("#kontaktOsobaGreska").html(greska);
    } else {
        $("#input_izmena_podataka\\:kontaktOsoba").removeClass("login-form-input-error");
        $("#kontaktOsobaGreska").addClass("input-error-message-hidden");
    }
});

$("#input_izmena_podataka\\:email").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_izmena_podataka\\:email").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Email adresa' ne sme ostati prazno.";
    } else {
        var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        if (!pattern.test(val)) {
            greska = "Email adresa koju ste uneli ne odgovara email formatu.";
        }
    }

    if (greska !== "") {
        $("#input_izmena_podataka\\:email").addClass("login-form-input-error");
        $("#emailGreska").removeClass("input-error-message-hidden");
        $("#emailGreska").html(greska);
    } else {
        $("#input_izmena_podataka\\:email").removeClass("login-form-input-error");
        $("#emailGreska").addClass("input-error-message-hidden");
    }
});

$("#input_izmena_podataka\\:korIme").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_izmena_podataka\\:korIme").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Korisničko ime' ne sme ostati prazno.";
    } else {
        if (/\s/.test(val)) {
            greska = "Korisničko ime ne sme sadržati blanko karaktere.";
        }
    }

    if (greska !== "") {
        $("#input_izmena_podataka\\:korIme").addClass("login-form-input-error");
        $("#korImeGreska").removeClass("input-error-message-hidden");
        $("#korImeGreska").html(greska);
    } else {
        $("#input_izmena_podataka\\:korIme").removeClass("login-form-input-error");
        $("#korImeGreska").addClass("input-error-message-hidden");
    }
});

$("#input_izmena_podataka\\:staraLozinka").keyup(function (event) {
    event.stopImmediatePropagation();
    
    var val = $("#input_izmena_podataka\\:staraLozinka").val();
    var greska = "";
    
    if (val === "") {
        greska = "Polje 'Stara lozinka' ne sme ostati prazno.";
    }
    
    if (greska !== "") {
        $("#input_izmena_podataka\\:staraLozinka").addClass("login-form-input-error");
        $("#staraLozinkaGreska").removeClass("input-error-message-hidden");
        $("#staraLozinkaGreska").html(greska);
    } else {
        $("#input_izmena_podataka\\:staraLozinka").removeClass("login-form-input-error");
        $("#staraLozinkaGreska").addClass("input-error-message-hidden");
    }
});

$("#input_izmena_podataka\\:novaLozinka").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_izmena_podataka\\:novaLozinka").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Nova lozinka' ne sme ostati prazno.";
    } else {
        if (/\s/.test(val)) {
            greska = "Nova lozinka ne sme sadržati blanko karaktere.";
        } else {
            if (val.length < 8) {
                greska = "Nova lozinka mora biti minimalne dužine od 8 karaktera.";
            } else {
                if (!/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*(_|[^\w])).+$/.test(val)) {
                    greska = "Nova lozinka mora sadržati makar jedno veliko slovo, makar 1 malo slovo, makar jedan numerik i makar jedan specijalan karakter.";
                } else {
                    var ponovljenaLozinka = $("#input_izmena_podataka\\:ponovljenaNovaLozinka").val();
                    if (ponovljenaLozinka !== val) {
                        $("#input_izmena_podataka\\:ponovljenaNovaLozinka").addClass("login-form-input-error");
                        $("#ponovljenaNovaLozinkaGreska").removeClass("input-error-message-hidden");
                        $("#ponovljenaNovaLozinkaGreska").html("Lozinka i ponovljena lozinka se ne poklapaju.");
                    } else {
                        $("#input_izmena_podataka\\:ponovljenaNovaLozinka").removeClass("login-form-input-error");
                        $("#ponovljenaNovaLozinkaGreska").addClass("input-error-message-hidden");
                    }
                }
            }
        }
    }

    if (greska !== "") {
        $("#input_izmena_podataka\\:novaLozinka").addClass("login-form-input-error");
        $("#novaLozinkaGreska").removeClass("input-error-message-hidden");
        $("#novaLozinkaGreska").html(greska);
    } else {
        $("#input_izmena_podataka\\:novaLozinka").removeClass("login-form-input-error");
        $("#novaLozinkaGreska").addClass("input-error-message-hidden");
    }
});

$("#input_izmena_podataka\\:ponovljenaNovaLozinka").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_izmena_podataka\\:ponovljenaNovaLozinka").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Ponovljena nova lozinka' ne sme ostati prazno.";
    } else {
        var lozinka = $("#input_izmena_podataka\\:novaLozinka").val();
        if (lozinka !== val) {
            greska = "Nova lozinka i ponovljena nova lozinka se ne poklapaju.";
        }
    }

    if (greska !== "") {
        $("#input_izmena_podataka\\:ponovljenaNovaLozinka").addClass("login-form-input-error");
        $("#ponovljenaNovaLozinkaGreska").removeClass("input-error-message-hidden");
        $("#ponovljenaNovaLozinkaGreska").html(greska);
    } else {
        $("#input_izmena_podataka\\:ponovljenaNovaLozinka").removeClass("login-form-input-error");
        $("#ponovljenaNovaLozinkaGreska").addClass("input-error-message-hidden");
    }
});

$("#input_izmena_podataka\\:telefon").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_izmena_podataka\\:telefon").val();
    var greska = "";

    if (!/^[0-9]+$/.test(val) && val !== "") {
        greska = "Telefon mora sadržati između 7 i 15 numeričkih karaktera.";
    }

    if (greska !== "") {
        $("#input_izmena_podataka\\:telefon").addClass("login-form-input-error");
        $("#telefonGreska").removeClass("input-error-message-hidden");
        $("#telefonGreska").html(greska);
        $("#izmena_podataka\\:plusButton").css("margin-top", "0px");
    } else {
        $("#input_izmena_podataka\\:telefon").removeClass("login-form-input-error");
        $("#telefonGreska").addClass("input-error-message-hidden");
        $("#izmena_podataka\\:plusButton").css("margin-top", "-5px");
    }
});

function editField(fieldToEdit) {
    var fieldWrapper = "#fieldWrapper" + fieldToEdit;
    var infoWrapper = "#infoWrapper" + fieldToEdit;
    
    $(fieldWrapper).css("display", "table-row");
    $(infoWrapper).css("display", "none");
}

function closeField(fieldToEdit) {
    var infoWrapper = "#infoWrapper" + fieldToEdit;
    var fieldWrapper = "#fieldWrapper" + fieldToEdit;
    
    $(infoWrapper).css("display", "table-row");
    $(fieldWrapper).css("display", "none");
}

function saveField(fieldToEdit) {
    var greska = $("#izmena_podataka\\:nazivOrgGreskaVal").val();
    alert(greska);
}

/*$("#izmena_podataka\\:cancelEditButtonOpisOrg").click(function(event) {
    event.stopImmediatePropagation();
    
    $("#infoWrapperOpisOrg").css("display", "table-row");
    $("#fieldWrapperOpisOrg").css("display", "none");
});

$("#izmena_podataka\\:cancelEditButtonOblastDelovanja").click(function(event) {
    event.stopImmediatePropagation();
    
    $("#infoWrapperOblastDelovanja").css("display", "table-row");
    $("#fieldWrapperOblastDelovanja").css("display", "none");
});

$("#izmena_podataka\\:cancelEditButtonWebAdresa").click(function(event) {
    event.stopImmediatePropagation();
    
    $("#infoWrapperWebAdresa").css("display", "table-row");
    $("#fieldWrapperWebAdresa").css("display", "none");
});

$("#izmena_podataka\\:cancelEditButtonKontaktOsoba").click(function(event) {
    event.stopImmediatePropagation();
    
    $("#infoWrapperKontaktOsoba").css("display", "table-row");
    $("#fieldWrapperKontaktOsoba").css("display", "none");
});

$("#izmena_podataka\\:cancelEditButtonEmail").click(function(event) {
    event.stopImmediatePropagation();
    
    $("#infoWrapperEmail").css("display", "table-row");
    $("#fieldWrapperEmail").css("display", "none");
});

$("#izmena_podataka\\:cancelEditButtonMestoUlica").click(function(event) {
    event.stopImmediatePropagation();
    
    $("#infoWrapperMestoUlica").css("display", "table-row");
    $("#fieldWrapperMestoUlica").css("display", "none");
});

$("#izmena_podataka\\:cancelEditButtonTelefoni").click(function(event) {
    event.stopImmediatePropagation();
    
    $("#infoWrapperTelefoni").css("display", "table-row");
    $("#fieldWrapperTelefoni").css("display", "none");
});*/


