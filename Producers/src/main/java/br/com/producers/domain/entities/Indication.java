package br.com.producers.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="INDICATION")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Indication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CD_INDICATION")
    private Integer id;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "STUDIO")
    private String studio;

    @Column(name = "PRODUCER")
    private String producer;

    @Column(name = "WINNER")
    private boolean winner;

}
