/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#input_nov_oglas\\:naslov").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_nov_oglas\\:naslov").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Naslov oglasa' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#input_nov_oglas\\:naslov").addClass("login-form-input-error");
        $("#naslovGreska").removeClass("input-error-message-hidden");
        $("#naslovGreska").html(greska);
    } else {
        $("#input_nov_oglas\\:naslov").removeClass("login-form-input-error");
        $("#naslovGreska").addClass("input-error-message-hidden");
    }
});

quill.on('text-change', function() {
    if (quill.getText().trim().length === 0) {
        $(".ql-container").css({'border-color' : '#DC3545'});
        $("#tekstGreska").removeClass("input-error-message-hidden");
        $("#tekstGreska").html("Polje 'Tekst oglasa' ne sme ostati prazno.");
    } else {
        $(".ql-container").css({'border-color' : '#ddd'});
        $("#tekstGreska").addClass("input-error-message-hidden");
    }
});

$("#nov_oglas\\:datumIsticanja_input").change(function (event) {
    event.stopImmediatePropagation();

    var val = $("#nov_oglas\\:datumIsticanja_input").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Datum isticanja' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#nov_oglas\\:datumIsticanja_input").parent().addClass("custom-datetimepicker-bootsfaces-error");
        $("#datumIsticanjaGreska").removeClass("input-error-message-hidden");
        $("#datumIsticanjaGreska").html(greska);
    } else {
        $("#nov_oglas\\:datumIsticanja_input").parent().removeClass("custom-datetimepicker-bootsfaces-error");
        $("#datumIsticanjaGreska").addClass("input-error-message-hidden");
    }
});

