var url = "http://localhost:8080/api/v1/ventas/";


// Función para cargar la lista de clientes al cargar la página
function cargarListaClientes() {
    document.addEventListener("DOMContentLoaded", function () {
        var clienteSelect = document.getElementById("clienteSelect");

        if (clienteSelect) {
            // Realizar una solicitud al backend para obtener la lista de Clientes
            // y llenar el select con las opciones
            $.ajax({
                url: "http://localhost:8080/api/v1/cliente/",
                type: "GET",
                success: function (result) {
                    for (var i = 0; i < result.length; i++) {
                        // Verificar si el ventas está habilitado antes de agregarlo al select
                        if (result[i]) {
                            var option = document.createElement("option");
                            option.value = result[i].id_cliente;
                            option.text = result[i].id_cliente + "-" + result[i].tipo_identificacion + "-"  + result[i].numero_identificacion + " - " + result[i].nombre_cliente;
                            
                            clienteSelect.appendChild(option);
                        }
                    }

                    // // Agregar un evento al cambio de selección del select
                    // clienteSelect.addEventListener("change", function () {
                    //     var selectedOption = this.options[this.selectedIndex];
                    //     if (selectedOption.getAttribute("data-deshabilitado") === "true") {
                    //         // Si la opción seleccionada está deshabilitada, mostrar una alerta de confirmación
                    //         var confirmacion = confirm("Este cliente está deshabilitado. ¿Estás seguro de querer seleccionarlo?");
                    //         if (!confirmacion) {
                    //             // Si el usuario cancela, seleccionar la opción por defecto
                    //             this.value = '';
                    //         }
                    //     }
                    // });
                },
                error: function (error) {
                    console.error("Error al obtener la lista de Clientes: " + error);
                }
            });
        } else {
       
            console.error("Elemento con ID 'clienteSelect' no encontrado.");
        }
    });
}


cargarListaClientes();







// Función para listar las Ventas
function listaVentas() {
    //Se crea el filtro
   // var capturarFiltro = document.getElementById("Search").value;
    var urlVenta=url;
     //if (capturarFiltro!=""){
        //urlVenta+="busquedafiltro/"+capturarFiltro;
   //}
    $.ajax({
        url: urlVenta,
        type: "GET",
        success: function (result) {
            console.log(result);

            var listaVentas = document.getElementById("listaVentas");

            listaVentas.innerHTML = "";

            for (var i = 0; i < result.length; i++) {
                let trRegistro = document.createElement("tr");
                //trRegistro.classList.add(i % 2 === 0 ? "form-fielddd" : "form-fieldd");
                let celdaID = document.createElement("td");
                let celdaCliente = document.createElement("td");
                let celdaTotal = document.createElement("td");
                let celdaEstado = document.createElement("td");
                let celdaFecha_venta = document.createElement("td"); 
                let celdaEditar = document.createElement("td");
                let celdaEliminar = document.createElement("td");

                celdaID.innerText = result[i]["id_venta"];
                var cliente=result[i]["cliente"]
                celdaCliente.innerText = cliente["id_cliente"]+ " " + cliente["tipo_identificacion"] + " " + cliente["numero_identificacion"]  || "";
                celdaTotal.innerText = result[i]["total"] || "";
                celdaEstado.innerText = result[i]["estado"] || "";
                celdaFecha_venta.innerText = result[i]["fecha_venta"] || "";


                let botonEditar = document.createElement("a");
                botonEditar.className = "btn btn-warning";
                botonEditar.textContent = "Editar";
                botonEditar.id = "btnEditar";

                let botonEliminar = document.createElement("button");
                botonEliminar.className = "btn btn-danger";
                botonEliminar.textContent = "Eliminar";

                     // Agregar evento al botón Eliminar
                    botonEliminar.onclick = (function(id) {
                        return function() {
                            eliminarVenta(id);
                        };
                    })(result[i]["id_venta"]);

                    botonEditar.onclick = (function(index) {
                        return function() {
                            let idVenta = result[index]["id_venta"]; // Obtener el ID de la vents usando el índice capturado
                            let modal = document.getElementById("staticBackdrop");
                            if (!modal) {
                                let modalCode = `
                                <!-- Modal -->
                                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="staticBackdropLabel">Editar Venta</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col col-xl-6 col-12 ">
                                                        <label class="" for="clienteSelect">Cliente</label>
                                                        <select id="clienteSelect" class="form-select">
                                                            <option value="" selected disabled>Seleccione un cliente</option>
                                                        </select>
                                                    </div>
                                                    <div class="col col-xl-6 col-12 ">
                                                        <label class="" for="total">Total</label>
                                                        <input type="number" id="total" class="form-control ">
                                                    </div>
                                                    <div class="col col-xl-6 col-12 ">
                                                        <label class="" for="estado">Estado</label>
                                                        <input type="text" id="estado" class="form-control ">
                                                    </div>
                                                    <div class="col col-xl-6 col-12 Dark__container">
                                                        <label for="fecha_venta">Fecha de venta</label>
                                                        <input type="datetime-local" id="fecha_venta" class="form-control">
                                                    </div>
                                                    <p style="color: red">Actualiza la página una vez guardados los cambios</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                            <button type="button" class="btn btn-primary">Guardar</button>
                                        </div>
                                    </div>
                                    </div>
                                </div>
                                `;
    
                                let modalContainer = document.createElement("div");
                                modalContainer.innerHTML = modalCode;
                                document.body.appendChild(modalContainer);
                                modal = document.getElementById("staticBackdrop");
                            }
    
                            let modalInstance = new bootstrap.Modal(modal);
                            modalInstance.show();
    
                            let botonGuardar = modal.querySelector(".btn-primary");
    
                            botonGuardar.addEventListener("click", function() {
                                guardarCambiosVenta(idVenta); // Guardar cambios con el ID del ventas
                            });
                            
                            
                            cargarDatosVentasEnModal(idVenta); // Cargar datos de ventas en el formulario
                        };
                    })(i); // Pasar el valor de i al ámbito de cierre
    
                    celdaEditar.appendChild(botonEditar);
                    celdaEliminar.appendChild(botonEliminar);


                trRegistro.appendChild(celdaID);
                trRegistro.appendChild(celdaCliente);
                trRegistro.appendChild(celdaTotal);
                trRegistro.appendChild(celdaEstado);
                trRegistro.appendChild(celdaFecha_venta);
                trRegistro.appendChild(celdaEditar);
                trRegistro.appendChild(celdaEliminar);


                listaVentas.appendChild(trRegistro);
            }
        },
        error: function (error) {
            console.error("Error en la petición: " + error);
        }
    });
}




