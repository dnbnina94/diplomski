/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#input_registracija\\:nazivOrg").keydown(function () {
    var val = $("#input_registracija\\:nazivOrg");
    var greska = "";
    
    if (val === "") {
        greska = "Polje 'Naziv organizacije' ne sme ostati prazno.";
    }
    
    if (greska !== "") {
        $("#input_registracija\\:nazivOrg").style.borderColor = "#DC3545 !important";
    }
});

