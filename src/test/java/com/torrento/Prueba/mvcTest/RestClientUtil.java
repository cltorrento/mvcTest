package test.java.com.torrento.Prueba.mvcTest;

import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import main.java.com.torrento.Prueba.mvcTest.entity.User;


public class RestClientUtil {
    public void getUserByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/user/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User.class, 1);
        User usr = responseEntity.getBody();
        System.out.println("Id:"+usr.getId()+", Name:"+usr.getName()+", Surname:"+usr.getSurname());      
    }
    public void getAllUsersDemo() {
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/users";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<User[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User[].class);
        User[] users = responseEntity.getBody();
        for(User usr : users) {
              System.out.println("Id:"+usr.getId()+", Name:"+usr.getName()+", Surname: "+usr.getSurname());
        }
    }
    public void addUserDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/user";
        User objUser = new User();
        objUser.setName("Temporal Name");
        objUser.setSurname("Temporal Surname");
        HttpEntity<User> requestEntity = new HttpEntity<User>(objUser, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateUserDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/user";
        User objUser = new User();
        objUser.setId(1);
        objUser.setName("Update:Name From Temporal");
        objUser.setSurname("Java");
        HttpEntity<User> requestEntity = new HttpEntity<User>(objUser, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteUserDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/user/{id}";
        HttpEntity<User> requestEntity = new HttpEntity<User>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getArticleByIdDemo();
    	util.getAllUsersDemo();
    	//util.addArticleDemo();
    	//util.updateArticleDemo();
    	//util.deleteArticleDemo();
    }
}
