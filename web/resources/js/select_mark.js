/**
 * Created by andrew on 06.09.16
 */
$(document).ready(
    
   
    function() {
        // window.location.pathname = '/usedSearchByBean';
        // window.location.search = 'mark=' + $(this).val();
       
        

       $('#first-choice').ready(function() {
           // window.location.pathname = '/usedSearchByBean';
           // window.location.search = 'mark=' + $(this).val();

           $.getJSON('loadModels', {
               mark : $(this).val(),
               ajax : 'true'
           }, function(data) {

               var html = '<option selected value="null">All</option>';
               var len = data.length;

               for ( var i = 0; i < len; i++) {
                   html += '<option value="' + data[i].modelName + '">' + data[i].modelName + '</option>';

               }
               html += '</option>';

               $('#second-choice').html(html);
           });});

        $('#first-choice').change(
            function() {
                // window.location.pathname = '/usedSearchByBean';
                // window.location.search = 'mark=' + $(this).val();

                $.getJSON('loadModels', {
                    mark : $(this).val(),
                    ajax : 'true'
                }, function(data) {

                    var html = '<option selected value="null">All</option>';
                    var len = data.length;

                    for ( var i = 0; i < len; i++) {
                        html += '<option value="' + data[i].modelName + '">' + data[i].modelName + '</option>';

                    }
                    html += '</option>';

                    $('#second-choice').html(html);
                });
            });

    });


