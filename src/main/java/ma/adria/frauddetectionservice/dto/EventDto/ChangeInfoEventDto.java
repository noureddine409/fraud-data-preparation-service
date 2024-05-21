package ma.adria.frauddetectionservice.dto.EventDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class ChangeInfoEventDto extends EventDto {
    private boolean emailChanged;
    private boolean phoneChanged;
    private boolean adressChanged;
    private boolean contratChanged;
    private boolean passwordChanged;
    private boolean forgotPassword;
}
