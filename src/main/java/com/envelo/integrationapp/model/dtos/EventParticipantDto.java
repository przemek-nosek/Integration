package com.envelo.integrationapp.model.dtos;

import com.envelo.integrationapp.model.enums.Decision;
import com.envelo.integrationapp.model.enums.EventRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventParticipantDto {
    private Long userId;
    private EventRole eventRole;
    private Decision decision;
}