function registrarVenta() {
    // Obtener los valores de los campos del formulario
    let formData = {
        "cliente": document.getElementById("clienteSelect").value,
        "total": document.getElementById("total").value,
        "estado": document.getElementById("estado").value,
        "fecha_venta": document.getElementById("fecha_venta").value
    };                             


    

    // let tipoDocumento = formData["tipo_documento"];
    // let numeroDocumento = formData["numero_documento"];

    // Verificar duplicación de tipo y número de documento
    /* validarDocumentoRepetido(tipoDocumento, numeroDocumento, function(documentoRepetido) {
        if (documentoRepetido) {
            alert("El tipo y número de documento ya están en uso.");
        } else { */
    // Verificar duplicación de teléfono y correo
    /* validarTelefonoCorreo(formData["telefono"], formData["correo"], function(telefonoRepetido, correoRepetido) {
        if (telefonoRepetido && correoRepetido) {
            alert("El teléfono y el correo ya están en uso.");
        } else if (telefonoRepetido) {
            alert("El teléfono ya está en uso.");
        } else if (correoRepetido) {
            alert("El correo ya está en uso.");
        } else { */
    // Si no hay duplicados, proceder con el registro
    // Validar campos obligatorios al final
    /* if (!validarCampos()) {
        Swal.fire({
            title: "ERROR",
            text: "Llene todos los campos correctamente",
            icon: "error"
        });
        return;
    } */

    // Los campos son válidos, proceder con el registro
    $.ajax({
        url: url,
        type: "POST",
        data: formData,
        success: function (result) {

            alert("Se guardó correctamente");
        },
        error: function (error) {
            Swal.fire({
                icon: "error",
                title: "Error",
                text: "No se guardó correctamente",
                width: 600,
                padding: "3em",
                color: "#716add",
            });
        }
    });
    /* }
});
}
}); */

}



// Función para cargar los datos del ingreso en el formulario de edición
// function cargarDatosVentasEnModal(idVenta) {
//     $.ajax({
//         url: url + idVenta,
//         type: "GET",
//         success: function (venta) {
//             // Asignar valores a los campos del formulario de edición
//             document.getElementById("total").value = venta.total;
//             document.getElementById("estado").value = venta.estado;
//             document.getElementById("fecha_venta").value = venta.fecha_venta;

//             // Cargar la lista de clientes en el selector del modal
//             cargarListaClientes();
//         },
//         error: function (error) {
//             console.error("Error al obtener datos del ingreso:", error);
//         }
//     });
// }


function cargarDatosVentasEnModal(idVenta) {
    $.ajax({
        url: url + idVenta,
        type: "GET",
        success: function (venta) {
                    document.getElementById("total").value = venta.total;
            document.getElementById("estado").value = venta.estado;
            document.getElementById("fecha_venta").value = venta.fecha_venta;
        },
        error: function (error) {
            console.error("Error al obtener datos del cliente:", error);
        }
    });
}



// Función para eliminar un cliente
function eliminarVenta(idVenta) {
    $.ajax({
        url: url + idVenta,
        type: "DELETE",
        success: function (result) {
            listaVentas();
            // Opcional: Mostrar mensaje de éxito
            console.log("Cliente eliminado correctamente");
        },
        error: function (error) {
            // Opcional: Manejar errores
            console.error("Error al eliminar Cliente:", error);
        }
    });
}



