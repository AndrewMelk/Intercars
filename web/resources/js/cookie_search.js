//checks if the cookie has been set
$(document).ready(
    function () {
        
    
if($.cookie('mark') != null) {

    // set the option to selected that corresponds to what the cookie is set to

    $('#first-choice option[value="' + $.cookie('mark') + '"]').attr('selected', 'selected');

}

// when a new option is selected this is triggered

$('#first-choice').change(function() {

    // new cookie is set when the option is changed

    $.cookie('mark', $('#first-choice option:selected').val(), {path: '/getList'});

});
    });
