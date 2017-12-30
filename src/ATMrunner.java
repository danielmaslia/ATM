import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ATMrunner {

	public static void main(String[] args) {
		long cardNum;
		String receipt;
		ArrayList<User> users = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("What is your card number?");
			cardNum = input.nextLong();
			input.nextLine();
			User dummy = new User(0, 0, cardNum);
			if(users.contains(dummy)) {
				System.out.println("Welcome valued costomer!!!!?!?!");
				int index = users.indexOf(dummy);
				dummy = users.get(index);
			}else {
				System.out.println("What is your pin number?");
				long pinNum = input.nextLong();
				input.nextLine();
				dummy.pinNum = pinNum;
				users.add(dummy);
			}
			String command = "";
			receipt = "User: " + cardNum + System.lineSeparator();
			while(!(command.equalsIgnoreCase("Stop"))) {
				System.out.println("What would you like to do? (Deposit, Withdrawl, Check Balance or Stop)");
				command = input.nextLine();
				if(command.equalsIgnoreCase("deposit")){
					System.out.println("How much money would you like to add????");
					Long added = input.nextLong();
					input.nextLine();
					dummy.setBalance(dummy.getBalance() + added);
					System.out.println("Your balance is now " + dummy.getBalance() + ".");
					receipt += "deposited " + added + System.lineSeparator();
				}
				if(command.equalsIgnoreCase("withdrawl")){
					System.out.println("How much moola do you want?");
					long taken = input.nextLong();
					input.nextLine();
					
					if(taken > dummy.getBalance()) {
						System.out.println("YOU CANT DO THAT BECAUSE YOU BALANCE WOULD THEN BE " + (dummy.getBalance() - taken) + ".");
					}else {
						dummy.setBalance(dummy.getBalance() - taken);
						System.out.println("Your balance is now " + dummy.getBalance() + ".");
						receipt += "withdrew " + taken + System.lineSeparator();
					}
				}
				if(command.equalsIgnoreCase("check balance")) {
					System.out.println("Your balance is " + dummy.getBalance());
				}
			}
			receipt += System.lineSeparator() + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() + "New Balance: " + dummy.getBalance();
			try {
				Files.write(Paths.get("receipt.txt"), receipt.getBytes());
			} catch (IOException e) {
				System.out.println("get a new cash register");
			}
			input.close();
		}
	}
}
