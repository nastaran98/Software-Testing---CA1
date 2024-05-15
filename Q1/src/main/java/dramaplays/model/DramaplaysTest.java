package src.main.java.dramaplays.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class DramaplaysTest {

    @Test
    public void testPlayConstructorWithValidInputs() {
        Play play = new Play("Hamlet", "Tragedy");
        assertNotNull(play);
        assertEquals("Hamlet", play.name);
        assertEquals("Tragedy", play.type);
    }

    @Test
    public void testPlayConstructorWithNullName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Play(null, "Tragedy");
        });

        String expectedMessage = "Name cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPlayConstructorWithEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Play("", "Tragedy");
        });

        String expectedMessage = "Name cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPlayConstructorWithNullType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Play("Hamlet", null);
        });

        String expectedMessage = "Type cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPlayConstructorWithEmptyType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Play("Hamlet", "");
        });

        String expectedMessage = "Type cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPerformanceConstructorWithValidInputs() {
        Performance performance = new Performance("play1", 100);
        assertNotNull(performance);
        assertEquals("play1", performance.getPlayID());
        assertEquals(100, performance.getAudience());
    }

    @Test
    public void testPerformanceConstructorWithNullID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Performance(null, 100);
        });

        String expectedMessage = "Play ID cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPerformanceConstructorWithEmptyID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Performance("", 100);
        });

        String expectedMessage = "Play ID cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPerformanceConstructorWithNegativeAudience() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Performance("play1", -1);
        });

        String expectedMessage = "Audience cannot be negative";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSetAudienceWithNegativeValue() {
        Performance performance = new Performance("play2", 100);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            performance.setAudience(-1);
        });

        String expectedMessage = "Audience cannot be negative";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testInvoiceConstructorWithValidInputs() {
        Performance performance1 = new Performance("play1", 100);
        Performance performance2 = new Performance("play2", 200);
        List<Performance> performances = List.of(performance1, performance2);

        Invoice invoice = new Invoice("Customer1", performances);
        assertNotNull(invoice);
        assertEquals("Customer1", invoice.getCustomer());
        assertEquals(2, invoice.getPerformances().size());
        assertTrue(invoice.getPerformances().contains(performance1));
        assertTrue(invoice.getPerformances().contains(performance2));
    }

    @Test
    public void testInvoiceConstructorWithNullCustomer() {
        Performance performance = new Performance("play1", 100);
        List<Performance> performances = List.of(performance);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Invoice(null, performances);
        });

        String expectedMessage = "Customer cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testInvoiceConstructorWithEmptyCustomer() {
        Performance performance = new Performance("play1", 100);
        List<Performance> performances = List.of(performance);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Invoice("", performances);
        });

        String expectedMessage = "Customer cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testInvoiceConstructorWithNullPerformances() {
        Invoice invoice = new Invoice("Customer1", null);
        assertNotNull(invoice);
        assertEquals("Customer1", invoice.getCustomer());
        assertTrue(invoice.getPerformances().isEmpty());
    }

}
