package ma.adria.frauddetectionservice.Event;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.model.Event;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "changeInfo_event")
public class ChangeInfoEvent extends Event {
    private boolean emailChanged;
    private boolean phoneChanged;
    private boolean adressChanged;
    private boolean contratChanged;
    private boolean passwordChanged;
    private boolean forgotPassword;

}
