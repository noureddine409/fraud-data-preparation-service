package ma.adria.frauddetectionservice.handler.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.dto.events.BeneficiaryInfoEventDto;
import ma.adria.frauddetectionservice.dto.events.EventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.model.event.BeneficiaryInfoEvent;
import ma.adria.frauddetectionservice.service.BeneficiaryInfoEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class BeneficiaryInfoEventHandler implements EventHandler {
    private final MapHelper mapHelper;
    private final BeneficiaryInfoEventService beneficiaryInfoEventService;

    @Override
    public EventDto handle(EventDto eventDto) {
        BeneficiaryInfoEventDto beneficiaryInfoEventDto = (BeneficiaryInfoEventDto) eventDto;
        BeneficiaryInfoEvent beneficiaryInfoEvent = mapHelper.map(beneficiaryInfoEventDto, BeneficiaryInfoEvent.class);
        log.info("Mapped BeneficiaryInfoEventDto to BeneficiaryInfoEvent entity : {}", beneficiaryInfoEvent);
        BeneficiaryInfoEvent savedEvent = beneficiaryInfoEventService.save(beneficiaryInfoEvent);
        log.info("Saved BeneficiaryInfoEvent: {}", savedEvent);
        return mapHelper.map(savedEvent, BeneficiaryInfoEventDto.class);
    }
}
