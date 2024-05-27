package ma.adria.frauddetectionservice.handler.impl;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.AccountToAccountVirementEvent;
import ma.adria.frauddetectionservice.Event.ToBeneficiaryVirementEvent;
import ma.adria.frauddetectionservice.dto.EventDto.AccountToAccountVirementEventDto;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import ma.adria.frauddetectionservice.dto.EventDto.ToBeneficiaryVirementEventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.service.ToBeneficiaryVirementEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ToBeneficiaryVirementEventHandler implements EventHandler {
    private final MapHelper mapHelper;

    private final ToBeneficiaryVirementEventService toBeneficiaryVirementEventService;
    @Override
    public void handle(EventDto eventDto) {
        ToBeneficiaryVirementEventDto toBeneficiaryVirementEventDto= (ToBeneficiaryVirementEventDto) eventDto;
        ToBeneficiaryVirementEvent toBeneficiaryVirementEvent=mapHelper.map(toBeneficiaryVirementEventDto, ToBeneficiaryVirementEvent.class);
        log.info("Mapped ToBeneficiaryVirementEventDto to ToBeneficiaryVirementEvent entity : {}",toBeneficiaryVirementEvent);
        ToBeneficiaryVirementEvent savedEvent = toBeneficiaryVirementEventService.save(toBeneficiaryVirementEvent);
        log.info("Saved ToBeneficiaryVirementEvent: {}", savedEvent);
    }
}