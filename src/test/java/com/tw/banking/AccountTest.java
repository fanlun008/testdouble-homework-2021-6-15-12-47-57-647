package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AccountTest {

    @Test
    public void should_call_transactionRepository_function_when_deposit_and_withdraw() {

        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);

        Account account = new Account(transactionRepository, printer);

        account.deposit(100);
        account.withdraw(100);
        account.printStatement();

        verify(transactionRepository, times(1)).addWithdraw(anyInt());
        verify(transactionRepository, times(1)).addDeposit(anyInt());
        verify(printer, times(1)).print(anyList());

    }



}
