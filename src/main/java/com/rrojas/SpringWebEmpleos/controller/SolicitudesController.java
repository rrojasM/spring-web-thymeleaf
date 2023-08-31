package com.rrojas.SpringWebEmpleos.controller;

import com.rrojas.SpringWebEmpleos.model.Solicitud;
import com.rrojas.SpringWebEmpleos.model.Usuario;
import com.rrojas.SpringWebEmpleos.model.Vacante;
import com.rrojas.SpringWebEmpleos.service.ISolicitudesService;
import com.rrojas.SpringWebEmpleos.service.UsuarioService;
import com.rrojas.SpringWebEmpleos.service.VacantesService;
import com.rrojas.SpringWebEmpleos.utils.Utileria;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudesController {

    @Value("${empleosapp.ruta.cv}")
    private String ruta;
    @Autowired(required = true)
    private VacantesService serviceVacantes;
    @Autowired(required = true)
    private UsuarioService serviceUsuario;
    @Autowired(required = true)
    private ISolicitudesService serviceSolicitudes;

    @GetMapping("/indexPaginate")
    public String mostrarIndexPaginado(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable page){
        Page<Solicitud> lista = serviceSolicitudes.buscarTodas(page);
        model.addAttribute("solicitudes", lista);
        return "solicitudes/listSolicitudes";
    }

    @GetMapping("/index")
    public String mostrarIndex(Model model){
        List<Solicitud> lista = serviceSolicitudes.buscarTodas();
        model.addAttribute("solicitudes", lista);
        return "solicitudes/listSolicitudes";
    }
    @GetMapping("/create/{idVacante}")
    public String crear(Solicitud solicitud, @PathVariable Integer idVacante, Model model){
        Vacante vacante = serviceVacantes.buscarPorId(idVacante);
        System.out.println("idVacante: " + idVacante);
        model.addAttribute("vacante", vacante);
        return "solicitudes/formSolicitud";
    }

    @PostMapping("/save")
    public String guardar(Solicitud solicitud, BindingResult result, Model model, HttpSession session,
                          @RequestParam("archivoCV") MultipartFile multipartFile, RedirectAttributes attributes, Authentication authentication){
        String username = authentication.getName();

        if (result.hasErrors()){
            System.out.println("Existen Errores");
            return "Solicitudes/formSolicitud";
        }

        if(!multipartFile.isEmpty()){
            String nombreArchivo = Utileria.guardarArchivo(multipartFile, ruta);
            if (nombreArchivo != null){
                solicitud.setArchivo(nombreArchivo);
            }
        }

        Usuario usuario = serviceUsuario.buscarPorUsername(username);
        solicitud.setUsuario(usuario);

        serviceSolicitudes.guardar(solicitud);
        attributes.addFlashAttribute("msg","Gracias por enviar tu CV!");

        System.out.println("Solicitud: " +  solicitud);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Integer idSolicitud, RedirectAttributes attributes){
        serviceSolicitudes.eliminar(idSolicitud);

        attributes.addFlashAttribute("msg", "La solicitud fue eliminada!.");

        return "redirect:/solicitudes/indexPaginate";
    }
}
