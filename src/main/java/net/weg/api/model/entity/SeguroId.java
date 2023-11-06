package net.weg.api.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Embeddable
public class SeguroId implements Serializable {
    private Integer seguradoraId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seguroid;
    private static  Integer nextId = 1;
    protected SeguroId(){
        seguroid = nextId;
        nextId++;
    }
}

