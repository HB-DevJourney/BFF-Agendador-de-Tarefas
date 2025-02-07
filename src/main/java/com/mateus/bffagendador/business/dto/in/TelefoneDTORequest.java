package com.mateus.bffagendador.business.dto.in;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelefoneDTORequest {

    private String ddd;
    private String numero;
}
