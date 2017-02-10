/**
 * Created by andrew on 28.09.16.
 */
$(document).ready(
    function () {
        var title ='';
        $('#first-choice').change(
            
            function () {
                title += $('#first-choice').val();
                $('#title').val(title)
            }
        )
        $('#second-choice').change(

            function () {
                title += ' ' + $('#second-choice').val();
                $('#title').val(title)
            }
        )
    }
    
)