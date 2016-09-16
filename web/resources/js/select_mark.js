/**
 * Created by andrew on 06.09.16.
 */
$(document).ready(
    function() {

        $('#first-choice').change(
            function() {

                $.getJSON('loadModels', {
                    mark : $(this).val(),
                    ajax : 'true'
                }, function(data) {

                    var html = '<option value="">----Select State----</option>';
                    var len = data.length;

                    for ( var i = 0; i < len; i++) {
                        html += '<option value="' + data[i].modelName + '">' + data[i].modelName + '</option>';

                    }
                    html += '</option>';

                    $('#second-choice').html(html);
                });
            });

    });