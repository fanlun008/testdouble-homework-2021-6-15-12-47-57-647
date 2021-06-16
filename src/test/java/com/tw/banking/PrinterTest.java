package com.tw.banking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class PrinterTest {

    @Test
    public void should_print_info_when_call_print() throws IOException {
        String datetime = "11/02/2021";
        int amount = 100;

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(datetime, amount));
        transactions.add(new Transaction(datetime, amount));

        Printer printer = new Printer(new Console());

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        printer.print(transactions);
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());

        String expectedContent = "DATE | AMOUNT | BALANCE\r\n" +
                "11/02/2021 | 100 | 200\r\n" +
                "11/02/2021 | 100 | 100\r\n";
        Assertions.assertEquals(expectedContent, allWrittenLines);

    }

}
