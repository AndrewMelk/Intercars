/**
 * Created by andrew on 28.09.16.
 */
$(document).ready(

    function() {
        
        $('#region').change(
            function() {

                $.getJSON('loadCity', {
                    id : $(this).val(),
                    ajax : 'true'
                }, function(data) {

                    var html = '<option selected value="NULL">All</option>';
                    var len = data.length;

                    for ( var i = 0; i < len; i++) {
                        html += '<option value="' + data[i].name + '">' + data[i].name + '</option>';

                    }
                    html += '</option>';

                    $('#city').html(html);
                });
            });
        

});

    
    



    