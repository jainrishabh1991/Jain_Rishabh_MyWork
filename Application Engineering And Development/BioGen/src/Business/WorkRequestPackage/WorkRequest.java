/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.UserAccountPackage.UserAccount;

/**
 *
 * @author kRISH
 */
public abstract class WorkRequest {

    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private String sendingDate;
    private String receivingDate;
    
    public final static String Done = "Done";
    public final static String Recieve = "Recieved";
    public final static String UnderPro = "Under Process";
    public final static String Sent = "Sent";
    public final static String Alert = "Alert";

    public WorkRequest() {
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(String sendingDate) {
        this.sendingDate = sendingDate;
    }

    public String getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(String receivingDate) {
        this.receivingDate = receivingDate;
    }
    
    

}
