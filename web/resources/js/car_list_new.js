/**
 * Created by andrew on 23.09.16.
 */
/**
 * Created by andrew on 06.09.16.
 */
$(document).ready(
    function() {

        $.getJSON('usedBySearchBean', {
            mark : $('#first-choice').val(),
            model : $('#second-choice').val(),
            ajax : 'true'
        }, function(data) {

            var html = '';
            var len = data.length;
            for ( var i = 0; i < len; i++) {
                html +='<div class="col-md-4 portfolio-item">'
                html +='<a href="show_details?id=' + data[i].id + '">'
                html +='<img class="img-responsive" src="http://placehold.it/700x400" alt="">'
                html +='</a>'
                html +='<h3>'
                html +='<a href="#">'+ data[i].name +'</a>'
                html +='</h3>'
                html +='<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>'
                html +='</div>'
                
            }


            $('#items').html(html);
        });
        
        
        $('.sidebar').change(

            function() {


                $.getJSON('usedBySearchBean', {
                    mark : $('#first-choice').val(),
                    model : $('#second-choice').val(),
                    
                    ajax : 'true'
                }, function(data) {

                    var html = '';
                    var len = data.length;

                    for ( var i = 0; i < len; i++) {
                        html +='<div class="col-md-4 portfolio-item">'
                        html +='<a href="show_details?id=' + data[i].id + '">'
                        html +='<img class="img-responsive" src="http://placehold.it/700x400" alt="">'
                        html +='</a>'
                        html +='<h3>'
                        html +='<a href="#">'+ data[i].name +'</a>'
                        html +='</h3>'
                        html +='<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>'
                        html +='</div>'

                    }


                    $('#items').html(html);
                });
            });/*End $('.sidebar').change*/


    });


