package br.com.producers.application.component.impl;

import br.com.producers.application.component.FileReaderComp;
import br.com.producers.domain.entities.Indication;
import br.com.producers.infraestructure.repositories.WinnerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

@Component
public class FileReaderCompImpl implements FileReaderComp {

    @Value("${loadFile}")
    Resource movieList;

    private final WinnerRepository winnerRepository;

    FileReaderCompImpl(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }

    @PostConstruct
    @Override
    public void readFile() {

        try {
            var fr = new FileReader(movieList.getFile());
            BufferedReader br = new BufferedReader(fr);
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                var item = line.split(";");
                var producers = item[3].toUpperCase(Locale.ROOT).split("\\sAND\\s|,\\s");
                Arrays.stream(producers).sequential().forEach(producer -> {
                    winnerRepository.save(Indication.builder()
                            .year(Integer.parseInt(item[0]))
                            .title(item[1])
                            .studio(item[2])
                            .producer(producer)
                            .winner(getWinner(item))
                            .build());
                });

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo 'movielist.csv' não encontrado no diretório 'resources' da aplicação.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro na leitura do arquivo de entrada. " +
                    "Certifique-se que o mesmo esteja na estrutura correta");
        }
    }

    private boolean getWinner(String[] s) {
        if (s.length == 4) {
            return false;
        }
        return s[4].toUpperCase(Locale.ROOT).equals("YES");
    }
}
