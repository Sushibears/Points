package com.apprenticeshipproject.Points.Controllers;


import com.apprenticeshipproject.Points.Entities.Transaction;
import com.apprenticeshipproject.Points.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository Repo;

//    Methods for retrieving Transactions.
     @GetMapping("/transactions")
        public List<Transaction> getAllTransactions(){
         return Repo.findAll();
        }

     @GetMapping("transaction/{id}")
        public Transaction getTransactionByID(@PathVariable("id") int id){
         return Repo.getById(id);
        }

     @GetMapping("/payer/{name}")
        public List<Transaction> getTransactionsByPayerName(@PathVariable("name") String name){
         return Repo.findByPayer(name);
     }

//     Methods for adding/updating Transactions
//      Single Transaction
    @PutMapping("/transaction")
    public void addNewTransaction(Transaction newTransaction){
        Repo.save(newTransaction);
    }

    @PostMapping("/transactions/pointsupdate")
    public void addPoints(@RequestBody int transactionId, int points){
        Transaction updatedTransaction = Repo.getById(transactionId);
        int newPoints = updatedTransaction.getPoints() + points;
        Repo.getById(transactionId).setPoints(newPoints);
    }

    //      Multiple Transactions
    @PostMapping("/transactions")
    public void addAllTransactions(@RequestBody List<Transaction> newTransactions){
         Repo.saveAll(newTransactions);
    }

    @PostMapping("/transactions/pointsupdate/remove")
    public HashMap<String, Integer> removePoints(@RequestBody int points){
        List<Transaction> processing = Repo.findAllByOrderByTimestampDesc();
        HashMap<String, Integer> finalList = new HashMap<>();
        AtomicBoolean stopLoop = new AtomicBoolean(false);
        if(!stopLoop.get()){
            processing.forEach(Transaction -> {
                int loopPoints = points - Transaction.getPoints();
                if(loopPoints > 0){
                    finalList.put(Transaction.getPayer(),Transaction.getPoints() * -1);
                    Transaction.setPoints(0);
                } else {
                    stopLoop.set(true);
                }
            });
        }
        return finalList;
    }


    //     Methods for deleting Transactions
    @DeleteMapping(value = "/transaction/{id}")
    public void deleteTransactionById(@PathVariable int id){
        Repo.deleteById(id);
    }

    @DeleteMapping("/transaction")
    public void deleteTransaction(@RequestBody String oldPayer,LocalDate oldTimestamp){
        Repo.delete(Repo.findByPayerAndTimestamp(oldPayer, oldTimestamp));
    }
}
