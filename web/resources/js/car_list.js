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
            fromCarYear : $('#fromYear').val(),
            toCarYear : $('#toYear').val(),
            fromCarPrice : $('#fromPrice').val(),
            toCarPrice : $('#toPrice').val(),
            fromEngineValue : $('#fromValue').val(),
            toEngineValue : $('#toValue').val(),
            bodyType : $('#bodyType').val(),
            transmissionType : $('#transmissionType').val(),
            ajax : 'true'
        }, function(data) {

            var html = '';
            var len = data.length;
            for ( var i = 0; i < len; i++) {

                html +='<section class="col-md-12 content" id="home">'
                html +='<div class="col-lg-6 col-md-6 content-item">'
                html +='<img src="' + data[i].generalImage +'" alt="Image111" class="tm-image">'
                html +='</div>'
                html +='<div class="col-lg-6 col-md-6 content-item content-item-1 background">'
                html +='<a href="show_details?id=' + data[i].id + '"><h2 class="main-title text-center dark-blue-text">' + data[i].mark + " " + data[i].model  +'</h2></a>';
                html +='<h1 id="price">' + data[i].carPrice + '</h1>';
                html +='<p>Объем двигателя: ' + data[i].engineValue + '</p>';
                html +='<p>Расход Топлива: ' + data[i].consumption + '</p>';
                html +='<p>Пробег: ' + data[i].mileage + '</p>';

                html +='<p id="description">' + data[i].description + '</p>';
                html +='<button type="button" class="btn btn-big dark-blue-bordered-btn"><a href="edit?id=' + data[i].id + '"' +'>Edit</a></button>'
                html +='<button type="button" class="btn btn-big dark-blue-btn"><a href="delete?id=' + data[i].id + '"' +'>Delete</a></button>'
                html +='</div>'
                html +='</section>'

            }


            $('#cars-container').html(html);
        });
        
        
        $('#menu').change(

            function() {


                $.getJSON('usedBySearchBean', {
                    mark : $('#first-choice').val(),
                    model : $('#second-choice').val(),
                    fromCarYear : $('#fromYear').val(),
                    toCarYear : $('#toYear').val(),
                    fromCarPrice : $('#fromPrice').val(),
                    toCarPrice : $('#toPrice').val(),
                    fromEngineValue : $('#fromValue').val(),
                    toEngineValue : $('#toValue').val(),
                    bodyType : $('#bodyType').val(),
                    transmissionType : $('#transmissionType').val(),
                    ajax : 'true'
                }, function(data) {

                    var html = '';
                    var len = data.length;

                    for ( var i = 0; i < len; i++) {
                        html +='<section class="col-md-12 content" id="home">'
                        html +='<div class="col-lg-6 col-md-6 content-item">'
                        html +='<img src="' + data[i].generalImage +'" alt="Image" class="tm-image">'
                        html +='</div>'
                        html +='<div class="col-lg-6 col-md-6 content-item content-item-1 background">'
                        html +='<a href="show_details?id=' + data[i].id + '"><h2 class="main-title text-center dark-blue-text">' + data[i].mark + " " + data[i].model  +'</h2></a>';
                        html +='<h1 id="price">' + data[i].carPrice + '</h1>';
                        html +='<p>Объем двигателя: ' + data[i].engineValue + '</p>';
                        html +='<p>Расход Топлива: ' + data[i].consumption + '</p>';
                        html +='<p>Пробег: ' + data[i].mileage + '</p>';
                        html +='<p id="description">' + data[i].description + '</p>';
                        html +='<button type="button" class="btn btn-big dark-blue-bordered-btn"><a href="edit?id=' + data[i].id + '"' +'>Edit</a></button>'
                        html +='<button type="button" class="btn btn-big dark-blue-btn"><a href="delete?id=' + data[i].id + '"' +'>Delete</a></button>'
                        html +='</div>'
                        html +='</section>'

                    }


                    $('#cars-container').html(html);
                });
            });/*End $('.sidebar').change*/


    });


