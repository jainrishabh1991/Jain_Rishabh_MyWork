/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import java.util.ArrayList;

/**
 *
 * @author kRISH
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> OrderWorkRequestList;

    public WorkQueue() {
        OrderWorkRequestList = new ArrayList<WorkRequest>();
    }

    public ArrayList<WorkRequest> getWorkRequestQueue() {
        return OrderWorkRequestList;
    }   
}
