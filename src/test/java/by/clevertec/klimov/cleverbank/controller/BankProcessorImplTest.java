package by.clevertec.klimov.cleverbank.controller;

import by.clevertec.klimov.cleverbank.app.processor.BankProcessorImpl;
import org.junit.jupiter.api.BeforeEach;

class BankProcessorImplTest {

  public static final double DEPOSIT_AMOUNT = 200.0;
  public static final double WITHDRAW_AMOUNT = 200.0;

  private BankProcessorImpl bankProcessorUnderTest;

  @BeforeEach
  void setUp() {
    bankProcessorUnderTest = new BankProcessorImpl();
  }

//  @Test
//  void testTransfer() {
//    final Transaction transaction = Transaction.builder().build();
//    final User sender = User.builder().build();
//    final User receiver = User.builder().build();
//
//    bankProcessorUnderTest.transfer(transaction, sender, receiver);
//
//
//  }
//  @Test
//  void testHandleTransaction_DoDeposit_IncreaseAmount() {
//    // Setup
//    final Transaction transaction =
//            Transaction.builder().type(TransactionType.DEPOSIT).amount(DEPOSIT_AMOUNT).build();
//
//    double startBalance = accountUnderTest.getBalance();
//
//    accountUnderTest.deposit(transaction);
//
//    // Verify the results
//    Assertions.assertEquals(startBalance + DEPOSIT_AMOUNT, accountUnderTest.getBalance());
//  }
//
//  @Test
//  void testHandleTransaction_DoWithdraw_DecreaseBalance() {
//    // Setup
//    final Transaction transaction =
//            Transaction.builder().type(TransactionType.WITHDRAWAL).amount(WITHDRAW_AMOUNT).build();
//
//    double startBalance = accountUnderTest.getBalance();
//
//    accountUnderTest.withdrawal(transaction);
//
//    // Verify the results
//    Assertions.assertEquals(startBalance - WITHDRAW_AMOUNT, accountUnderTest.getBalance());
//  }
}
