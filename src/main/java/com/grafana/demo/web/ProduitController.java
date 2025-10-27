package com.grafana.demo.web;

import com.grafana.demo.entities.Produit;
import com.grafana.demo.model.Post;
import com.grafana.demo.repository.ProductRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProduitController {

    private final ProductRepository productRepository;
    private final RestClient restClient;

    public ProduitController(ProductRepository productRepository,RestClient.Builder restclient) {
        this.productRepository = productRepository;
          this.restClient=restclient
                  .baseUrl("https://jsonplaceholder.typicode.com")
                  .build();
    }
    @GetMapping("/products")
    public List<Produit> getAllProduit(){
        return productRepository.findAll();
    }
    @GetMapping("/posts")
    public List<Post> getAllPost(){
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});
    }
}
