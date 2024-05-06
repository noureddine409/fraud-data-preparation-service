package ma.adria.frauddetectionservice.model;

import ma.adria.frauddetectionservice.enums.CarteTransactionType;
import ma.adria.frauddetectionservice.enums.TransactionType;

import java.math.BigDecimal;

public class CarteTransaction extends Event{
    private String cardNumber;
    private String libelleOperation;
    private String dateOperation;
    private  String devise;
    private BigDecimal montant;
    private CarteTransactionType type;
    private TransactionType transactionType;


}
