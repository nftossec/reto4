//const BASE_URL_MSG = 'http://localhost:8080/api/Message';

function leerMensajes(){
    $.ajax({
        url: 'api/Message/all',
        type: 'GET',
        dataType: 'JSON',
        success: (res)=>{
            console.log('Mostrando mensajes...');
            mostrarInfoMensajes(res);
        },
        error: (err)=>{
            alert(`Error: Status ${err.status}`);
        }
    })
}

function mostrarInfoMensajes(res){
    let mensajes = res;

    $('#listaMensajes').empty();
    $('#listaMensajes').append(
        `<table id="tablaMensajes" style="border: 1px solid black">
            <thead>
                <th>Cliente</th>
                <th>Bicicleta</th>
                <th>Mensaje</th>
            </thead>
            <tbody></tbody>
        </table>`
    )

    for(let i=0; i<mensajes.length; i++){
        $('#tablaMensajes tbody').append(
            `<tr>
                <th>${mensajes[i].client.name}</th>
                <th>${mensajes[i].bike.name}</th>
                <td>${mensajes[i].messageText}</td>
            </tr>`
        )
    }
    $('#listarMensajes').text('Ocultar');
    $('#listarMensajes').attr('onclick', 'ocultarMensajes()');
}

function ocultarMensajes(){
    $('#listarMensajes').text('Consultar');
    $('#listarMensajes').attr('onclick', 'leerMensajes()');
    $('#listaMensajes').empty();
}

function guardarMensaje(){
    $.ajax({
        url: 'api/Message/save',
        type: 'POST',
        data: JSON.stringify({
            messageText: $('#text-message').val(),
            client: {idClient: $('#clientId-message').val()},
            bike: {id: $('#bikeId-message').val()}
        }),
        contentType: 'application/json',
        success: (res)=> {
            console.log('Guardando mensaje...');
            clearMessage();
            leerMensajes();
        },
        error: (err)=>{
            alert(`Error: Status ${err.status}`)
        }
    })
}

/*function formEditar(idMsg, msg){
    $('#mensaje').val(msg);
    $('#enviarMensaje').attr('onclick', `editarMensaje(${idMsg})`)
    $('#enviarMensaje').text('Actualizar')
}*/

/*function editarMensaje(idMsg){
    $.ajax({
        url: BASE_URL_MSG,
        type: 'PUT',
        data: JSON.stringify({
            id: idMsg,
            messagetext: $('#mensaje').val()
        }),
        contentType: 'application/json',
        success: (res)=>console.log('Editando mensaje...'),
        error: (err)=>{
            alert(`Error: Status ${err.status}`)
        },
        complete: ()=>{
            $('#mensaje').val('');
            $('#enviarMensaje').attr('onclick', `guardarMensaje()`)
            $('#enviarMensaje').text('Guardar');
            leerMensajes();
        }
    })
}*/

/*function borrarMensaje(idMsg){
    $.ajax({
        url: BASE_URL_MSG,
        type: 'DELETE',
        data: JSON.stringify({id:idMsg}),
        contentType: 'application/json',
        success: (res)=>{
            console.log('Eliminando mensaje...')
        },
        error: (err)=>{
            alert(`Error: Status ${err.status}`)
        },
        complete: ()=>leerMensajes()
    })
}*/

function clearMessage(){
    $('#clientId-message').val('');
    $('#bikeId-message').val('');
    $('#text-message').val('');
}
