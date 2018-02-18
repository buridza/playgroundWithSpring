package by.itacademy.entity.account.provider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Requisites {
    @Column(unique = true, nullable = false, length = 50)
    private String receiver;
    @Column(nullable = false)
    private Long interbranchTurnover;
    @Column(nullable = false, unique = true)
    private Long taxpayerIdentificationNumber;
    @Column(nullable = false, unique = true)
    private String paymentAccount;


}
