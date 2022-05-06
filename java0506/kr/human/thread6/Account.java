package kr.human.thread6;

public class Account {
    String accountNo;    // 계좌번호
    String ownerName;    // 예금주
    int balance;         // 예금 잔액
    // 생성자
    Account(String accountNo, String ownerName, int balance) {   
        this.accountNo = accountNo; 
        this.ownerName = ownerName;  
        this.balance = balance;       
    }
    // 입금
    void  deposit(int amount)  {       
        balance += amount;
    }
    // 출금
    int withdraw(int amount) {
        if (balance < amount)
            return 0;
        balance -= amount;
        return amount;
    }
}
