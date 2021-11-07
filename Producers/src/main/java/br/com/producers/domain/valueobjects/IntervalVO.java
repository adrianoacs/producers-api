package br.com.producers.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntervalVO {

    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;

}
