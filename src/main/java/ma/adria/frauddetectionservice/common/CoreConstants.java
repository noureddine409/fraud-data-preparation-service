package ma.adria.frauddetectionservice.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoreConstants {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class EventNames {
        public static final String AUTHENTICATION = "AUTHENTICATION";
        public static final String REMISE_ORDRE = "REMISE_ORDRE";
        public static final String PAYEMENT_FACTURE = "PAYEMENT_FACTURE";
        public static final String CARTE_TRANSACTION = "CARTE_TRANSACTION";
        public static final String BENEFICIARY_INFO = "BENEFICIARY_INFO";
        public static final String ACCOUNTOACCOUNT_VIREMENT = "ACCOUNTOACCOUNT_VIREMENT";
        public static final String TOBENEFICIARY_VIREMENT = "TOBENEFICIARY_VIREMENT";
        public static final String MULTIPLE_VIREMENT = "MULTIPLE_VIREMENT";
        public static final String DEMANDE_CHEQUIER = "DEMANDE_CHEQUIER";
        public static final String DEMANDE_LCN = "DEMANDE_LCN";
        public static final String DEMANDE_RECALCUL_CODE_PIN = "DEMANDE_RECALCUL_CODE_PIN";
        public static final String DEMANDE_OPPOSITION_CARTE = "DEMANDE_OPPOSITION_CARTE";
        public static final String RECHARGE_CARTE = "RECHARGE_CARTE";
        public static final String DEMANDE_OPPOSITION_CHEQUE = "DEMANDE_OPPOSITION_CHEQUE";
        public static final String CHANGE_INFO = "CHANGE_INFO";
    }
}
