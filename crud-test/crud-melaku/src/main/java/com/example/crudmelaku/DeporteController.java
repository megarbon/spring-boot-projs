package com.example.crudmelaku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deportes")
public class DeporteController {

    @Autowired
    private DeporteRepository deporteRepository;

    @GetMapping("/")
    public String obtenerDeportes(Model model) {
        List<Deporte> deportes = deporteRepository.findAll();
        model.addAttribute("deportes", deportes);
        return "ListaDeportes";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("deporte", new Deporte());
        return "formularioDeporte";
    }


    //operaciones de crud que solo se llaman cuando usamos los formularios
    @PostMapping("/guardar")
    public String guardarDeporte(@ModelAttribute Deporte deporte) {
        deporteRepository.save(deporte);
        return "redirect:/deportes";
    }

    @GetMapping("/editar/{id}")
    public String editarDeporte(@PathVariable Long id, Model model) {
        Deporte deporte = deporteRepository.findById(id).orElse(null);
        model.addAttribute("deporte", deporte);
        return "formularioDeporte";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDeporte(@PathVariable Long id) {
        deporteRepository.deleteById(id);
        return "redirect:/deportes";
    }
}
