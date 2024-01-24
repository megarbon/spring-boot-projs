package com.melakugb.CrudDeportes.Service.DeporteSeviceIMPL;

import com.melakugb.CrudDeportes.Entity.Deporte;
import com.melakugb.CrudDeportes.Repository.DeporteRepo;
import com.melakugb.CrudDeportes.Service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//implementamos los metodos de DeporteService
@Service
public class DSIMPL implements DeporteService {
    //este tag es imprescindible para spring en este metodo
    @Autowired
    //creamos una instancia de persona repo para poder usar los metodos que esa clase heredó
    private DeporteRepo repo;
    public List<Deporte> ListarDeportes(){
        return (List<Deporte>) this.repo.findAll();
    }
    public Deporte insertarDeporte(Deporte d){
        d.setNombre(d.getNombre());
        return this.repo.save(d);
    }
    public Deporte buscarDeporteById(int id){
        return this.repo.findById(id).get();
    }
    public Deporte editarDeporte(Deporte d){
        return this.repo.save(d);
    }

    public void eliminarDeporteById(int id){
        this.repo.deleteById(id);
    }
}
