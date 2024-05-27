package ma.adria.frauddetectionservice.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.BeneficiaryInfoEvent;
import ma.adria.frauddetectionservice.dto.EventDto.BeneficiaryInfoEventDto;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.service.BeneficiaryInfoEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class BeneficiaryInfoEventHandler implements EventHandler {
    private final MapHelper mapHelper;
    private final BeneficiaryInfoEventService beneficiaryInfoEventService;
    @Override
    public void handle(EventDto eventDto) {
        BeneficiaryInfoEventDto beneficiaryInfoEventDto= (BeneficiaryInfoEventDto) eventDto;
        BeneficiaryInfoEvent beneficiaryInfoEvent = mapHelper.map(beneficiaryInfoEventDto, BeneficiaryInfoEvent.class);
        log.info("Mapped BeneficiaryInfoEventDto to BeneficiaryInfoEvent entity : {}", beneficiaryInfoEvent);
        BeneficiaryInfoEvent savedEvent = beneficiaryInfoEventService.save(beneficiaryInfoEvent);
        log.info("Saved BeneficiaryInfoEvent: {}", savedEvent);

    }
}
