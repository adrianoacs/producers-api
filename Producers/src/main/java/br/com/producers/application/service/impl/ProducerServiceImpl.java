package br.com.producers.application.service.impl;

import br.com.producers.application.service.ProducerService;
import br.com.producers.domain.entities.Indication;
import br.com.producers.domain.valueobjects.IntervalVO;
import br.com.producers.domain.valueobjects.WinnerIntervalsVO;
import br.com.producers.infraestructure.repositories.WinnerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProducerServiceImpl implements ProducerService {

    private WinnerRepository winnerRepository;

    ProducerServiceImpl(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }


    @Override
    public WinnerIntervalsVO getWinners() {

        var allWinnerProducer = winnerRepository.findAllWinnerProducer();
        var allIndications = winnerRepository.findAllWinningIndications();
        var winnerIntervalsVO = WinnerIntervalsVO.builder();
        var maxInterval = new ArrayList<IntervalVO>();
        var minInterval = new ArrayList<IntervalVO>();
        allWinnerProducer.stream().forEach(producer -> {
            var winners = allIndications.stream().filter(indication ->
                    indication.getProducer().equals(producer)).collect(Collectors.toList());
            getMinMaxInterval(producer, winners, maxInterval, minInterval);
        });


        sortList(minInterval, 1);
        sortList(maxInterval, -1);

        return winnerIntervalsVO
                .min(minInterval)
                .max(maxInterval)
                .build();
    }

    private void sortList(ArrayList<IntervalVO> minInterval, Integer fator) {
        Collections.sort(minInterval, (item1, item2) -> {
            if (item1.getInterval() > item2.getInterval()) {
                return 1 * fator;
            } else if (item1.getInterval() < item2.getInterval()) {
                return -1 * fator;
            } else {
                return 0;
            }
        });
    }

    private void getMinMaxInterval(String producer, List<Indication> winners, List<IntervalVO> maxInterval, List<IntervalVO> minInterval) {

        var intervals = getIntervals(producer, winners);

        if (intervals.size() != 0) {
            maxInterval.add(intervals.stream().min((first, second) -> {
                if (first.getInterval() > second.getInterval()) {
                    return 0;
                }
                return 1;
            }).get());

            minInterval.add(intervals.stream().min((first, second) -> {
                if (first.getInterval() < second.getInterval()) {
                    return 0;
                }
                return 1;
            }).get());
        }
    }

    private ArrayList<IntervalVO> getIntervals(String producer, List<Indication> winners) {
        var intervals = new ArrayList<IntervalVO>();
        for (int i = 0; i < winners.size(); i++) {
            var firstYear = winners.get(i).getYear();

            if (i + 1 == winners.size()) {
                continue;
            }
            var nextYear = winners.get(i + 1).getYear();
            intervals.add(IntervalVO.builder()
                    .producer(producer)
                    .interval(nextYear - firstYear)
                    .previousWin(firstYear)
                    .followingWin(nextYear)
                    .build());
        }
        return intervals;
    }
}
