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
public class ChangeInfoEventDto extends EventDto {
    private boolean emailChanged;
    private boolean phoneChanged;
    private boolean adressChanged;
    private boolean contratChanged;
    private boolean passwordChanged;
    private boolean forgotPassword;

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.CHANGE_INFO;
    }
}
