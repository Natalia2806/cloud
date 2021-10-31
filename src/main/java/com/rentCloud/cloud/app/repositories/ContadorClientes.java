package com.rentCloud.cloud.app.repositories;

import com.rentCloud.cloud.app.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Genera los get y set
@NoArgsConstructor //Genera el constructor vacio
@AllArgsConstructor //Genera el constructor con argumentos
public class ContadorClientes {
    private Long total;
    private Client client;

}
