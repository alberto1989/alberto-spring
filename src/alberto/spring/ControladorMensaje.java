/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberto.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author heroe
 */
@Controller
@RequestMapping("/")
public class ControladorMensaje {
    
    @RequestMapping(value="/mensaje",method=RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody String buscartodos() throws Exception {
        
        //Esto va ser obtenido atraves del DAOmensaje y metodo obtener todos
        Mensaje m1=new Mensaje();
        m1.setTitulo("Spring-boot");
        m1.setCuerpo("Spring boot ................");
        
        Mensaje m2=new Mensaje();
        m2.setTitulo("java 3");
        m2.setCuerpo("CAMPOS");
        
        Mensaje m3=new Mensaje();
        m3.setTitulo("Ya valio");
        m3.setCuerpo("....");
        
        ArrayList<Mensaje> arreglo=new ArrayList<Mensaje>();
        arreglo.add(m1);
        arreglo.add(m2);
        arreglo.add(m3);
        
        //Vamos a usar una clase llamada ObjectMapper para traducir a JSON
        
        ObjectMapper mapper=new ObjectMapper();
        
        return mapper.writeValueAsString(arreglo);
    }
    
    
    
}
