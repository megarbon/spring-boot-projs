function consultarDeportes() {
    fetch('http://localhost:8080/CRUDRepo/ConsultarDeportes')
        .then(response => response.json())
        .then(data => {
            document.getElementById('consultarDeportesResult').innerHTML = JSON.stringify(data);
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
            document.getElementById('insertarDeporteResult').innerHTML = JSON.stringify(data);
        })
        .catch(error => console.error('Error:', error));
}

function consultarDeportePorId() {
    const idConsulta = document.getElementById('idConsulta').value;
    fetch(`http://localhost:8080/CRUDRepo/ConsultarDeporte/${idConsulta}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('consultarDeportePorIdResult').innerHTML = JSON.stringify(data);
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
        body: JSON.stringify({ id: idModificar , nombre: nuevoNombre }),
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('modificarDeporteResult').innerHTML = JSON.stringify(data);
        })
        .catch(error => console.error('Error:', error));
}
