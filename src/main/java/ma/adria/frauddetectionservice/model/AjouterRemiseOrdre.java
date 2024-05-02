package ma.adria.frauddetectionservice.model;

import ma.adria.frauddetectionservice.enums.Status;

import java.time.LocalDateTime;

public class AjouterRemiseOrdre extends Event{
   private String reference;
   private String natureRemise;
   private String formatRemiseOrdre;
   private String numContrat;
   private String donneurOrdre;
   private String compteDebit;
   private byte fichier;
   private LocalDateTime dateExecution;
   private Status status;
}
