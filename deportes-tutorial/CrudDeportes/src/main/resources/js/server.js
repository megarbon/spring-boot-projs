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