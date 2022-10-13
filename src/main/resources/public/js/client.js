function obtenerCliente(){
    $.ajax({
        url: 'api/Client/all',
        type: "GET",
        dataType: "JSON",
        success: function(respuesta){
            console.log(respuesta);
            mostrarClientes(respuesta);
        }
    });
}

function mostrarClientes(items){
    $("#consultarCli").text('Ocultar');
    $('#consultarCli').attr('onclick', 'ocultarRespuestaClient()');

    let myTable=
        `<table style="border: 1px solid black">
        <thead>
            <th>Name</th>
            <th>Email</th>
            <th>Edad</th>
        </thead>
        <tbody>`;

    for(let i=0; i<items.length; i++){
        myTable += "<tr>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].email + "</td>";
        myTable += "<td>" + items[i].age + "</td>";

        //myTable += "<td>" + items[i].message.name + "</td>";
        //myTable += "<td>" + items[i].reservation.name "</td>";
        myTable += "<tr>";
    }
    myTable += "</tbody></table>";

    $("#listaClientes").empty();
    $("#listaClientes").append(myTable);
}

function ocultarRespuestaClient(){
    $('#consultarCli').text('Consultar');
    $('#consultarCli').attr('onclick', 'obtenerCliente()');
    $("#listaClientes").empty();
}


function enviarCliente(){
    let dcliente = {

        email: $("#emailCli").val(),
        name: $("#nameCli").val(),
        age: $("#ageCli").val()

        //category:{id:$("#categoryBici").val()},
        //message:{id:$("#messageCli").val()}
    };

    let dataToSend = JSON.stringify(dcliente);

    $.ajax({
        url: 'api/Client/save',
        type: "POST",
        data: dataToSend,
        contentType: 'application/json',
        success:function(respuesta){

            $("#emailCli").val("");
            $("#pasCli").val("");
            $("#nameCli").val("");
            $("#ageCli").val("");

            obtenerCliente();
            alert("Se ha guardado el dato");
        }
    });
}

/**
 *

 function actualizarCliente(){
    let dCliente = {
        id: $("#idCli").val(),
        name: $("#nameCli").val(),
        email: $("#emailCli").val(),
        age: $("#ageCli").val()
    };

    let dataToSend = JSON.stringify(dCliente);

    $.ajax({
        url: BASE_URL_CLI,
        type: "PUT",
        data:dataToSend,
        contentType:"application/json",
        success: function(respuesta){
            console.log(respuesta);
            $("#idCli").val("");
            $("#nameCli").val("");
            $("#emailCli").val("");
            $("#ageCli").val("");
            obtenerCliente();
        }
    });
}

 function borrarCliente(idCliente){
    let dCliente = {
        id:idCliente
    };

    let dataToSend = JSON.stringify(dCliente);

    $.ajax({
        url: BASE_URL_CLI,
        type: "DELETE",
        data: dataToSend,
        contentType:"application/json",
        success: function(respuesta){
            obtenerCliente();
        }
    });
}

 function buscarCliente(){
    let dCliente = $("#idCli").val();

    $.ajax({
        url: `${BASE_URL_CLI}/${dCliente}`,
        type: "GET",
        dataType: "JSON",
        success: function(respuesta){
            console.log(respuesta);
            $("#idCli").val("");
            mostrarClientes(respuesta.items);
        }
    });
}


 function limpiarTabla(){
    $('#consultarCli').text('Consultar');
    $('#consultarCli').attr('onclick', 'obtenerCliente()');
    $('#listaClientes').empty();
}
 */