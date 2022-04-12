package com.envelo.integrationapp.model.dtos.info;

import com.envelo.integrationapp.model.enums.Decision;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventParticipantDtoInfo {

    private Decision decision;

}
