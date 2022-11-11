package pe.com.escuelanueva.service;

import java.util.List;
import java.util.Optional;
import pe.com.escuelanueva.entity.DistritoEntity;


public interface DistritoService {
    // Funcion para mostrar todos los distritos
    List<DistritoEntity> findAll();
    // Funcion para mostrar todos distritos habilitados
    List<DistritoEntity> findAllCustom();
    // Funcion para buscar un distrito por codigo
    Optional<DistritoEntity> findById(Long id);
    // Funcion para registrar
    DistritoEntity add(DistritoEntity d);
    // Funcion para actualizar
    DistritoEntity update(DistritoEntity d);
    // Funcion para eliminar
    DistritoEntity delete(DistritoEntity d);
}
