package by.clevertec.klimov.cleverbank.entity;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

  private long id;

  private double amount;

  private Date date;

  private UUID uuid;

  private String authorizationCode;

  private User receiver;

  private User sender;
}
