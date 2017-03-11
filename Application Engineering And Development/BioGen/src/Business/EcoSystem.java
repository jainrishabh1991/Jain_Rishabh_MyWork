/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.NetworkPackage.Network;
import Business.OrganizationPackage.Organization;
import Business.RolePackage.Role;
import Business.RolePackage.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Atul
 */
public class EcoSystem extends Organization{
     
    private static EcoSystem ecoSystem;
    private ArrayList<Network> networkList;

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
    }

    

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public Network createAndAddNetwork()
    {
        Network network = new Network();
        networkList.add(network);
        return network;
    }
    
     public static EcoSystem getInstance()
    {
        if(ecoSystem==null)
        {
            ecoSystem = new EcoSystem();
        }
        return ecoSystem;   
    }
     
    @Override
    public ArrayList<Role> getSupportedRole() {
    ArrayList<Role> roleList = new ArrayList();
    roleList.add(new SystemAdminRole());
    return roleList;
    }
    
}
