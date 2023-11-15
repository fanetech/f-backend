package fanetech.tech.fbackend.controller;

import fanetech.tech.fbackend.entites.Sentiment;
import fanetech.tech.fbackend.enums.TypeSentiment;
import fanetech.tech.fbackend.service.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "sentiment", produces = "application/json")
public class SentimentController {

    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void create(@RequestBody Sentiment sentiment){
        this.sentimentService.create(sentiment);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public @ResponseBody List<Sentiment> getAll(@RequestParam(required = false) TypeSentiment type){
        return this.sentimentService.getAll(type);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("{id}")
    public Optional<Sentiment> getOne(@PathVariable int id){
        return this.sentimentService.getOne(id);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
         this.sentimentService.delete(id);
    }
}
