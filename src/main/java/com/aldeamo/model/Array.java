package com.aldeamo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "arrays")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Array {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 11)
    private Integer id;

    @Column(name ="input_array",nullable = false,length = 20)
    private String inputArray;


}
