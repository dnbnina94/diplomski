/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    function checkVisible(elm, eval) {
        eval = eval || "object visible";
        var viewportHeight = $(window).height(), // Viewport Height
                scrolltop = $(window).scrollTop(), // Scroll Top
                y = $(elm).offset().top,
                elementHeight = $(elm).height();
        if (eval == "object visible")
            return ((y < (viewportHeight + scrolltop)) && (y > (scrolltop - elementHeight)));
        if (eval == "above")
            return ((y < (viewportHeight + scrolltop)));
    }

    $(window).on('scroll', function () {
        if (checkVisible($('#footer'))) {
            document.getElementById("vest:loadMoreButton").click();
            $(window).off('scroll');
        } else {
        }
    });

});

