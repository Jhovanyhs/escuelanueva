
package pe.com.escuelanueva.restcontroller;

//@RestController define que es un controlador

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.escuelanueva.entity.ParentescoEntity;
import pe.com.escuelanueva.service.ParentescoService;

//Aparece apartir de la version 4 de Spring
@RestController
//@Controller --> es un controlador de Spring
//@ResponseBody --> se volvia un controlador Rest
//@RestController = @Controller + @ResponseBody
//@ResquestMapping --> asignar un nombre al endpoint
@RequestMapping("/parentesco")
public class ParentescoController {
    @Autowired
    private ParentescoService servicio;

    //@GetMapping --> permite obtener valores
    @GetMapping
    public List<ParentescoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ParentescoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<ParentescoEntity> findById(@PathVariable Long id) {
        return servicio.findById(id);

    }

    //@Postmapping --> permite enviar datos
    @PostMapping
    public ParentescoEntity add(@RequestBody ParentescoEntity p) {
        return servicio.add(p);
    }

    @PutMapping("/{id}")
    public ParentescoEntity update(@PathVariable Long id, @RequestBody ParentescoEntity p) {
        p.setCodigo(id);
        return servicio.update(p);
    }

    @DeleteMapping("/{id}")
    public ParentescoEntity delete(@PathVariable Long id) {
        ParentescoEntity objparentesco = new ParentescoEntity();
        objparentesco.setEstado(false);
        return servicio.delete(ParentescoEntity.builder().codigo(id).build());
    }
}
