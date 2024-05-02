package ma.adria.frauddetectionservice.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO {
    private Long id;
    private LocalDateTime timestamp;
    private LocalDateTime activityTime;
}
