package com.melakugb.CrudDeportes.Repository;

import com.melakugb.CrudDeportes.Entity.Deporte;
import org.springframework.data.repository.CrudRepository;

//esta será la interfaz con la que operaremos sobre la bd
//hereda los metodos de la clase CrudRepository y hace uso de ellos sobre nuestra bd
//En la extension tenemos que especificar la clase que representa a la entidad y el tipo de dato del id
public interface DeporteRepo extends CrudRepository<Deporte, Integer> {

}
