/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $.datepicker.regional['rs'] = {
        monthNames: ['Januar', 'Februar', 'Mart', 'April', 'Maj', 'Jun',
            'Jul', 'Avgust', 'Septembar', 'Oktobar', 'Novembar', 'Decembar'],
        monthNamesShort: ['Jan', 'Feb', 'Mar', 'Apr', 'Mai', 'Jun',
            'Jul', 'Avg', 'Sep', 'Okt', 'Nov', 'Dec'],
        dayNames: ['Nedelja', 'Ponedeljak', 'Utorak', 'Sreda', 'Četvrtak', 'Petak', 'Subota'],
        dayNamesShort: ['Ned', 'Pon', 'Uto', 'Sre', 'Čet', 'Pet', 'Sub'],
        dayNamesMin: ['Ned', 'Pon', 'Uto', 'Sre', 'Čet', 'Pet', 'Sub'],
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false/*,
        minDate: 0*/
    };

    $.datepicker.setDefaults($.datepicker.regional['rs']);
    
    /*var dates = $("#von, #bis").datepicker({
        showOn: "button",
        buttonImage: "calendar.png",
        buttonImageOnly: true,
        buttonText: 'Datum w\u00E4hlen',
        onSelect: function (selectedDate) {
            var option = this.id == "#von" ? "minDate" : "maxDate",
                    instance = $(this).data("datepicker"),
                    date = $.datepicker.parseDate(
                            instance.settings.dateFormat ||
                            $.datepicker._defaults.dateFormat,
                            selectedDate, instance.settings);
            dates.not(this).datepicker("option", option, date);
        }
    });*/

});
