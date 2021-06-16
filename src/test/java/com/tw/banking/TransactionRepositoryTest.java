package com.tw.banking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TransactionRepositoryTest {

    @Test
    public void should_has_2_records_when_addDeposit_twice() {

        Clock clock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(clock);

        int amount = 100;
        when(clock.todayAsString()).thenReturn("no matter");
        transactionRepository.addDeposit(amount);
        transactionRepository.addDeposit(amount);

        Assertions.assertEquals(2, transactionRepository.allTransactions().size());

    }

    @Test
    public void should_has_2_records_when_addWithdraw_twice() {
        Clock clock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(clock);

        int amount = 100;
        when(clock.todayAsString()).thenReturn("no matter");
        transactionRepository.addWithdraw(amount);
        transactionRepository.addWithdraw(amount);

        Assertions.assertEquals(2, transactionRepository.allTransactions().size());
    }

    @Test
    public void should_call_todayAsString_when_call_addDeposit() {
        Clock clock = spy(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        transactionRepository.addWithdraw(100);
        transactionRepository.addWithdraw(100);
        verify(clock, times(2)).todayAsString();
    }

}
