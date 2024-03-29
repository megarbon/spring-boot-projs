package com.melakugb.CrudDeportes.Service;

import com.melakugb.CrudDeportes.Entity.Deporte;
import java.util.List;


public interface DeporteService {

    //operaciones de crud que solo se llaman cuando usamos los formularios
    //En esta interfaz solo nombramos los métodos y su estructura general
    //En la otra de este paquete las implementamos
        public List<Deporte> ListarDeportes();
        public Deporte insertarDeporte(Deporte d);
        public Deporte buscarDeporteById(int id);
        public Deporte editarDeporte(int id, String nombre);
        public void eliminarDeporteById(int id);
}

