import java.util.Scanner;
class BankAccount{
    String name;
    String username;
    String password;
    String accountno;
    float balance=100000f;
    int transactions=0;
    String transactionhistory="";

    public void register() {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n Enter Your name:");
        name=sc.nextLine();
        System.out.println("\n Enter Your Username:");
        username=sc.nextLine();
        System.out.println("\n Enter Your Password:");
        password=sc.nextLine();
        System.out.println("\n Enter Your Account Number:");
        accountno=sc.nextLine();
        System.out.println("Registration completed ..kindly login");
    }
    public boolean login() {
        boolean isLogin=false;
        Scanner sc=new Scanner(System.in);
        while(!isLogin){
            System.out.println("\n Enter Your Username:");
            String Username=sc.nextLine();
            if(Username.equals(username)){
                while(!isLogin){
                    System.out.println("\n Enter Your password:");
                    String Password=sc.nextLine();
                    if(Password.equals(password)){
                        System.out.println("\n Login successful!!");
                        isLogin=true;
                    }
                    else{
                        System.out.println("\n Incorrect password");
                    }
                }
            }
            else{
                System.out.println("\n Username is not found");
            }
        }
        return isLogin;
    }

public void withdraw() {
    System.out.println("\n Enter amount to withdraw:");
    Scanner sc=new Scanner(System.in);
    float amount=sc.nextFloat();
    try{
        if(balance>=amount){
        transactions++;
        balance=balance-amount;
        System.out.println("\n Withdraw successfully");
        String str=amount + "Rs Withdrawed\n";
        transactionhistory=transactionhistory.concat(str);
        }
        else{
            System.out.println("\n Insufficient balance");
        }
    }catch(Exception e){
    }
}

public void deposite() {
    System.out.println("\n Enter amount to deposite:");
    Scanner sc=new Scanner(System.in);
    float amount=sc.nextFloat();
    try{
        if(amount<=100000){
            transactions++;
            balance=balance+amount;
            System.out.println("Successfully Deposited");
            String str=amount + "Rs. Successfully deposited";
            transactionhistory=transactionhistory.concat(str);
           }
        else{
            System.out.println("\n Sorry...Limit is 1000000.00");
        }
        }catch(Exception e){        
        }
    }

public void transfer() {
    Scanner sc=new Scanner(System.in);
    System.out.println("\n Enter Receipent's name: ");
    String receipent=sc.nextLine();
    System.out.println("\n Enter amount to transfer:");
    float amount=sc.nextFloat();
    try{
        if(balance>=amount)
        {
            if(amount<=50000f){
                transactions++;
                balance=balance-amount;
                System.out.println("\n Successfully transfered to:"+receipent);
                String str=amount + "Rs. transfered to" + receipent;
                transactionhistory=transactionhistory.concat(str);
            }
            else{
                System.out.println("\n Sorry...Limit is 50000.00 ");
            }
        }else{
            System.out.println("Insufficient Balance");
        }
    }catch(Exception e){
        }
    }

public void checkbalance(){
    System.out.println("\n " + balance + "Rs.");
}

public void transhistory() {
    if(transactions == 0){
        System.out.println("\n Empty");
    }
    else{
        System.out.println("\n" + transactionhistory);
    }
  }
}

public class AtmInterface{
    public static int takeinput(int limit){
        int input=0;
        boolean flag=false;
        while(!flag){
            try{
                Scanner sc=new Scanner(System.in);
                input=sc.nextInt();
                flag=true;
                if(flag && input>limit || input<1){
                    System.out.println("\n Choose the number betwwenn 1 to"+ limit);
                    flag=false;
                }
            }catch(Exception e){
                System.out.println("\n Enter only integer number");
                flag=false;
            }
        }
        return input;
    } 
    public static void main(String[] args) {
    System.out.println("\n******************WELCOME TO SBI ATM SYSTEM*******************\n");
    System.out.println("\n 1.Register \n 2.Exit");
    System.out.println("\n Enter your choice");
    int choice=takeinput(2);
    if(choice==1){
        BankAccount b=new BankAccount();
        b.register();
        while(true){
            System.out.println("\n 1.Login \n 2.Exit");
            System.out.println("\n Enter your choice");
            int c=takeinput(2);
            if(c==1){
                if(b.login()){
                    System.out.print("\n**************WELCOME BACK" + b.name + "***********************\n");
                    boolean isFinished=false;
                    while(!isFinished)
                    {
                        System.out.println("\n 1.Withdraw \n 2.Deposite \n 3.Transfer \n 4.Check Balance \n 5.Transaction History\n");
                        System.out.println("\n Enter your choice");
                        int c1=takeinput(4);
                        switch(c1){
                            case 1:
                            b.withdraw();
                            break;
                            case 2:
                            b.deposite();
                            break;
                            case 3:
                            b.transfer();
                            break;
                            case 4:
                            b.checkbalance();
                            break;
                            case 5:
                            b.transhistory();
                            break;
                            case 6:
                            isFinished=true;
                            break;
                        }
                    }
                }
            }
            else{
                System.exit(0);
            }
        }
    }
else{
    System.exit(0);
}
}
}