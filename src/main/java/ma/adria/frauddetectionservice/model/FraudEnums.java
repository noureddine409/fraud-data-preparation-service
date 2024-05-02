package ma.adria.frauddetectionservice.model;

public class FraudEnums {
    public enum Canal {
        WEB,
        MOBILE,
        OTHER;

    }
    public enum ClientSegment {
        PARTICULAR,
        ENTERPRISE,
        PROFESSIONAL;

    }
    public enum EventStatus {
        SUCCESS,
        FAILED;

    }
    public enum ExecutionFrequencyType {
        YEARLY,
        MONTHLY,
        WEEKLY,
        DAILY;

    }
    public enum TransactionType {
        DEBIT,
        CREDIT;

    }
    public enum VirementType {
        COMPTE_A_COMPTE,
        VERS_BENEFICIAIRE,
        MULTIPLE;

    }



}
