package br.com.producers.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WinnerIntervalsVO {

    private List<IntervalVO> min;
    private List<IntervalVO> max;

}
