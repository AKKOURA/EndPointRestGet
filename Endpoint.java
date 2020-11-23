
package net.codejava;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller// afin de permettre à Spring d'enregistrer cette classe comme un contrôleur, 
//et surtout de mémoriser les requêtes que cette classe est capable de gérer.
@RequestMapping("/endpoint")// indique la route 
public class Endpoint {
	@ResponseStatus(HttpStatus.BAD_REQUEST) 
    @GetMapping(value="/{nombre}")
    @ResponseBody
     public String home(@PathVariable("nombre") int nombre) 
     {  if( nombre < 0) {
		 return "HTTP "+	HttpStatus.BAD_REQUEST.value();
		 }else {
         if ( nombre% 2==0 &&  nombre >50 ) {
        	 return  "le nombre est " + nombre+"";
        	 
         }else {
         if ( nombre %2 != 0) {
        	 return "la factorielle de "+ nombre+" est "+ factorial( nombre)+"";
        	 
        	 }else if( nombre%2==0 &&  nombre<51){
        		 return "le suite fibonnacci jusqu'a "+ nombre+" est "+fibonacci( nombre)+"";
        		 		 
        	 }
        		 
        	 }
		 }
         
         return "";
     
        
    }
  
    public int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
    public int fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
          return 1;
       else
          return fibonacci(n - 1) + fibonacci(n - 2);
    }
  
}
