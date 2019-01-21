/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#input_nova_vest\\:naslov").keyup(function (event) {
    event.stopImmediatePropagation();

    var val = $("#input_nova_vest\\:naslov").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Naslov vesti' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#input_nova_vest\\:naslov").addClass("login-form-input-error");
        $("#naslovGreska").removeClass("input-error-message-hidden");
        $("#naslovGreska").html(greska);
    } else {
        $("#input_nova_vest\\:naslov").removeClass("login-form-input-error");
        $("#naslovGreska").addClass("input-error-message-hidden");
    }
});

$("#nova_vest\\:kategorijaInner").change(function () {

    var val = $("#nova_vest\\:kategorijaInner").val();
    var greska = "";

    if (val === "") {
        greska = "Polje 'Kategorija vesti' ne sme ostati prazno.";
    }

    if (greska !== "") {
        $("#nova_vest\\:kategorija").css({'border' : '1px solid #DC3545'});
        $("#kategorijaGreska").removeClass("input-error-message-hidden");
        $("#kategorijaGreska").html(greska);
    } else {
        $("#nova_vest\\:kategorija").css({'border' : 'none'});
        $("#kategorijaGreska").addClass("input-error-message-hidden");
    }
});

quill.on('text-change', function() {
    if (quill.getText().trim().length === 0) {
        $(".ql-container").css({'border-color' : '#DC3545'});
        $("#tekstGreska").removeClass("input-error-message-hidden");
        $("#tekstGreska").html("Polje 'Tekst vesti' ne sme ostati prazno.");
    } else {
        $(".ql-container").css({'border-color' : '#ddd'});
        $("#tekstGreska").addClass("input-error-message-hidden");
    }
});

