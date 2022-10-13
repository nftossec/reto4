function traerInformacion(){
    $.ajax({
        url:'api/Bike/all',
        type:"GET",
        dataType:"JSON",
        success: function(respuesta){
            console.log(respuesta);
            pintarRespuesta(respuesta);
        }
    });
}

function pintarRespuesta(items){
    $('#consultarBici').text('Ocultar');
    $('#consultarBici').attr('onclick', 'ocultarRespuestaBike()');

    let myTable=
        `<table style="border: 1px solid black">
        <thead>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Categoria</th>
            <th>Nombre</th>
            <th>Descripcion</th>
        </thead>
        <tbody>`;

    for (let i=0; i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].brand+"</td>";
        myTable+="<td>"+items[i].year+"</td>";
        myTable+="<td>"+items[i].category.name+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].description+"</td>";
        //myTable+="<td> <button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</tbody></table>";
    $("#listaBicis").empty();
    $("#listaBicis").append(myTable);
}

function ocultarRespuestaBike(){
    $('#consultarBici').text('Consultar');
    $('#consultarBici').attr('onclick', 'traerInformacion()');
    $("#listaBicis").empty();
}

function guardarInformacion(){
    let myData={
        brand:$("#brandBici").val(),
        year:$("#modelBici").val(),
        category:{id:$("#categoryBici").val()},
        name:$("#nameBici").val(),
        description:$("#descriptionBike").val()
    };

    let dataToSend=JSON.stringify(myData);

    $.ajax({
        url:'api/Bike/save',
        type:"POST",
        data:dataToSend,
        contentType: 'application/json',
        success:function(respuesta){
            $("#idBici").val("");
            $("#brandBici").val("");
            $("#modelBici").val("");
            $("#categoryBici").val("");
            $("#nameBici").val("");
            $("#descriptionBike").val("");
            traerInformacion();
            alert("Se ha guardado el dato");
        }
    });
}

/*
 *

 function editarInformacion(){
    let myData={
        id:$("#idBici").val(),
        brand:$("#brandBici").val(),
        model:$("#modelBici").val(),
        category_id:$("#categoryBici").val(),
        name:$("#nameBici").val(),
        description:$("#descriptionBike").val()
    };

    let dataToSend=JSON.stringify(myData);

    $.ajax({
        url:BASE_URL_BIKE,
        type:"PUT",
        data:dataToSend,
        contentType:"application/json",
        success:function(respuesta){
            $("#idBici").val("");
            $("#brandBici").val("");
            $("#modelBici").val("");
            $("#categoryBici").val("");
            $("#nameBici").val("");
            $("#descriptionBike").val("");
            traerInformacion();
            alert("Se ha actualizado un dato");
        }
    });
}

 function borrarElemento(idElemento){
    let myData={
        id:idElemento
        };

    let dataToSend=JSON.stringify(myData);

    $.ajax({
        url:BASE_URL_BIKE,
        type:"DELETE",
        data:dataToSend,
        contentType: "application/json",
        success:function(respuesta){
            traerInformacion();
            alert("Se ha eliminado un dato");
        }
    });
}
 */