/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#input_nov_dogadjaj\\:naslov").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_nov_dogadjaj\\:naslov").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Naslov događaja' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#input_nov_dogadjaj\\:naslov").addClass("login-form-input-error");
        $("#naslovGreska").removeClass("input-error-message-hidden");
        $("#naslovGreska").html(greska);
    } else {
        $("#input_nov_dogadjaj\\:naslov").removeClass("login-form-input-error");
        $("#naslovGreska").addClass("input-error-message-hidden");
    }
});

$("#nov_dogadjaj\\:kategorijaInner").change(function () {

    var val = $("#nov_dogadjaj\\:kategorijaInner").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Kategorija događaja' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#nov_dogadjaj\\:kategorija").css({'border': '1px solid #DC3545'});
        $("#kategorijaGreska").removeClass("input-error-message-hidden");
        $("#kategorijaGreska").html(greska);
    } else {
        $("#nov_dogadjaj\\:kategorija").css({'border': 'none'});
        $("#kategorijaGreska").addClass("input-error-message-hidden");
    }
});

quill.on('text-change', function () {
    if (quill.getText().trim().length === 0) {
        $(".ql-container").css({'border-color': '#DC3545'});
        $("#tekstGreska").removeClass("input-error-message-hidden");
        $("#tekstGreska").html("Polje 'Tekst događaja' ne sme ostati prazno.");
    } else {
        $(".ql-container").css({'border-color': '#ddd'});
        $("#tekstGreska").addClass("input-error-message-hidden");
    }
});

$("#input_nov_dogadjaj\\:mesto").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_nov_dogadjaj\\:mesto").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Mesto' ne sme ostati prazno.";
    } else {
        if (!/^[a-zA-ZčćšđžČĆŠĐŽ ]+$/.test(val)) {
            greska = "Polje 'Mesto' ne sme sadržati numerike i specijalne karaktere.";
        }
    }

    if (greska !== "") {
        $("#input_nov_dogadjaj\\:mesto").addClass("login-form-input-error");
        $("#mestoGreska").removeClass("input-error-message-hidden");
        $("#mestoGreska").html(greska);
    } else {
        $("#input_nov_dogadjaj\\:mesto").removeClass("login-form-input-error");
        $("#mestoGreska").addClass("input-error-message-hidden");
    }
});

$("#input_nov_dogadjaj\\:ulica").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_nov_dogadjaj\\:ulica").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Ulica' ne sme ostati prazno.";
    } else {
        if (!/^[a-zA-zčćšđžČĆŠĐŽ0-9 ]+$/.test(val)) {
            greska = "Polje 'Ulica' sme sadržati samo slova i numeričke karaktere.";
        }
    }

    if (greska !== "") {
        $("#input_nov_dogadjaj\\:ulica").addClass("login-form-input-error");
        $("#ulicaGreska").removeClass("input-error-message-hidden");
        $("#ulicaGreska").html(greska);
    } else {
        $("#input_nov_dogadjaj\\:ulica").removeClass("login-form-input-error");
        $("#ulicaGreska").addClass("input-error-message-hidden");
    }
});

$("#nov_dogadjaj\\:datumPocetka_input").change(function (event) {
    event.stopImmediatePropagation();

    var val = $("#nov_dogadjaj\\:datumPocetka_input").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Datum početka' ne sme ostati prazno.";
    }
    if (!Date.parse(val)) {
        greska = "Polje 'Datum početka' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#nov_dogadjaj\\:datumPocetka_input").parent().addClass("custom-datetimepicker-bootsfaces-error");
        $("#datumPocetkaGreska").removeClass("input-error-message-hidden");
        $("#datumPocetkaGreska").html(greska);
        /*var datumIVremePocetkaGreskaVal = $("#nov_dogadjaj\\:datumIVremePocetkaGreskaVal").html();
         //console.log("Datum pocetka validacija: " + datumIVremePocetkaGreskaVal.length);
         if (typeof datumIVremePocetkaGreskaVal !== 'undefined') {
         if (datumIVremePocetkaGreskaVal.length) {*/
        if (!$("#datumIVremePocetkaGreska").hasClass("input-error-message-hidden")) {
            $("#datumIVremePocetkaGreska").addClass("input-error-message-hidden");
            $("#nov_dogadjaj\\:vremePocetka").removeClass("custom-datetimepicker-bootsfaces-error");
            $("#vremePocetkaGreska").addClass("input-error-message-hidden");
        }
        /*}
         }*/
    } else {
        $("#datumIVremePocetkaGreska").addClass("input-error-message-hidden");
        $("#nov_dogadjaj\\:datumPocetka_input").parent().removeClass("custom-datetimepicker-bootsfaces-error");
        $("#datumPocetkaGreska").addClass("input-error-message-hidden");
    }
});

