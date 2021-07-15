package Chapter3.ch03;

public class VIPCustomer extends Customer {

    double salesRatio;
    String agentID;

    public VIPCustomer() {
        super(0, "no-name");
        bonusRatio = 0.05;
        salesRatio = 0.1;
        customerGrade = "VIP";

        System.out.println("VIPCustomer 호출");
    }

    public VIPCustomer(int customerID, String customerName) {
        super(customerID, customerName);

        customerGrade = "VIP";
        bonusRatio = 0.05;
        salesRatio = 0.1;
    }

    public String getAgentID() {
        return agentID;
    }

}
