var url = "http://localhost:8080/api/v1/descripcion_ventasContoller/";


// Función para cargar la lista de clientes al cargar la página
function cargarListaVentas() {
    document.addEventListener("DOMContentLoaded", function () {
        var ventaSelect = document.getElementById("ventaSelect");

        if (ventaSelect) {
            // Realizar una solicitud al backend para obtener la lista de Clientes
            // y llenar el select con las opciones
            $.ajax({
                url: "http://localhost:8080/api/v1/ventas/",
                type: "GET",
                success: function (result) {
                    for (var i = 0; i < result.length; i++) {
                        // Verificar si el ventas está habilitado antes de agregarlo al select
                        if (result[i]) {
                            var option = document.createElement("option");
                            option.value = result[i].id_venta;
                            option.text = result[i].id_venta;
                            
                            ventaSelect.appendChild(option);
                        }
                    }

                    // // Agregar un evento al cambio de selección del select
                    // ventaSelect.addEventListener("change", function () {
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
       
            console.error("Elemento con ID 'ventaSelect' no encontrado.");
        }
    });
}


cargarListaVentas();


/// Función para cargar la lista de productos al cargar la página
function cargarListaProductos() {
    document.addEventListener("DOMContentLoaded", function () {
        var productoSelect = document.getElementById("productoSelect");

            // Realizar una solicitud al backend para obtener la lista de productos
            // y llenar el select con las opciones
            $.ajax({
                url: "http://localhost:8080/api/v1/productos/",
                type: "GET",
                success: function (result) {
                    for (var i = 0; i < result.length; i++) {
                        // Verificar si el producto está habilitado antes de agregarlo al select
                        if (result[i]) {
                            var option = document.createElement("option");
                            option.value = result[i].id_producto;
                            option.text = result[i].id_producto + " - " + result[i].nombre_producto;
                            productoSelect.appendChild(option);
                        }
                    }
                },
                error: function (error) {
                    console.error("Error al obtener la lista de productos: " + error);
                }
            });

    });
}

cargarListaProductos();



function registrarDescripcionVenta() {
    // Obtener los valores de los campos del formulario
    let formData = {
        "ventas": document.getElementById("ventaSelect").value,
        "productos": document.getElementById("productoSelect").value,
        "cantidad": document.getElementById("cantidad").value,
        "precio": document.getElementById("precio").value,
        "descuento": document.getElementById("descuento").value,
        "sub_total": document.getElementById("sub_total").value
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