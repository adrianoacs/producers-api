package br.com.producers.infraestructure.repositories;


import br.com.producers.domain.entities.Indication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinnerRepositoryTest {

    @Value("classpath:movielistTest.csv")
    Resource movieList;

    @Autowired
    private WinnerRepository winnerRepository;

    @Test
    void findAllWinningIndications() {
//        try {
//            var fr = new FileReader(movieList.getFile());
//            BufferedReader br = new BufferedReader(fr);
//            String line;
//            br.readLine();
//            var indications = new ArrayList<Indication>();
//            while((line = br.readLine())!=null)
//            {
//                var item = line.split(";");
//                indications.add(Indication.builder()
//                        .year(Integer.parseInt(item[0]))
//                        .title(item[1])
//                        .studio(item[2])
//                        .producer(item[3])
//                        .winner(getWinner(item))
//                        .build());
//            }
//
//            var winners = indications.stream().filter(indication -> indication.isWinner())
//                    .collect(Collectors.toList());
//            var winnersRep = winnerRepository.findAllWinningIndications();
//
//            assertEquals(winners.size(), winnersRep.size());
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private boolean getWinner(String[] s) {
        if(s.length == 4){
            return false;
        }
        return s[4].toUpperCase(Locale.ROOT).equals("YES");
    }

    @Test
    void findAllWinnerProducer() {
    }
}