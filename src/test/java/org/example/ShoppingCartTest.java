package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart testCart;
    private Product product1;
    private Product product2;

    @BeforeEach
    protected void setUp(){
        // Questo metodo viene eseguito PRIMA di ogni test
        // Così ogni test parte con un carrello nuovo
        testCart = new ShoppingCart();
        product1 = new Product("Libro", 10.50);
        product2 = new Product("Penna", 2.30);
    }


    //TEST: Quando creato, il carrello ha 0 items
    @Test
    public void testNewCartHasZeroItems(){
        assertEquals(0, testCart.getItemCount(),
                "un carrello appena creato dovrebbe avere 0 items");
    }

    //TEST 2: Quando svuotato, il carrello ha 0 items
    @Test
    public void testEmptyCartHasZeroItems(){
        //Aggiungo alcuni prodotti
        testCart.addItem(product1);
        testCart.addItem(product2);

        //Svuoto il carrello
        testCart.empty();

        //Verifico che sia vuoto
        assertEquals(0, testCart.getItemCount(),
                "Un carrello  svuotato dovrebbe avere 0 items");
    }

    //TEST 3: Quando aggiungo un prodotto, il numero di items aumenta
    @Test
    public void testAddItemIncreasesCount(){
        //Stato iniziale
        int initialCount = testCart.getItemCount();

        //Aggiungo un product
        testCart.addItem(product1);

        //Verifico che il conteggio sia aumentato di 1
        assertEquals(initialCount + 1, testCart.getItemCount(),
                "Aggiungendo un item, il conteggio dovrebbe aumentare di 1");
    }

    //TEST 4: Quando aggiungo un prodotto, il balance aumenta del prezzo del prodotto
    @Test
    public  void testAddItemIncreaseBValance(){
        //Stato iniziale
        double initialBalance = testCart.getBalance();

        //Aggiungo un prodotto
        testCart.addItem(product1);

        //Verifico che il balance sia aumentato del prezzo del prodotto
        assertEquals(initialBalance + product1.getPrice(),
                testCart.getBalance(),
                0.01,
                "Il balance dovrebbe aumentare del prezzo del prodotto");
    }

    //TEST 5: Quando rimuovo un item, il numero di item diminuisce
    @Test
    public void testRemoveItemDecreaseCount() throws ProductNotFoundException{
        //Aggiungo due prodotti
        testCart.addItem(product1);
        testCart.addItem(product2);

        int countBeforeRemoval = testCart.getItemCount();


        testCart.removeItem(product1);

        assertEquals(countBeforeRemoval - 1, testCart.getItemCount(),
                "Rimuovendo un item il conteggio dovrebbe calare di 1");
    }

    //TEST 6: Rimuovere un prodotto non presente lancia ProductNotFountException
    @Test
    public void testRemoveNonExistentItemThrowsException(){
        testCart.addItem(product1);
        try {
            testCart.removeItem(product2);

            //Se arrivo qui il test deve fallire perché vogliamo l'eccezione
            fail("Dovrebbe essere lanciata ProductNotFoundException quando si rimuove un prodotto non presente");
        } catch (ProductNotFoundException e){
            //Comportamento CORRETTO
            //Eccezione lanciata come previsto
            //test passa
        }
    }
}