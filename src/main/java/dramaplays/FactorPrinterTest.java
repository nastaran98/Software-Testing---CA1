package src.main.java.dramaplays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.main.java.dramaplays.FactorPrinter;
import src.main.java.dramaplays.model.Invoice;
import src.main.java.dramaplays.model.Performance;
import src.main.java.dramaplays.model.Play;

public class FactorPrinterTest {
    @Test
    public void testSingleTragedyPerformanceLessThan30() {
        Map<String, Play> plays = Map.of(
            "hamlet", new Play("Hamlet", "tragedy")
        );
        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("hamlet", 20)
        ));
        
        FactorPrinter printer = new FactorPrinter();
        String result = printer.print(invoice, plays);
        
        String expected = "Factor for BigCo\n" +
                          "  Hamlet: $400.00 (20 seats)\n" +
                          "Amount owed is $400.00\n" +
                          "You earned 0 credits\n";
        assertEquals(expected, result);
    }
    
    @Test
    public void testSingleTragedyPerformanceMoreThan30() {
    Map<String, Play> plays = Map.of(
        "hamlet", new Play("Hamlet", "tragedy")
    );
    Invoice invoice = new Invoice("BigCo", List.of(
        new Performance("hamlet", 35)
    ));
    
    FactorPrinter printer = new FactorPrinter();
    String result = printer.print(invoice, plays);
    
    String expected = "Factor for BigCo\n" +
                      "  Hamlet: $450.00 (35 seats)\n" +
                      "Amount owed is $450.00\n" +
                      "You earned 5 credits\n";
    assertEquals(expected, result);
    }

    @Test
    public void testSingleComedyPerformanceLessThan20() {
        Map<String, Play> plays = Map.of(
            "as-like", new Play("As You Like It", "comedy")
        );
        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("as-like", 15)
        ));
        
        FactorPrinter printer = new FactorPrinter();
        String result = printer.print(invoice, plays);
        
        String expected = "Factor for BigCo\n" +
                        "  As You Like It: $345.00 (15 seats)\n" +
                        "Amount owed is $345.00\n" +
                        "You earned 3 credits\n";
        assertEquals(expected, result);
    }

    @Test
    public void testSingleComedyPerformanceMoreThan20() {
    Map<String, Play> plays = Map.of(
        "as-like", new Play("As You Like It", "comedy")
    );
    Invoice invoice = new Invoice("BigCo", List.of(
        new Performance("as-like", 25)
    ));
    
    FactorPrinter printer = new FactorPrinter();
    String result = printer.print(invoice, plays);
    
    String expected = "Factor for BigCo\n" +
                      "  As You Like It: $500.00 (25 seats)\n" +
                      "Amount owed is $500.00\n" +
                      "You earned 5 credits\n";
    assertEquals(expected, result);
    }
    @Test
    public void testMultiplePerformancesDifferentTypes() {
    Map<String, Play> plays = Map.of(
        "hamlet", new Play("Hamlet", "tragedy"),
        "as-like", new Play("As You Like It", "comedy")
    );
    Invoice invoice = new Invoice("BigCo", List.of(
        new Performance("hamlet", 55),
        new Performance("as-like", 35)
    ));
    
    FactorPrinter printer = new FactorPrinter();
    String result = printer.print(invoice, plays);
    
    String expected = "Factor for BigCo\n" +
                      "  Hamlet: $650.00 (55 seats)\n" +
                      "  As You Like It: $580.00 (35 seats)\n" +
                      "Amount owed is $1,230.00\n" +
                      "You earned 37 credits\n";
    assertEquals(expected, result);

    }

    @Test
    public void testUnknownPlayType() {
        Map<String, Play> plays = Map.of(
            "othello", new Play("Othello", "history")
        );
        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("othello", 40)
        ));
        
        FactorPrinter printer = new FactorPrinter();
        try {
            printer.print(invoice, plays);
            fail("Expected an Error to be thrown");
        } catch (Error e) {
            assertEquals("unknown type: history", e.getMessage());
        }
    }

    @Test
    public void testZeroAudienceTragedy() {
        Map<String, Play> plays = Map.of(
            "hamlet", new Play("Hamlet", "tragedy")
        );
        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("hamlet", 0)
        ));
        
        FactorPrinter printer = new FactorPrinter();
        String result = printer.print(invoice, plays);
        
        String expected = "Factor for BigCo\n" +
                        "  Hamlet: $400.00 (0 seats)\n" +
                        "Amount owed is $400.00\n" +
                        "You earned 0 credits\n";
        assertEquals(expected, result);
    }

    @Test
    public void testZeroAudienceComedy() {
        Map<String, Play> plays = Map.of(
            "as-like", new Play("As You Like It", "comedy")
        );
        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("as-like", 0)
        ));
        
        FactorPrinter printer = new FactorPrinter();
        String result = printer.print(invoice, plays);
        
        String expected = "Factor for BigCo\n" +
                        "  As You Like It: $300.00 (0 seats)\n" +
                        "Amount owed is $300.00\n" +
                        "You earned 0 credits\n";
        assertEquals(expected, result);
    }






}
