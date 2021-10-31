package com.rentCloud.cloud.app.servicies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Genera los get y set
@NoArgsConstructor //Genera el constructor vacio
@AllArgsConstructor //Genera el constructor con argumentos
public class StatusReservas {
    private Integer completed;
    private Integer cancelled;
}
