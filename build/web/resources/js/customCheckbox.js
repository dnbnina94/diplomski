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
    
    $(".custom-radiobutton-bootsfaces > label > input").change(function (event) {
        var parent = $(this).parent().parent().parent();
        
        $(".custom-radiobutton").removeClass("custom-radiobutton-checked");
        $(".custom-radiobutton").addClass("custom-radiobutton-unchecked");
        
        parent.removeClass("custom-radiobutton-unchecked");
        parent.addClass("custom-radiobutton-checked");
    });
    
});
