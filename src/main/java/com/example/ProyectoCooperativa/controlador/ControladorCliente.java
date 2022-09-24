package com.example.ProyectoCooperativa.controlador;

import com.example.ProyectoCooperativa.entidades.Cliente;
import com.example.ProyectoCooperativa.servicios.ServicioImplCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("cliente")
//@RestController
public class ControladorCliente {


    @Autowired
    private ServicioImplCliente sic;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal!=null)
        System.out.println(principal.getClaims());
        return "index";

    }



    @GetMapping("/cliente")
    public String listar(Model modelo){
        modelo.addAttribute("clientes", sic.listarClientes());
        return ("tabla_cliente");
    }

    @GetMapping("cliente/nuevo")
    public String formularioRegistro(Model modelo){
        modelo.addAttribute( "clienteinsertar", new Cliente());
        return "frmcliente";
    }

    @PostMapping("cliente/guardar")
    public String insertar(Cliente cli){
        sic.guardarClientes(cli);
        return "redirect:/cliente";
    }

    @GetMapping("cliente/actualizar/{dato}")
    public String formularioActualizar(@PathVariable("dato") Integer dato, Model modelo){
        Cliente cliente = sic.consultarClientesPorId(dato);
        modelo.addAttribute("clienteactualizar", cliente);
        return "frmactualizar";
    }

    @PostMapping("/cliente/actualizar")
    public String actualizar(Cliente cli){
        sic.actualizarClientes(cli);
        return "redirect:/cliente";
    }

//    @DeleteMapping
//    public void eliminar(@RequestBody Cliente cli){
//        sic.eliminarClientes(cli.getDocumento());
//    }

    @GetMapping("cliente/eliminar/{id}")
    public String eliminarporId(@PathVariable("id") Integer id){
        sic.eliminarClientesId(id);
        return "redirect:/cliente";
    }
//
//    @PatchMapping("/{id}")
//    public Cliente actualizarpor(@PathVariable("id")Integer id, @RequestBody Map<Object, Object> objectMap){
//        return sic.actualizarPorId(id, objectMap);
//    }

}
