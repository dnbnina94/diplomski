/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#input_kreiranje_izvestaja\\:naziv").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_kreiranje_izvestaja\\:naziv").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Naziv izveštaja' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#input_kreiranje_izvestaja\\:naziv").addClass("login-form-input-error");
        $("#nazivGreska").removeClass("input-error-message-hidden");
        $("#nazivGreska").html(greska);
    } else {
        $("#input_kreiranje_izvestaja\\:naziv").removeClass("login-form-input-error");
        $("#nazivGreska").addClass("input-error-message-hidden");
    }
});

$("#kreiranje_izvestaja\\:datumPocetka_input").change(function (event) {
    event.stopImmediatePropagation();

    var val = $("#kreiranje_izvestaja\\:datumPocetka_input").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Početak perioda' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#kreiranje_izvestaja\\:datumPocetka_input").parent().addClass("custom-datetimepicker-bootsfaces-error");
        $("#datumPocetkaGreska").removeClass("input-error-message-hidden");
        $("#datumPocetkaGreska").html(greska);
    } else {
        $("#kreiranje_izvestaja\\:datumPocetka_input").parent().removeClass("custom-datetimepicker-bootsfaces-error");
        $("#datumPocetkaGreska").addClass("input-error-message-hidden");
    }
});

$("#kreiranje_izvestaja\\:datumKraja_input").change(function (event) {
    event.stopImmediatePropagation();

    var val = $("#kreiranje_izvestaja\\:datumKraja_input").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Kraj perioda' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#kreiranje_izvestaja\\:datumKraja_input").parent().addClass("custom-datetimepicker-bootsfaces-error");
        $("#datumKrajaGreska").removeClass("input-error-message-hidden");
        $("#datumKrajaGreska").html(greska);
    } else {
        $("#kreiranje_izvestaja\\:datumKraja_input").parent().removeClass("custom-datetimepicker-bootsfaces-error");
        $("#datumKrajaGreska").addClass("input-error-message-hidden");
    }
});

$(".checkbox-izvestaj").change(function (event) {

    var checkBoxes = document.getElementsByClassName("checkbox-izvestaj");
    for (var i = 0; i < checkBoxes.length; i++) {
        if (checkBoxes[i].checked) {
            $("#sifarniciIzvestajGreska").addClass("input-error-message-hidden");
            $("#sifarniciIzvestaj").removeClass("error");
            return;
        }
    }
    $("#sifarniciIzvestajGreska").removeClass("input-error-message-hidden");
    $("#sifarniciIzvestajGreska").html("Morate štiklirati makar jednu stavku izveštaja.");
    $("#sifarniciIzvestaj").addClass("error");

});


