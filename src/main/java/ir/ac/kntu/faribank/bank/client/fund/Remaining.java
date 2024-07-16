package ir.ac.kntu.faribank.bank.client.fund;

import ir.ac.kntu.faribank.bank.Errors.InsufficientFundsException;
import ir.ac.kntu.faribank.bank.Errors.InvalidAmountException;
import ir.ac.kntu.faribank.bank.client.Client;

public class Remaining extends Fund {

    public Remaining(FundType type, Client client) {
        super(type, client);
    }

    public void remain(Double balance) throws InvalidAmountException, InsufficientFundsException {
        String balanceStr = String.valueOf(balance);
        int length = (int) Math.floor(balanceStr.length() * 0.75);
        
        String subBalanceStr = balanceStr.substring(balanceStr.length() - length, balanceStr.length());
        Double num = Double.parseDouble(subBalanceStr);

        int nearNum = (int) Math.pow(10, length);
        Double remain = nearNum - num;
        System.out.println("@@REMAIN: " + remain);

        if (getClient().getBalance() > remain) {
            transfer(String.valueOf(nearNum));
        }
    }
      
}
