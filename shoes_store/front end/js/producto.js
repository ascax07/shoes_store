var url = "http://localhost:8080/api/v1/productos/";



function listaProductos() {

    //var capturarFiltro = document.getElementById("Search").value;
    var urlProducto = url;

    //if (capturarFiltro !== "") {
    //urlProducto += "busquedafiltro/" + capturarFiltro;
    //}

    $.ajax({
        url: urlProducto,
        type: "GET",
        success: function (result) {
            console.log(result);
            var listaProductos = document.getElementById("listaProductos");
            listaProductos.innerHTML = "";

            for (var i = 0; i < result.length; i++) {
                let trRegistro = document.createElement("tr");
                // Crear celdas para cada dato del producto
                let celdaID = document.createElement("td");
                let celdaNombreProducto = document.createElement("td");
                let celdaDescripcion = document.createElement("td");
                let celdaCantidad = document.createElement("td");
                let celdaPrecio = document.createElement("td");
                let celdaPorcentajeIva = document.createElement("td");
                let celdaPorcentajeDescuento = document.createElement("td");
                let celdaEstado = document.createElement("td");
                let celdaEditar = document.createElement("td");
                let celdaEliminar = document.createElement("td");

                // Asignar valores a las celdas
                celdaID.innerText = result[i]["id_producto"];
                celdaNombreProducto.innerText = result[i]["nombre_producto"] || "";
                celdaDescripcion.innerText = result[i]["descripcion"] || "";
                celdaCantidad.innerText = result[i]["cantidad"];
                celdaPrecio.innerText = result[i]["precio"];
                celdaPorcentajeIva.innerText = result[i]["porcentaje_iva"];
                celdaPorcentajeDescuento.innerText = result[i]["porcentaje_descuento"];
                celdaEstado.innerText = result[i]["estado"];

                // Agregar botón "Editar" y "Eliminar"
                let botonEditar = document.createElement("a");
                botonEditar.className = "btn btn-warning";
                botonEditar.textContent = "Editar";
                botonEditar.id = "btnEditar";

                let botonEliminar = document.createElement("button");
                botonEliminar.className = "btn btn-danger";
                botonEliminar.textContent = "Eliminar";

                // Asignar eventos a los botones
                botonEliminar.onclick = (function (id) {
                    return function () {
                        eliminarProducto(id);
                    };
                })(result[i]["id_producto"]);


                botonEditar.onclick = (function (index) {
                    return function () {
                        let id_producto = result[index]["id_producto"];
                        let modal = document.getElementById("staticBackdrop");
                        if (!modal) {
                            let modalCode = `
                            <!-- Modal -->
                            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                               <div class="modal-dialog">
                               <div class="modal-content">
                                   <div class="modal-header">
                                   <h1 class="modal-title fs-5" id="staticBackdropLabel">Editar producto</h1>
                                   <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                   </div>
                                   <div class="modal-body">
                                       <div class="container">
                                       <div class="row">



                                      <div class="col col-xl-6 col-12 ">
                                       <label class="" for="nombre_producto">Nombre del producto</label>
                                       <input type="text" id="nombre_producto" class="form-control ">
                                   </div>

                                   <div class="col col-xl-6 col-12 ">
                                       <label class="" for="descripcion">descripcion del producto</label>
                                       <input type="text" id="descripcion" class="form-control ">
                                   </div>


                                   <div class="col col-xl-6 col-12 ">
                                       <label class="" for="cantidad">cantidad</label>
                                       <input type="number" id="cantidad" step="1" class="form-control ">
                                   </div>

                                   <div class="col col-xl-6 col-12 ">
                                       <label class="" for="precio">precio</label>
                                       <input type="number" id="precio" step="1" class="form-control ">
                                   </div>

                                   <div class="col col-xl-6 col-12 ">
                                       <label class="" for="porcentaje_iva">porcentaje_iva</label>
                                       <input type="number" id="porcentaje_iva" step="1" class="form-control ">
                                   </div>

                                   <div class="col col-xl-6 col-12 ">
                                       <label class="" for="porcentaje_descuento">porcentaje_descuento</label>
                                       <input type="number" id="porcentaje_descuento" step="1" class="form-control ">
                                   </div>

                                   <div class="col col-xl-6 col-12 ">
                                       <label class="" for="estado">estado</label>
                                       <input type="text" id="estado" class="form-control ">
                                   </div>


                                           </div>


                                           <div class="modal-footer">
                                           <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">cerrar</button>
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
                        botonGuardar.addEventListener("click", function () {
                            guardarCambiosproducto(id_producto);
                        });
                        cargarDatosProductoEnModal(id_producto);
                    };
                })(i);

                celdaEditar.appendChild(botonEditar);
                celdaEliminar.appendChild(botonEliminar);

                // Agregar celdas a la fila
                trRegistro.appendChild(celdaID);
                trRegistro.appendChild(celdaNombreProducto);
                trRegistro.appendChild(celdaDescripcion);
                trRegistro.appendChild(celdaCantidad);
                trRegistro.appendChild(celdaPrecio);
                trRegistro.appendChild(celdaPorcentajeIva);
                trRegistro.appendChild(celdaPorcentajeDescuento);
                trRegistro.appendChild(celdaEstado);
                trRegistro.appendChild(celdaEditar);
                trRegistro.appendChild(celdaEliminar);

                // Agregar fila a la tabla
                listaProductos.appendChild(trRegistro);
            }
        },
        error: function (error) {
            alert("Error en la petición " + error);
        }
    });
}



function registrarProducto() {
    // Obtener los valores de los campos del formulario
    let formData = {
        "nombre_producto": document.getElementById("nombre_producto").value,
        "descripcion": document.getElementById("descripcion").value,
        "cantidad": document.getElementById("cantidad").value,
        "precio": document.getElementById("precio").value,
        "porcentaje_iva": document.getElementById("porcentaje_iva").value,
        "porcentaje_descuento": document.getElementById("porcentaje_descuento").value,
        "estado": document.getElementById("estado").value
    };

    // Validar campos obligatorios
    if (!formData.nombre_producto || !formData.descripcion || !formData.cantidad || !formData.precio || !formData.porcentaje_iva || !formData.porcentaje_descuento || !formData.estado) {
        alert("Por favor, complete todos los campos obligatorios.");
        return;
    }



    // Validar formato de correo electrónico
    // Puedes implementar una función para validar el formato de correo electrónico con una expresión regular

    // Validar longitud de texto
    // Puedes verificar la longitud de los campos de texto como nombre_producto y descripcion

    // Validar estado
    // Aquí puedes agregar validaciones específicas para el campo de estado, si es necesario

    // Si todas las validaciones pasan, proceder con el registro
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
}




function cargarDatosProductoEnModal(id_producto) {
    $.ajax({
        url: url + id_producto,
        type: "GET",
        success: function (productos) {

            document.getElementById("nombre_producto").value = productos.nombre_producto;
            document.getElementById("descripcion").value = productos.descripcion;
            document.getElementById("cantidad").value = productos.cantidad;
            document.getElementById("precio").value = productos.precio;
            document.getElementById("porcentaje_iva").value = productos.porcentaje_iva;
            document.getElementById("porcentaje_descuento").value = productos.porcentaje_descuento;
            document.getElementById("estado").value = productos.estado;
        },
        error: function (error) {
            console.error("Error al obtener datos del producto:", error);
        }
    });
}


// Función para eliminar un producto
function eliminarProducto(id_producto) {
    $.ajax({
        url: url + id_producto,
        type: "DELETE",
        success: function (result) {
            listaproducto();
            // Opcional: Mostrar mensaje de éxito
            console.log("producto eliminado correctamente");
        },
        error: function (error) {
            // Opcional: Manejar errores
            console.error("Error al eliminar producto:", error);
        }
    });
}

