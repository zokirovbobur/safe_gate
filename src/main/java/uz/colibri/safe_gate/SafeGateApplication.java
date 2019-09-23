package uz.colibri.safe_gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
@RestController
@RequestMapping
@SpringBootApplication
public class SafeGateApplication {

    @PostMapping
    public Map<String,Object> test(){
        final String uri = "http://67.207.92.4:8080/online_print/appList";
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(uri,Map.class);
        }catch (ResourceAccessException e){
            return null;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SafeGateApplication.class, args);
    }

}
