function consultarDeportes() {
    fetch('http://localhost:8080/CRUDRepo/ConsultarDeportes')
        .then(response => response.json())
        .then(data => {
            if (data.length > 0) {
                const keys = Object.keys(data[0]);

                // Crear la tabla
                const table = document.createElement('table');
                table.classList.add('table-auto', 'border', 'border-collapse', 'w-full');

                // Crear la cabecera de la tabla
                const thead = document.createElement('thead');
                const headerRow = document.createElement('tr');
                keys.forEach(key => {
                    const th = document.createElement('th');
                    th.classList.add('border', 'px-4', 'py-2');
                    th.textContent = key;
                    headerRow.appendChild(th);
                });
                thead.appendChild(headerRow);
                table.appendChild(thead);

                // Crear el cuerpo de la tabla
                const tbody = document.createElement('tbody');
                data.forEach(item => {
                    const row = document.createElement('tr');
                    keys.forEach(key => {
                        const td = document.createElement('td');
                        td.classList.add('border', 'px-4', 'py-2');
                        td.textContent = item[key];
                        row.appendChild(td);
                    });
                    tbody.appendChild(row);
                });
                table.appendChild(tbody);

                // Añadir la tabla al div
                document.getElementById('consultarDeportesResult').innerHTML = '';
                document.getElementById('consultarDeportesResult').appendChild(table);
            } else {
                document.getElementById('consultarDeportesResult').innerHTML = 'No hay datos disponibles.';
            }
        })
        .catch(error => console.error('Error:', error));
}


function insertarDeporte() {
    const nombreDeporte = document.getElementById('nombreDeporte').value;
    fetch('http://localhost:8080/CRUDRepo/InsertarDeporte', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ nombre: nombreDeporte }),
    })
        .then(response => response.json())
        .then(data => {
            if (data.id) {
                const mensaje = `Deporte insertado correctamente con ID: ${data.id}`;
                document.getElementById('insertarDeporteResult').innerHTML = mensaje;
            } else {
                document.getElementById('insertarDeporteResult').innerHTML = 'Error al insertar el deporte.';
            }
        })
        .catch(error => console.error('Error:', error));
}

function consultarDeportePorId() {
    const idConsulta = document.getElementById('idConsulta').value;
    fetch(`http://localhost:8080/CRUDRepo/ConsultarDeporte/${idConsulta}`)
        .then(response => response.json())
        .then(data => {
            if (data) {
                // Crear un mensaje informativo
                const mensaje = `Deporte encontrado: ${data.nombre}, ID: ${data.id}`;
                document.getElementById('consultarDeportePorIdResult').innerHTML = mensaje;
            } else {
                document.getElementById('consultarDeportePorIdResult').innerHTML = 'No se encontró el deporte.';
            }
        })
        .catch(error => console.error('Error:', error));
}


function eliminarDeporte() {
    const idEliminar = document.getElementById('idEliminar').value;
    fetch(`http://localhost:8080/CRUDRepo/EliminarDeporte/${idEliminar}`, {
        method: 'DELETE',
    })
        .then(response => {
            if (response.ok) {
                document.getElementById('eliminarDeporteResult').innerHTML = 'Deporte eliminado correctamente.';
            } else {
                document.getElementById('eliminarDeporteResult').innerHTML = 'Error al eliminar el deporte.';
            }
        })
        .catch(error => console.error('Error:', error));
}

function modificarDeporte() {
    const idModificar = document.getElementById('idModificar').value;
    const nuevoNombre = document.getElementById('nuevoNombre').value;
    fetch(`http://localhost:8080/CRUDRepo/ModificarDeporte/${idModificar}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ id: idModificar, nombre: nuevoNombre }),
    })
        .then(response => response.json())
        .then(data => {
            if (data.id) {
                // Mensaje de éxito
                const mensaje = `Deporte modificado correctamente. Nuevo nombre: ${data.nombre}, ID: ${data.id}`;
                document.getElementById('modificarDeporteResult').innerHTML = mensaje;
            } else {
                // Mensaje de error
                document.getElementById('modificarDeporteResult').innerHTML = 'Error al modificar el deporte. Asegúrate de proporcionar un ID válido.';
            }
        })
        .catch(error => console.error('Error:', error));
}
