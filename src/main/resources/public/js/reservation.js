//const BASE_URL_RESER = 'http://localhost:8080/api/Reservation';

function listReservations(){
    $.ajax({
        url: 'api/Reservation/all',
        type: 'GET',
        dataType: 'JSON',
        success: (res)=>{
            console.log('Mostrando reservas...');
            loadReservations(res);
        },
        error: (err)=>{
            alert(`Error: Status ${err.status}`);
        }
    })
}

function loadReservations(res){
    const reservations = res;

    $('#reservationList').empty();
    $('#reservationList').append(
        `<table id="reservationTable" style="border: 1px solid black"> 
            <thead>
                <th>Cliente</th>
                <th>Bicicleta</th>
                <th>Fecha inicio</th>
                <th>Fecha entrega</th>
                <th>Calificacion</th>
            </thead>
            <tbody></tbody>
         </table>`
    )

    for(let i=0; i<reservations.length; i++){
        $('#reservationTable tbody').append(
            `<tr id=${i}>
                <th>${reservations[i].client.name}</th>
                <th>${reservations[i].bike.name}</th>
                <td>${reservations[i].startDate.slice(0,10)}</td>
                <td>${reservations[i].devolutionDate.slice(0,10)}</td>
             </tr>`
        )
        if(reservations[i].score == null){
            $(`#reservationTable tbody #${i}`).append(
                `<td>Sin calificar</td>
                 <td><button onclick="loadScoreForm(${reservations[i].idReservation})">Calificar</button></td>`
            )
        } else {
            $(`#reservationTable tbody #${i}`).append(`<td>${reservations[i].score.score}</td>`)
        }
    }
    $('#list-btn-reservation').text('Ocultar');
    $('#list-btn-reservation').attr('onclick', 'hideReservations()');
}

function hideReservations(){
    $('#list-btn-reservation').text('Consultar');
    $('#list-btn-reservation').attr('onclick', 'listReservations()');
    $('#reservationList').empty();
}

function saveReservation(){
    $.ajax({
        url: 'api/Reservation/save',
        type: 'POST',
        data: JSON.stringify({
            startDate: $('#startDate-reservation').val(),
            devolutionDate: $('#devolutionDate-reservation').val(),
            client: {idClient: $('#clientId-reservation').val()},
            bike: {id: $('#bikeId-reservation').val()}
        }),
        contentType: 'application/json',
        success: (res)=>{
            console.log('Guardando reserva...');
            listReservations();
            clearReservation();
        },
        error: (err)=>{
            alert(`Error: Status ${err.status}`);
        }
    })
}

function clearReservation(){
    $('#clientId-reservation').val('');
    $('#bikeId-reservation').val('');
    $('#startDate-reservation').val('');
    $('#devolutionDate-reservation').val('');
}

function loadFormReservation(){
    $('#form-reservas').empty();
    $('#form-reservas').append(
        `<form>
            <input type="number" name="clientId-reservation" id="clientId-reservation" placeholder="ID del cliente">
            <input type="number" name="bikeId-reservation" id="bikeId-reservation" placeholder="ID de la bicicleta">
            <br />
            <br />
            <label for="startDate-reservation">Fecha de inicio: </label>
            <input type="date" name="startDate-reservation" id="startDate-reservation">

            <label for="devolutionDate-reservation">Fecha de entrega: </label>
            <input type="date" name="devolutionDate-reservation" id="devolutionDate-reservation">
        </form>`
    )
    $('#save-btn-reservation').text('Guardar');
    $('#save-btn-reservation').attr('onclick','saveReservation()');
    $('#list-btn-reservation').removeAttr('hidden');
    listReservations();
}