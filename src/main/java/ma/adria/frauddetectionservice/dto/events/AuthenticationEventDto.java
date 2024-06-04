package ma.adria.frauddetectionservice.dto.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.common.CoreConstants;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class AuthenticationEventDto extends EventDto {
    @Override
    public String getEventName() {
        return CoreConstants.EventNames.AUTHENTICATION;
    }
}
