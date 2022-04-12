package com.envelo.integrationapp.model.dtos.info;

import com.envelo.integrationapp.model.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventDtoInfo {

    private long id;
    private String title;
    private EventPlaceDtoInfo eventPlaceDtoInfo;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EventParticipantDtoInfo eventParticipantDtoInfo;
    private EventStatus eventStatus;

}
