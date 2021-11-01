/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intento5.intento5;

import java.util.Collections;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jo-ha
 */
@RestController
public class UserController {
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        //return principal.getAttributes(); //NO SE RECOMIENDA EXPONE DATOS PRIVADOS
        /**for (Map.Entry<String, Object> entry: principal.getAttributes().entrySet()){
            Object clave= entry.getKey();
            Object valor=entry.getValue();
            System.out.println(clave+": "+valor);
        }*/
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
    /**@GetMapping("/api/")
    public String prueba(@AuthenticationPrincipal OAuth2User principal){
        return "prueba";
    }
    @GetMapping("/Cabin/")
    public String cabin(@AuthenticationPrincipal OAuth2User principal){
        return "cabin";
    }*/
    
}