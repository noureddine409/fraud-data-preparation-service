package ma.adria.frauddetectionservice.model;

import java.util.List;

public class MultipleVirement extends Virement{
    private List<Creditor> creditors;
    private int nombreOperations;
}
