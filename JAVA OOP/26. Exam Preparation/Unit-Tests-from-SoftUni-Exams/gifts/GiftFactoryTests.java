package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GiftFactoryTests {
    private GiftFactory giftFactory;

    private Gift gift;
    @Before
    public void setUp(){

        giftFactory = new GiftFactory();
        gift = new Gift("Gift",1.0);

    }
    @Test
    public void testCreateGift(){
        giftFactory.createGift(gift);
        assertEquals(1,giftFactory.getCount());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftWhoAlreadyExistsShouldThrow(){
        giftFactory.createGift(gift);
        giftFactory.createGift(gift);


    }
    @Test
    public void  testRemoveGift(){
        giftFactory.createGift(gift);

        String giftToRemove = "Gift";
        assertTrue(giftFactory.removeGift(giftToRemove));
    }
    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWhitNullName (){
        Gift gift1 = null;

        giftFactory.createGift(gift1);


        giftFactory.removeGift(null);


    }    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWhitWhitespaceName (){
        Gift gift1 = new Gift("    ",1212);

        giftFactory.createGift(gift1);
        giftFactory.removeGift("    ");

    }

    @Test
    public void testGetPresentsWhitLeastMagic(){
        Gift gift1 = new Gift("Gift1",11.1);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift);

     Gift expectedLessMagicGift =gift;
       Gift actualGift = giftFactory.getPresentWithLeastMagic();
        assertEquals(expectedLessMagicGift,actualGift);
    }
    @Test
    public void testGetPresent(){
        Gift gift1 = new Gift("Gift1",11.1);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift);




    assertEquals(gift,giftFactory.getPresent("Gift"));


    }
    @Test(expected = UnsupportedOperationException.class)
    public void testIsTrueToModifiedCollectionThrowException(){
    giftFactory.createGift(gift);
    giftFactory.getPresents().remove(gift);

    }







}
