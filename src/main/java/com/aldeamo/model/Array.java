package com.aldeamo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "arrays")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Array  implements Serializable {

    private static final long serialVersionUID = -8451324160075816598L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 11)
    private Integer id;

    @Column(name ="input_array",nullable = false,length = 20)
    private String inputArray;


}
