package br.com.mesttra.roster.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerMessage implements Serializable {

    @JsonProperty("id")
    private Long id;

}
