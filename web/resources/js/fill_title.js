/**
 * Created by andrew on 28.09.16.
 */
$(document).ready(
    function () {
        $('#first-choice,#second-choice').change(
            function () {
                $('#title').val($('#first-choice').val() + ' ' + $('#second-choice').val())
            }
        )
        
    }
    
)