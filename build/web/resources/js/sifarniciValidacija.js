/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#input_sifarnici\\:stavka").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_sifarnici\\:stavka").val();
    var greska = "";

    if (val === "") {
        greska = "Polje ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#input_sifarnici\\:stavka").addClass("login-form-input-error");
        $("#stavkaGreska").removeClass("input-error-message-hidden");
        $("#stavkaGreska").html(greska);
    } else {
        $("#input_sifarnici\\:stavka").removeClass("login-form-input-error");
        $("#stavkaGreska").addClass("input-error-message-hidden");
    }
});

$("#input_sifarnici\\:novaStavka").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_sifarnici\\:novaStavka").val();
    var greska = "";

    if (val === "") {
        greska = "Polje ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#input_sifarnici\\:novaStavka").addClass("login-form-input-error");
        $("#novaStavkaGreska").removeClass("input-error-message-hidden");
        $("#novaStavkaGreska").html(greska);
        $("#sifarnici\\:plusButton").css("margin-top", "0px");
    } else {
        $("#input_sifarnici\\:novaStavka").removeClass("login-form-input-error");
        $("#novaStavkaGreska").addClass("input-error-message-hidden");
        $("#sifarnici\\:plusButton").css("margin-top", "-5px");
    }
});
