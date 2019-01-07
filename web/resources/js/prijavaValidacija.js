/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#input_prijava\\:korIme").keyup(function (event) {
    event.stopImmediatePropagation();
    
    var val = $("#input_prijava\\:korIme").val();
    var greska = "";
    
    if (val === "") {
        greska = "Polje 'Korisničko ime' ne sme ostati prazno.";
    }
    
    if (greska !== "") {
        $("#input_prijava\\:korIme").addClass("login-form-input-error");
        $("#korImeGreska").removeClass("input-error-message-hidden");
        $("#korImeGreska").html(greska);
    } else {
        $("#input_prijava\\:korIme").removeClass("login-form-input-error");
        $("#korImeGreska").addClass("input-error-message-hidden");
    }
});

$("#input_prijava\\:lozinka").keyup(function (event) {
    event.stopImmediatePropagation();
    
    var val = $("#input_prijava\\:lozinka").val();
    var greska = "";
    
    if (val === "") {
        greska = "Polje 'Lozinka' ne sme ostati prazno.";
    }
    
    if (greska !== "") {
        $("#input_prijava\\:lozinka").addClass("login-form-input-error");
        $("#lozinkaGreska").removeClass("input-error-message-hidden");
        $("#lozinkaGreska").html(greska);
    } else {
        $("#input_prijava\\:lozinka").removeClass("login-form-input-error");
        $("#lozinkaGreska").addClass("input-error-message-hidden");
    }
});
