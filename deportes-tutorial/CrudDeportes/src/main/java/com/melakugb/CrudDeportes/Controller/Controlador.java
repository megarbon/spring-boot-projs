package com.melakugb.CrudDeportes.Controller;

import com.melakugb.CrudDeportes.Entity.Deporte;
import com.melakugb.CrudDeportes.Service.DeporteSeviceIMPL.DSIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//especificamos que sera un controlador de una api rest
@RestController
// esto para poder hacer los mapeos de rutas
@RequestMapping("CRUDRepo")
public class Controlador {

    @Autowired
    private DSIMPL impl;

    // Metodos de crud que actuan sobre la api
    @GetMapping
    @RequestMapping(value = "ConsultarDeportes", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarPersonas() {
        List<Deporte> listaDeportes = this.impl.ListarDeportes();
        return ResponseEntity.ok(listaDeportes);
    }

    @PostMapping
    @RequestMapping(value = "InsertarDeporte", method = RequestMethod.POST)
    public ResponseEntity<?> InsertarDeporte(@RequestBody Deporte d) {
        Deporte deporteInsertado = this.impl.insertarDeporte(d);
        return ResponseEntity.status(HttpStatus.CREATED).body(deporteInsertado);
    }

    // Ejemplo de método para buscar un deporte por ID
    @GetMapping
    @RequestMapping(value = "ConsultarDeporte/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarDeportePorId(@PathVariable int id) {
        Deporte deporte = this.impl.buscarDeporteById(id);
        if (deporte != null) {
            return ResponseEntity.ok(deporte);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deporte no encontrado");
        }
    }

    // En el controlador
    @PutMapping("ModificarDeporte/{id}")
    public ResponseEntity<Deporte> modificarDeporte(@PathVariable int id, @RequestBody Map<String, String> body) {
        try {
            // Obtener el nombre del cuerpo de la solicitud
            String nuevoNombre = body.get("nombre");

            // Llamar a editarDeporte en DSIMPL
            Deporte deporteModificado = impl.editarDeporte(id, nuevoNombre);

            if (deporteModificado != null) {
                return ResponseEntity.ok(deporteModificado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Ejemplo de método para eliminar un deporte por ID
    @DeleteMapping
    @RequestMapping(value = "EliminarDeporte/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarDeporte(@PathVariable int id) {
        this.impl.eliminarDeporteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
