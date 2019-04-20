/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $(".custom-checkbox-bootsfaces").change(function (event) {
        var labelParent = $(this).parent().parent().parent().parent();

        if ($(this).is(':checked')) {
            labelParent.removeClass("custom-checkbox-unchecked");
            labelParent.addClass("custom-checkbox-checked");
        } else {
            labelParent.removeClass("custom-checkbox-checked");
            labelParent.addClass("custom-checkbox-unchecked");
        }
    });

    $(".custom-radiobutton").click(function (event) {
        var idPitanje = $(this).attr("idPitanje");
        var indexOdgovor = $(this).attr("indexOdgovor");

        $("[idPitanje=" + idPitanje + "]").removeClass("custom-radiobutton-checked");
        $("[idPitanje=" + idPitanje + "]").addClass("custom-radiobutton-unchecked");

        $(".pitanje"+idPitanje + " > tbody > tr > td").each(function (i, obj) {
            if (indexOdgovor == i) {
                var child = $(this).find("input");
                $(child).prop('checked', true);
            }
        });

        $(this).removeClass("custom-radiobutton-unchecked");
        $(this).addClass("custom-radiobutton-checked");
    });

});
