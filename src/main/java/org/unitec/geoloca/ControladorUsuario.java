/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.geoloca;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/api")
public class ControladorUsuario {
    
        @Autowired //Inyeccion de dependencias: Oculta implementaciones concretas y expone las abstractas solamente
        RepoUsuario repoUsuario;
    @GetMapping("/usuario")
    
    public List<Usuario> obtenerUsuarios(){
        
        //Simulacion que obtenemos un usuario
        
       /* Usuario u= new Usuario();
        u.setId(20);
        u.setLat(19.55);
        u.setLon(-99.8);
        u.setNombre("Viviana");
        //Creamos materias 
        Materia m1= new Materia();
        m1.setCalificacion(9);
        m1.setNombre("Aplicaciones Moviles"); 
        Materia m2= new Materia();
        m2.setCalificacion(6);
        m2.setNombre("Computo nube");
        //Las agregamos al usuario
        u.setMaterias(Arrays.asList(m1,m2));
    return u;
    */
       return repoUsuario.findAll();//Esta heredadp de Mongo Repository <Usuario, String>
                                       //Es el equivalente al select * from usuario       
    }
    //Metodo POST para guardar un Usuario
    @PostMapping("/usuario")
    public Estatus guardarUsuario(@RequestBody String json)throws Exception{
        //Mapeamos el objeto llegado
        
        ObjectMapper maper = new ObjectMapper();
      Usuario u =  maper.readValue(json, Usuario.class);
      //Ya despues de mapear guad
      repoUsuario.save(u);
      //Generamos el estatus
      Estatus e= new Estatus();
      e.setMensaje("Usuario ya se guardo!!");
      e.setSuccess(true);
      return e;
    }
}
