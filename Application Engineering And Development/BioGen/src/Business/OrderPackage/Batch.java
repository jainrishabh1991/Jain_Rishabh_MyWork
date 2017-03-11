/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrderPackage;

import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class Batch {
    
    private String batchID;
    private ArrayList<Packet> packetList;
    private int batchPrice;
    private static int c = 000;
    
    public Batch(){
        ++c;
        batchID = "B"+c;
        packetList = new ArrayList<Packet>();
    }

    public static int getC() {
        return c;
    }

    public static void setC(int c) {
        Batch.c = c;
    }

    public String getBatchID() {
        return batchID;
    }

    public ArrayList<Packet> getPacketList() {
        return packetList;
    }

    public int getBatchPrice() {
        return batchPrice;
    }

    public void setBatchPrice(int batchPrice) {
        this.batchPrice = batchPrice;
    }
    
    public Packet newPacket(){
        Packet p = new Packet();
        packetList.add(p);
        return p;
    }
    
    public void removePacket(Packet p){
        packetList.remove(p);
    }

    @Override
    public String toString() {
        return batchID;
    }
    
           
}
