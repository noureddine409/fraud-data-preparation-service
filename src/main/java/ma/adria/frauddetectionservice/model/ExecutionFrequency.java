package ma.adria.frauddetectionservice.model;

import ma.adria.frauddetectionservice.enums.ExecutionFrequencyType;

import java.time.LocalDateTime;

public class ExecutionFrequency {
    private ExecutionFrequencyType frequency;
    private LocalDateTime firstTransactionDateTime;

}
