package br.com.producers.infraestructure.repositories;

import br.com.producers.domain.entities.Indication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WinnerRepository extends CrudRepository<Indication, Integer> {

    @Query(value = "SELECT i FROM Indication i WHERE i.winner = true ORDER BY i.year")
    List<Indication> findAllWinningIndications();

    @Query(value = "SELECT DISTINCT i.producer FROM Indication i WHERE i.winner = true")
    List<String> findAllWinnerProducer();
}
