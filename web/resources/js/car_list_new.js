/**
 * Created by andrew on 23.09.16.
 */
/**
 * Created by andrew on 06.09.16.
 */
$(document).ready(
    function() {

        // window.location.search = 'mark=' + $('#first-choice').val()+'&'+'model=' + $('#second-choice').val();
       
        $.getJSON('carList/usedBySearchBean', {
            mark : $('#first-choice').val(),
            model : $('#second-choice').val(),

            ajax : 'true'
        }, function(data) {

            var html = '';
            var len = data.length;

            var html_paginator = '';

            html_paginator += '<ul class="actions pagination">';
            html_paginator += '<li><a href="" class="disabled button big previous">Previous Page</a></li>';
            html_paginator += '<li><a href="#" class="button big next">Next Page</a></li>';
            html_paginator += '</ul>';

            for ( var i = 0; i < len; i++) {

                html +='<article class="post">';
                html +='<header>';
                html +='<div class="title">';
                html +='<h2><a href="#">' + data[i].mark + ' ' + data[i].model + '(' + data[i].carYear + ')' + '</a></h2>';
                html +='<h2>'+ data[i].carPrice +'$</h2>';
                html +='<p></p>';
                html +='</div>';
                html +='<div class="meta">';

                html +='<time class="published" datetime="2015-11-01">November 1, 2015</time>';
                html +='<a href="#" class="author"><span class="name">Jane Doe</span><img src="/resources/images/avatar.jpg" alt="" /></a>';
                html +='</div>';
                html +='</header>';
                html +='<a href="#" class="image featured"><img src="' + data[i].generalImage + '" alt="" /></a>';
                html +='<p>Mauris neque quam, fermentum ut nisl vitae, convallis maximus nisl. Sed mattis nunc id lorem euismod placerat. Vivamus porttitor magna enim, ac accumsan tortor cursus at. Phasellus sed ultricies mi non congue ullam corper. Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>';

                html +='<footer>';
                html +='<ul class="actions">';
                html +='<li><a href="#" class="button big">Continue Reading</a></li>';
                html +='</ul>';
                html +='<ul class="stats">';
                html +='<li><a href="#">General</a></li>';
                html +='<li><a href="#" class="icon fa-heart">28</a></li>';
                html +='<li><a href="#" class="icon fa-comment">128</a></li>';
                html +=' </ul>';
                html +='</footer>';
                html +='</article>';


            }
           
            html += html_paginator;

            $('#main').html(html);
            
            
        });
        
        
        $('#searchBean').change(

            function() {

                var param = 'carList?' +'mark=' + $('#first-choice').val()+'&'+'model=' + $('#second-choice').val();
                history.pushState('', '', param);
                $.getJSON('carList/usedBySearchBean', {
                    mark : $('#first-choice').val(),
                    model : $('#second-choice').val(),

                    ajax : 'true'
                }, function(data) {

                    var html = '';
                    var len = data.length;

                    for ( var i = 0; i < len; i++) {
                  

                        html +='<article class="post">';
                        html +=' <header>'
                        html +='<div class="title">'
                        html +='<h2><a href="#">' + data[i].mark + ' ' + data[i].model + '(' + data[i].carYear + ')' + '</a></h2>'
                        html +='<h2>'+ data[i].carPrice +'$</h2>'
                        html +='<p></p>'
                        html +='</div>'
                        html +='<div class="meta">'

                        html +='<time class="published" datetime="2015-11-01">November 1, 2015</time>'
                        html +='<a href="#" class="author"><span class="name">Jane Doe</span><img src="/resources/images/avatar.jpg" alt="" /></a>'
                        html +='</div>'
                        html +='</header>'
                        html +='<a href="#" class="image featured"><img src="' + data[i].generalImage + '" alt="" /></a>'
                        html +='<p>Mauris neque quam, fermentum ut nisl vitae, convallis maximus nisl. Sed mattis nunc id lorem euismod placerat. Vivamus porttitor magna enim, ac accumsan tortor cursus at. Phasellus sed ultricies mi non congue ullam corper. Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>'

                        html +='<footer>'
                        html +='<ul class="actions">'
                        html +='<li><a href="#" class="button big">Continue Reading</a></li>'
                        html +='</ul>'
                        html +='<ul class="stats">'
                        html +='<li><a href="#">General</a></li>'
                        html +='<li><a href="#" class="icon fa-heart">28</a></li>'
                        html +='<li><a href="#" class="icon fa-comment">128</a></li>'
                        html +=' </ul>'
                        html +='</footer>'
                        html +='</article>'



                    }


                    $('#main').html(html);
                });
            });/*End $('.sidebar').change*/


    });


