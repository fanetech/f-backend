package fanetech.tech.fbackend.repository;

import fanetech.tech.fbackend.entites.Sentiment;
import fanetech.tech.fbackend.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {
    List<Sentiment> findByTypeSentiment(TypeSentiment TypeSentiment);
}
