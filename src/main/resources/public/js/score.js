//const BASE_URL_SCORE = 'http://localhost:8080/api/Score/save';

function loadScoreForm(idReservation){
    hideReservations();
    $('#list-btn-reservation').attr('hidden', true);
    $('#form-reservas').empty();
    $('#form-reservas').append(
        `<form>
            <p><b>Califica la reserva :</b></p>
            <input type="radio" id="score-zero" name="score" value="0">
            <label for="score-zero">0</label>
            
            <input type="radio" id="score-one" name="score" value="1">
            <label for="score-one">1</label>
            
            <input type="radio" id="score-two" name="score" value="2">
            <label for="score-two">2</label>
            
            <input type="radio" id="score-three" name="score" value="3">
            <label for="score-three">3</label>
            
            <input type="radio" id="score-four" name="score" value="4">
            <label for="score-four">4</label>
            
            <input type="radio" id="score-five" name="score" value="5">
            <label for="score-five">5</label>
            <br />
            <br />
            <textarea
            name="message-score"
            id="message-score"
            cols="25" rows="6"
            placeholder="Ingresar mensaje..."
            style="resize: none"
            ></textarea>
        </form>`
    )
    $('#save-btn-reservation').text('Enviar calificación');
    $('#save-btn-reservation').attr('onclick', `saveScore(${idReservation})`);
}

function saveScore(idReservation){
    let dataToSend;

    if($('#score-zero').prop('checked')){
        dataToSend = JSON.stringify({
            score: $('#score-zero').prop('value'),
            message: $('#message-score').val(),
            reservation: {idReservation}
        })
    } else if($('#score-one').prop('checked')) {
        dataToSend = JSON.stringify({
            score: $('#score-one').prop('value'),
            message: $('#message-score').val(),
            reservation: {idReservation}
        })
    } else if($('#score-two').prop('checked')) {
        dataToSend = JSON.stringify({
            score: $('#score-two').prop('value'),
            message: $('#message-score').val(),
            reservation: {idReservation}
        })
    } else if($('#score-three').prop('checked')) {
        dataToSend = JSON.stringify({
            score: $('#score-three').prop('value'),
            message: $('#message-score').val(),
            reservation: {idReservation}
        })
    } else if($('#score-four').prop('checked')) {
        dataToSend = JSON.stringify({
            score: $('#score-four').prop('value'),
            message: $('#message-score').val(),
            reservation: {idReservation}
        })
    } else if($('#score-five').prop('checked')) {
        dataToSend = JSON.stringify({
            score: $('#score-five').prop('value'),
            message: $('#message-score').val(),
            reservation: {idReservation}
        })
    }

    $.ajax({
        url: 'api/Score/save',
        type: 'POST',
        data: dataToSend,
        contentType: 'application/json',
        success: ()=>{
            alert('Se ha guardado la calificación');
            loadFormReservation();
        },
        error: ()=>{
            alert(`Error: Status ${err.status}`);
        }
    })
}