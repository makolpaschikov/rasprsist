package com.example.rasprsist.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "smart_box")
public class SmartBox extends RepresentationModel<SmartBox> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID", strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {@Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy")}
    )
    private String id;                                 // Идендификатор

    private Integer layersNumber;                      // Количество слоев упаковки
    private Integer recommendedStorageTemperature;     // Рекомендуемая температура хранения
    private Integer storageTemperatureDuringTransport; // Температура хранения при транспортировке в градусах
    private String expirationDate;                     // Срок годности
    private Color currentColor;                        // Текущий цвет упаковки, означающий свежесть продукта
    private Double volume;                            // Объем упаковки

}
