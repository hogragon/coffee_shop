package edu.mum.coffee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


@Controller
public class HomeController {
        private final String WEB_SERVICE_URL = "http://localhost:8080";
    
	@GetMapping({"/", "/index", "/home"})
	public String homePage() {
            return "home";
	}
        
        @RequestMapping("/createPerson")
	public String addPersonPage() {
            return "addPerson";
	}
        
        @GetMapping("/allPeople")
	public String peoplePage(Model model) throws IOException {
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(WEB_SERVICE_URL+RestURIConstant.PERSON_ALL, String.class);
            ObjectMapper mapper = new ObjectMapper();
            List<Person> people = mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, Person.class));
            model.addAttribute("people", people);
            return "listPerson";
	}
        
        @GetMapping("/detailPerson/{id}")
	public String updatePersonPage(@PathVariable long id,Model model) throws IOException {
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(WEB_SERVICE_URL+"/person/public/"+id, String.class);
            ObjectMapper mapper = new ObjectMapper();
            Person p = mapper.readValue(result, Person.class);
            model.addAttribute("person", p);
            return "editPerson";
	}
        
        
        //This method received post request and forward it to REST
        //after receiving the result from REST, it will redirect to a web page
        @PostMapping("/updatePerson")
	public String updatePerson(HttpEntity<String> requestEntity){
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(WEB_SERVICE_URL+RestURIConstant.PERSON_UPDATE, requestEntity,Person.class);
            return "redirect:/allPeople";
	}

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
        
        @RequestMapping("/addProduct")
	public String addProductPage() {
            return "addProduct";
	}
        
        @PostMapping("/createProduct")
	public String createProduct(HttpEntity<String> requestEntity) {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(WEB_SERVICE_URL+RestURIConstant.PRODUCT_CREATE, requestEntity,Product.class);
            
            return "redirect:/addProduct";
	}
        
        @ModelAttribute("productType")
	public Map<String,String> productType() {
            Map<String,String> mapType = new HashMap<>();
            
            for(ProductType t:ProductType.values()){
                mapType.put(t.name(), t.name());
            }            
            return mapType;
	}
        
        @GetMapping("/allProduct")
	public String productPage(Model model) throws IOException {
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(WEB_SERVICE_URL+RestURIConstant.PRODUCT_LIST, String.class);
            ObjectMapper mapper = new ObjectMapper();
            List<Product> product = mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
            model.addAttribute("products", product);
            return "listProduct";
	}
        
        @GetMapping("/detailProduct/{id}")
	public String updateProductPage(@PathVariable long id,Model model) throws IOException {
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(WEB_SERVICE_URL+"/product/public/"+id, String.class);
            System.out.println("PRODUCT DETAIL: "+result);
            ObjectMapper mapper = new ObjectMapper();
            Product p = mapper.readValue(result, Product.class);
            model.addAttribute("product", p);
            return "editProduct";
	}
        
        @PostMapping("/updateProduct")
	public String updateProduct(HttpEntity<String> requestEntity){
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(WEB_SERVICE_URL+RestURIConstant.PRODUCT_UPDATE, requestEntity,Product.class);
            return "redirect:/allProduct";
	}
        
        @RequestMapping("/removeProduct/{id}")
	public String removeProduct(@PathVariable long id,HttpEntity<String>request){
            
            
              
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();     
//
            body.add("id", ""+id);
//
//            // Note the body object as first parameter!
            HttpEntity<MultiValueMap<String,String>> httpEntity = new HttpEntity<>(body, request.getHeaders());
            System.out.println("Header="+httpEntity.getHeaders().toString());
            System.out.println("Body="+httpEntity.getBody());
            RestTemplate restTemplate = new RestTemplate();
//            restTemplate.exchange(WEB_SERVICE_URL+RestURIConstant.PRODUCT_DELETE, HttpMethod.POST, request, Product.class);
            
            String result = restTemplate.getForObject(WEB_SERVICE_URL+"/product/public/delete/"+id, String.class);

            System.out.println(result);
            return "redirect:/allProduct";
	}
}
