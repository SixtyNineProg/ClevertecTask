package by.clevertec.klimov.cleverbank.app.processor;

import by.clevertec.klimov.cleverbank.entity.Account;
import by.clevertec.klimov.cleverbank.entity.User;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankProcessorImplTest {

  public static final double TRANSFER_AMOUNT = 200.0;
  public static final double DEPOSIT_AMOUNT = 200.0;
  public static final double WITHDRAW_AMOUNT = 200.0;
  public static final int START_BALANCE = 1000;

  private BankProcessorImpl bankProcessorImplUnderTest;

  @BeforeEach
  void setUp() {
    bankProcessorImplUnderTest = new BankProcessorImpl();
  }

  @Test
  void testTransfer_DoTransfer_ValidUserAmounts() {
    final User sender =
        User.builder()
            .account(
                Account.builder()
                    .transactions(new ArrayList<>(Collections.emptyList()))
                    .balance(START_BALANCE)
                    .build())
            .build();
    final User receiver =
        User.builder()
            .account(
                Account.builder()
                    .transactions(new ArrayList<>(Collections.emptyList()))
                    .balance(START_BALANCE)
                    .build())
            .build();

    double senderBalance = sender.getBalance();
    double receiverBalance = receiver.getBalance();

    bankProcessorImplUnderTest.transfer(sender, receiver, TRANSFER_AMOUNT);

    Assertions.assertEquals(senderBalance - TRANSFER_AMOUNT, sender.getBalance());
    Assertions.assertEquals(receiverBalance + TRANSFER_AMOUNT, receiver.getBalance());
  }

  @Test
  void testHandleTransaction_DoDeposit_IncreaseAmount() {
    final User user =
        User.builder()
            .account(
                Account.builder()
                    .transactions(new ArrayList<>(Collections.emptyList()))
                    .balance(START_BALANCE)
                    .build())
            .build();

    double startBalance = user.getBalance();

    bankProcessorImplUnderTest.deposit(user, DEPOSIT_AMOUNT);

    Assertions.assertEquals(startBalance + DEPOSIT_AMOUNT, user.getBalance());
  }

  @Test
  void testHandleTransaction_DoWithdraw_DecreaseBalance() {
    final User user =
        User.builder()
            .account(
                Account.builder()
                    .transactions(new ArrayList<>(Collections.emptyList()))
                    .balance(START_BALANCE)
                    .build())
            .build();

    double startBalance = user.getBalance();

    bankProcessorImplUnderTest.withdrawal(user, WITHDRAW_AMOUNT);

    // Verify the results
    Assertions.assertEquals(startBalance - WITHDRAW_AMOUNT, user.getBalance());
  }
}