function vremePocetkaChange() {
    var val = $("#nov_dogadjaj\\:vremePocetka_Input").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Vreme početka' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#nov_dogadjaj\\:vremePocetka").addClass("custom-datetimepicker-bootsfaces-error");
        $("#vremePocetkaGreska").removeClass("input-error-message-hidden");
        $("#vremePocetkaGreska").html(greska);
        /*var datumIVremePocetkaGreskaVal = $("#nov_dogadjaj\\:datumIVremePocetkaGreskaVal").html();
         //console.log("Vreme pocetka validacija: " + datumIVremePocetkaGreskaVal.length);
         if (typeof datumIVremePocetkaGreskaVal !== 'undefined') {
         if (datumIVremePocetkaGreskaVal.length) {*/
        if (!$("#datumIVremePocetkaGreska").hasClass("input-error-message-hidden")) {
            $("#datumIVremePocetkaGreska").addClass("input-error-message-hidden");
            $("#nov_dogadjaj\\:datumPocetka_input").parent().removeClass("custom-datetimepicker-bootsfaces-error");
            $("#datumPocetkaGreska").addClass("input-error-message-hidden");
        }
        /*}
         }*/
    } else {
        $("#nov_dogadjaj\\:vremePocetka").removeClass("custom-datetimepicker-bootsfaces-error");
        $("#vremePocetkaGreska").addClass("input-error-message-hidden");
    }
}

$("#nov_dogadjaj\\:vremePocetka").on("dp.change", vremePocetkaChange);
$("#nov_dogadjaj\\:vremePocetka_Input").on("change paste keyup", vremePocetkaChange);

$("#nov_dogadjaj\\:datumKraja_input").change(function (event) {
    event.stopImmediatePropagation();

    var val = $("#nov_dogadjaj\\:datumKraja_input").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Datum kraja' ne sme ostati prazno.";
    }
    if (!Date.parse(val)) {
        greska = "Polje 'Datum kraja' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#nov_dogadjaj\\:datumKraja_input").parent().addClass("custom-datetimepicker-bootsfaces-error");
        $("#datumKrajaGreska").removeClass("input-error-message-hidden");
        $("#datumKrajaGreska").html(greska);
        /*var datumIVremeKrajaGreskaVal = $("#nov_dogadjaj\\:datumIVremeKrajaGreskaVal").html();
         //console.log("Datum pocetka validacija: " + datumIVremePocetkaGreskaVal.length);
         if (typeof datumIVremeKrajaGreskaVal !== 'undefined') {
         if (datumIVremeKrajaGreskaVal.length) {*/
        if (!$("#datumIVremeKrajaGreska").hasClass("input-error-message-hidden")) {
            $("#datumIVremeKrajaGreska").addClass("input-error-message-hidden");
            $("#nov_dogadjaj\\:vremeKraja").removeClass("custom-datetimepicker-bootsfaces-error");
            $("#vremeKrajaGreska").addClass("input-error-message-hidden");
        }
        /*}
         }*/
    } else {
        $("#datumIVremeKrajaGreska").addClass("input-error-message-hidden");
        $("#nov_dogadjaj\\:datumKraja_input").parent().removeClass("custom-datetimepicker-bootsfaces-error");
        $("#datumKrajaGreska").addClass("input-error-message-hidden");
    }
});

function vremeKrajaChange() {
    var val = $("#nov_dogadjaj\\:vremeKraja_Input").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Vreme kraja' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#nov_dogadjaj\\:vremeKraja").addClass("custom-datetimepicker-bootsfaces-error");
        $("#vremeKrajaGreska").removeClass("input-error-message-hidden");
        $("#vremeKrajaGreska").html(greska);
        /*var datumIVremeKrajaGreskaVal = $("#nov_dogadjaj\\:datumIVremeKrajaGreskaVal").html();
         //console.log("Vreme pocetka validacija: " + datumIVremePocetkaGreskaVal.length);
         if (typeof datumIVremeKrajaGreskaVal !== 'undefined') {
         if (datumIVremeKrajaGreskaVal.length) {*/
        if (!$("#datumIVremeKrajaGreska").hasClass("input-error-message-hidden")) {
            $("#datumIVremeKrajaGreska").addClass("input-error-message-hidden");
            $("#nov_dogadjaj\\:datumKraja_input").parent().removeClass("custom-datetimepicker-bootsfaces-error");
            $("#datumKrajaGreska").addClass("input-error-message-hidden");
        }
        /*}
         }*/
    } else {
        $("#nov_dogadjaj\\:vremeKraja").removeClass("custom-datetimepicker-bootsfaces-error");
        $("#vremeKrajaGreska").addClass("input-error-message-hidden");
    }
}

$("#nov_dogadjaj\\:vremeKraja").on("dp.change", vremeKrajaChange);
$("#nov_dogadjaj\\:vremeKraja_Input").on("change paste keyup", vremeKrajaChange);

$("#nov_dogadjaj\\:uzrastInner").change(function () {

    var val = $("#nov_dogadjaj\\:uzrastInner").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Uzrast' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#nov_dogadjaj\\:uzrast").css({'border': '1px solid #DC3545'});
        $("#uzrastGreska").removeClass("input-error-message-hidden");
        $("#uzrastGreska").html(greska);
    } else {
        $("#nov_dogadjaj\\:uzrast").css({'border': 'none'});
        $("#uzrastGreska").addClass("input-error-message-hidden");
    }
});

$("#nov_dogadjaj\\:karakteristikaProstoraInner").change(function () {

    $("#nov_dogadjaj\\:karakteristikaProstora").css({'border': 'none'});
    $("#karakteristikeProstoraGreska").addClass("input-error-message-hidden");
});
