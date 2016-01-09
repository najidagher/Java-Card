/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
////Que fait Cette Classe?

/*

C'est un exemple d'une Applet Javacard qui fait les conversions entre USD et LBP.
L'applet en question communique avec le simulateur JavaCard "Default Device".
La communication est faite a travers les APDU (Hexadecimal).
*/


package Converter;

import javacard.framework.*;


/**
 *
 * @author USER
 */
public class Converter extends Applet {
public final static byte  EPURSE_CLA = (byte) 0xA0;
public final static byte  CONVERT_USD = (byte) 0xB0;
public final static byte  CONVERT_LBP = (byte) 0xB2;

private short AMOUNT_CONVERTED  = (short) 0;
    /**
     * Installs this applet.
     *
     * @param bArray
     *            the array containing installation parameters
     * @param bOffset
     *            the starting offset in bArray
     * @param bLength
     *            the length in bytes of the parameter data in bArray
     */
    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new Converter();
    }

    /**
     * Only this class's install method should create the applet object.
     */
    protected Converter() {
        register();
    }

    /**
     * Processes an incoming APDU.
     *
     * @see APDU
     * @param apdu
     *            the incoming APDU
     */
    public void process(APDU apdu) {
        //
byte [] buffer = apdu.getBuffer();
if(this.selectingApplet())
    return;

if(buffer[ISO7816.OFFSET_CLA] !=EPURSE_CLA)
        ISOException.throwIt(ISO7816.SW_CLA_NOT_SUPPORTED);
short amount =(short)0;
short coe = (short)1500;
//short amount1 = (short)0;

 switch (buffer[ISO7816.OFFSET_INS]) {
     case CONVERT_LBP:

        apdu.setIncomingAndReceive();
         amount = Util.getShort(buffer, ISO7816.OFFSET_CDATA);
       //  if (amount <=0 || (short)(balance + amount)<=0)
      //   ISOException.throwIt(ISO7816.SW_WRONG_DATA);
       amount *=coe;
              AMOUNT_CONVERTED =  amount ;
            
             Util.setShort(buffer, (short)0,AMOUNT_CONVERTED );
         apdu.setOutgoingAndSend((short)0, (short)2);
         break;
              case CONVERT_USD:

        apdu.setIncomingAndReceive();
         amount = Util.getShort(buffer, ISO7816.OFFSET_CDATA);
       //  if (amount <=0 || (short)(balance + amount)<=0)
      //   ISOException.throwIt(ISO7816.SW_WRONG_DATA);
       amount /=coe;
              AMOUNT_CONVERTED =  amount ;

             Util.setShort(buffer, (short)0,AMOUNT_CONVERTED );
         apdu.setOutgoingAndSend((short)0, (short)2);
         break;

     default:
         ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);



 }
    }
}
