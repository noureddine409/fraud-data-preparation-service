package ma.adria.frauddetectionservice.model;

import java.time.LocalDateTime;

public class Virement extends Event{
    private Creditor creditor;
    private Account debitingAccount;
    private String type;
    private String executionDateType;
    private String reason;
    private String currency;
    private LocalDateTime entryDate;
    private LocalDateTime executionDate;
    private ExecutionFrequency executionFrequency;

}
