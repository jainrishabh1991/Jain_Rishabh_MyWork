/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrderPackage;

import Business.DrugPackage.Drug;
import java.util.Random;

/**
 *
 * @author Rishabh
 */
public class Packet {

    private String packetID;
    private int random;
    private Drug drug;
    private String packetExpiryDate;
    private int packetPrice;
    private static int c = 000;

    public Packet() {
        ++c;
        packetID = "P" + c;
        Random r = new Random();
        random = r.nextInt(1000);
    }

    public static int getC() {
        return c;
    }

    public static void setC(int c) {
        Packet.c = c;
    }

    public int getRandom() {
        return random;
    }
    
    public String getPacketID() {
        return packetID;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public String getPacketExpiryDate() {
        return packetExpiryDate;
    }

    public void setPacketExpiryDate(String packetExpiryDate) {
        this.packetExpiryDate = packetExpiryDate;
    }

    public int getPacketPrice() {
        return packetPrice;
    }

    public void setPacketPrice(int packetPrice) {
        this.packetPrice = packetPrice;
    }

    @Override
    public String toString() {
        return packetID;
    }
}
