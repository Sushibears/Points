package com.apprenticeshipproject.Points.Controllers;


import com.apprenticeshipproject.Points.Entities.Transaction;
import com.apprenticeshipproject.Points.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository Repo;

//    Methods for retrieving Transactions.
     @GetMapping
        public List<Transaction> getAllTransactions(){
         return Repo.findAll();
        }

     @GetMapping("/{id}")
        public Transaction getTransactionByID(@PathVariable("id") int id){
         return Repo.getById(id);
        }

     @GetMapping("/{payer_name}")
        public List<Transaction> getTransactionsByPayerName(@RequestParam("payer_name") String name){
         return Repo.findByPayer(name);
     }

//     Methods for adding/updating Transactions
//      Single Transaction
    @PutMapping("/transaction")
    public void addNewTransactions(Transaction newTransaction){
        Repo.save(newTransaction);
    }
//      Multiple Transactions
    @PostMapping
    public void addAllTransactions(@RequestBody List<Transaction> newTransactions){
         Repo.saveAll(newTransactions);
    }

//     Methods for deleting Transactions
    @DeleteMapping("/transaction")
    public void deleteTransaction(String oldPayer, Timestamp oldTimestamp){
        Transaction oldTransaction = Repo.findByPayerAndTimestamp(oldPayer, oldTimestamp);
        Repo.delete(oldTransaction);
    }
//
//    @DeleteMapping()
//    public void deleteMultipleTransactions(String oldPayer, Timestamp oldTimestamp){
//
//    }
}
