package ir.ac.kntu.faribank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ir.ac.kntu.faribank.Controller.Main;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;
import ir.ac.kntu.faribank.bank.admin.Admin;
import ir.ac.kntu.faribank.bank.client.Client;
import ir.ac.kntu.faribank.bank.client.Contact;
import ir.ac.kntu.faribank.bank.client.support.Feature;
import ir.ac.kntu.faribank.bank.client.support.Request;
import ir.ac.kntu.faribank.bank.client.support.StateOfRequest;
import ir.ac.kntu.faribank.bank.client.transaction.TDeposit;
import ir.ac.kntu.faribank.bank.client.transaction.TTransfer;

public class BankApplication {
    public static void main(String[] args) throws DuplicatedItemException {
        Database.openConnection();

        String sql = "SELECT \"firstName\", \"lastName\", \"password\", \"nationalcode\", \"phoneNumber\" FROM public.\"clientInfo\"";

        Connection conn=Database.getConn();
        try {
            PreparedStatement st=conn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                try {
                    Client client=new Client(rs.getString("phoneNumber"),rs.getString("password"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("nationalcode"));
                    FariBank.getInstance().addClient(client);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }


        }catch (SQLException e){
            e.printStackTrace();
        }







//        try {
//            String content = new String(Files.readAllBytes(Paths.get("./fariBank.json")));
//
//            JSONObject data = new JSONObject(content);
//            JSONArray clientsJson = data.getJSONArray("clients");
//            JSONArray newClientsJson = data.getJSONArray("newClients");
//
//            for (int i = 0; i < clientsJson.length(); i++) {
//                JSONObject clientJson = clientsJson.getJSONObject(i);
//
//                try {
//                    Client client = new Client(clientJson.getString("phoneNumber"), clientJson.getString("password"),
//                            clientJson.getString("firstName"), clientJson.getString("lastName"),
//                            clientJson.getString("nationalCodeID"));
//
//                    client.setAdminAuthenText(clientJson.getString("adminAuthenText"));
//                    client.setCardNumber(clientJson.getString("cardNumber"));
//                    client.setAccountNumber(clientJson.getString("accountNumber"));
//                    client.addBalance(clientJson.getDouble("balance"));
//
//                    // Transaction
//                    JSONObject transactionsObject = clientJson.getJSONObject("transactions");
//
//                    JSONArray tDepositArray = transactionsObject.getJSONArray("tDeposit");
//                    for (int j = 0; j < tDepositArray.length(); j++) {
//                        JSONObject tDepositJson = tDepositArray.getJSONObject(j);
//                        TDeposit tDeposit = new TDeposit(tDepositJson.getDouble("newBalance"),
//                                tDepositJson.getDouble("deposit"));
//                        tDeposit.setDate(LocalDateTime.parse(tDepositJson.getString("date")));
//
//                        client.addTransactions(tDeposit);
//                    }
//
//                    JSONArray tTransferArray = transactionsObject.getJSONArray("tTransaction");
//                    for (int j = 0; j < tTransferArray.length(); j++) {
//                        JSONObject tTransferJson = tTransferArray.getJSONObject(j);
//                        TTransfer tTransfer = new TTransfer(tTransferJson.getDouble("transfer"),
//                                tTransferJson.getString("from"), tTransferJson.getString("to"),
//                                tTransferJson.getString("fromAccountNumber"),
//                                tTransferJson.getString("toAccountNumber"), tTransferJson.getDouble("newBalance"));
//                        tTransfer.setDate(LocalDateTime.parse(tTransferJson.getString("date")));
//
//                        client.addTransactions(tTransfer);
//                    }
//
//                    // Request
//                    JSONArray requestsArray = clientJson.getJSONArray("requests");
//                    for (int j = 0; j < requestsArray.length(); j++) {
//                        JSONObject requestsJson = requestsArray.getJSONObject(j);
//                        Request request = new Request(Feature.valueOf(requestsJson.getString("feature")),
//                                requestsJson.getString("requestText"));
//
//                        if (requestsJson.has("stateOfRequest")) {
//                            request.setStateOfRequest(StateOfRequest.valueOf(requestsJson.getString("stateOfRequest")));
//                        } else if (requestsJson.has("feedbackText")) {
//                            request.setFeedbackText(requestsJson.getString("feedbackText"));
//                        }
//                        request.setDate(LocalDateTime.parse(requestsJson.getString("date")));
//
//                        client.addRequest(request);
//                    }
//
//                    FariBank.getInstance().addClient(client);
//                    client.setAccountNumber(clientJson.getString("accountNumber"));
//                    client.setCardNumber(clientJson.getString("cardNumber"));
//
//                } catch (JSONException | InvalidInputException | NotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            System.out.println("TEST Clients: " + FariBank.getInstance().getClients());
//
//            // Contacts
//            int k = 0;
//            for (Client client : FariBank.getInstance().getClients()) {
//                JSONObject clientJson = clientsJson.getJSONObject(k);
//                JSONArray contactArray = clientJson.getJSONArray("contacts");
//
//                for (int j = 0; j < contactArray.length(); j++) {
//                    JSONObject contactJson = contactArray.getJSONObject(j);
//                    try {
//                        Contact contact = new Contact(contactJson.getString("firstName"),
//                                contactJson.getString("lastName"), contactJson.getString("phoneNumber"),
//                                contactJson.getString("accountNumber"));
//
//                        client.addContact(contact);
//                    } catch (NumberFormatException | InvalidInputException | NotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
//                k++;
//
//                // Recent Contacts
//                JSONArray recentContactsArray = clientJson.getJSONArray("recentContacts");
//                for (int j = 0; j < recentContactsArray.length(); j++) {
//                    JSONObject contactJson = recentContactsArray.getJSONObject(j);
//
//                    try {
//                        Contact contact = new Contact(contactJson.optString("firstName"),
//                                contactJson.optString("lastName"), contactJson.optString("phoneNumber"),
//                                contactJson.optString("accountNumber"));
//
//                        contact.setDate(LocalDateTime.parse(contactJson.getString("date")));
//
//                        client.addRecentContact(contact);
//                    } catch (NumberFormatException | InvalidInputException | NotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            // New Clients
//            for (int i = 0; i < newClientsJson.length(); i++) {
//                JSONObject newClientJson = newClientsJson.getJSONObject(i);
//
//                try {
//                    Client client = new Client(newClientJson.getString("phoneNumber"),
//                            newClientJson.getString("password"), newClientJson.getString("firstName"),
//                            newClientJson.getString("lastName"), newClientJson.getString("nationalCodeID"));
//                    FariBank.getInstance().addNewClient(client);
//
//                } catch (JSONException | DuplicatedItemException | InvalidInputException | NotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Insert Init Admins
        try {
            FariBank.getInstance().addAdmin(new Admin("Kamyar", "Sabouri", "11111111111", "1"));
            FariBank.getInstance().addAdmin(new Admin("nana", "Bighou", "22222222222", "2"));
        } catch (InvalidInputException | NotFoundException e) {
            e.printStackTrace();
        }

        Main.main(args);
    }
}