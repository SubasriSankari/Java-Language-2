import java.io.*;
import java.util.*;
import java.sql.*;

interface Result{
    void Leading();
}

class ToVote{

    public void VoteNow(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" ~~~~  Vote Now ~~~~");
        System.out.println("\nEnter your Aadhar Number:");
        int aadhar = sc.nextInt();
        System.out.println("\n1. ADMK");
        System.out.println("2. DMK");
        System.out.print("3. TDMK\n\n --->");
        int party = sc.nextInt();
        ConnectionDao.makeConnection();
        boolean status = false;
        switch(party)
        {
            case 1:
                status = ConnectionDao.addVoteNow(aadhar, "ADMK");
                break;
            
            case 2:
                status = ConnectionDao.addVoteNow(aadhar, "DMK");
                break;
            
            case 3:
                status = ConnectionDao.addVoteNow(aadhar, "TDMK");
                break;

            default:
                System.out.println("Error... Wrong key entered");
        }
        if(status)
            System.out.println("Thanks for voting!!");
    }
}

class CountVote implements Result{
    public void Leading(){
        ConnectionDao.makeConnection();
        HashMap<String, Integer> winner = ConnectionDao.findWinner();
        HashMap<String, Integer> looser = ConnectionDao.findLooser();
        HashMap.Entry<String, Integer> winnerEntry = winner.entrySet().iterator().next();
        HashMap.Entry<String, Integer> looserEntry = looser.entrySet().iterator().next();
        
        System.out.println(winnerEntry.getKey() + " is leading with " + (winnerEntry.getValue() - looserEntry.getValue()) +" voter than " + looserEntry.getKey() + ".\n");
        
    }
}

public class E_Voting {
    
    static void menu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("\n```````````````````` Welcome to E-Voting System ````````````````````\n\n");
        while(true)
        {
            System.out.println("1. To Vote");
            System.out.println("2. To Count Vote");
            System.out.print("3. Exit\n\n --->");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    new ToVote().VoteNow();
                    break;
                case 2:
                    new CountVote().Leading();
                    break;
                case 3:
                    System.out.println("Thanks for choosing E-Voting System");
                    System.exit(0);
                default:
                    System.out.println("Error...Wrong key");
            }
        }
    }
    public static void main(String[] args) {
        menu();
    }
}
