package fanetech.tech.fbackend.service;

import fanetech.tech.fbackend.entites.Client;
import fanetech.tech.fbackend.entites.Sentiment;
import fanetech.tech.fbackend.enums.TypeSentiment;
import fanetech.tech.fbackend.repository.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SentimentService {

    private SentimentRepository sentimentRepository;
    private ClientService clientService;

    public SentimentService(SentimentRepository sentimentRepository, ClientService clientService) {
        this.sentimentRepository = sentimentRepository;
        this.clientService = clientService;
    }

    public void create(Sentiment sentiment){
        Client client = this.clientService.lireOuCreate(sentiment.getClient());
        sentiment.setClient(client);

        //Analyse
        if(sentiment.getTexte().contains("pas")){
            sentiment.setTypeSentiment(TypeSentiment.NEGATIF);
        }else{
            sentiment.setTypeSentiment(TypeSentiment.POSITIF);
        }
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> getAll(TypeSentiment type){
        if(type == null){
        return this.sentimentRepository.findAll();
        }else{
            return this.sentimentRepository.findByTypeSentiment(type);
        }
    }

    public Optional<Sentiment> getOne(int id){
        Optional<Sentiment> sentiment = this.sentimentRepository.findById(id);
        return sentiment;
    }


    public void delete(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
