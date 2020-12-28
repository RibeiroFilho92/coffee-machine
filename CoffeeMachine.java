import java.util.Scanner;

public class CoffeeMachine {

	public static Scanner sc  = new Scanner(System.in);
	
	public static void main(String[] args) {
		int water = 400;
		int milk = 540;
		int coffee = 120;
		int cups = 9;
		int money = 550;
		
		String operation = "";
		while (!operation.contains("exit")) {
			System.out.println("Write action (buy, fill, take, remaining, exit):");
			operation = sc.nextLine().trim();
			if (operation.contains("buy")) {
				System.out.println();
				System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:  ");
				String option = sc.nextLine();
				if (option.contains("1")) {
					if (enough(water, milk, coffee, cups, "1")) {
						water -= 250;
						coffee -= 16;
						money += 4;
						cups -= 1;
					}

				} else if (option.contains("2")) {
					if (enough(water, milk, coffee, cups, "2")) {
						water -= 350;
						milk -= 75;
						coffee -= 20;
						money += 7;
						cups -= 1;
					}

				} else if (option.contains("3")){
					if (enough(water, milk, coffee, cups, "3")) {
						water -= 200;
						milk -= 100;
						coffee -= 12;
						money += 6;
						cups -= 1;
					}

				} 
				System.out.println();
			}
			
			if (operation.contains("fill")) {
				System.out.println();
				System.out.println("Write how many ml of water do you want to add:");
				water += sc.nextInt();
				System.out.println("Write how many ml of milk do you want to add:");
				milk += sc.nextInt();
				System.out.println("Write how many grams of coffee beans do you want to add:");
				coffee += sc.nextInt();
				System.out.println("Write how many disposable cups of coffee do you want to add:");
				cups += sc.nextInt();
				sc.nextLine();
				System.out.println();
			}
			
			if (operation.contains("take")) {
				System.out.println("I gave you $" + money);
				money = 0;
				System.out.println();
			}
								
			if (operation.contains("remaining")) {
				ramaining(water, milk, coffee, cups, money);
				System.out.println();
			}
			
			if (operation.contains("exit")) {
				System.exit(0);
			}
		}
			
	}
	
	public static void ramaining(int water, int milk, int coffee, int cups, int money) {
		System.out.println();
		System.out.println("The coffee machine has:");
		System.out.println(water + " of water");
		System.out.println(milk + " of milk");
		System.out.println(coffee + " of coffee beans");
		System.out.println(cups + " of disposable cups");
		System.out.println("$" + money + " of money");
	}
	
	public static boolean enough(int water, int milk, int coffee, int cups, String option) {
		if (option.contains("1")) {
			if (water > 250 && coffee > 16) {
				System.out.println("I have enough resources, making you a coffee!");
				return true;
			} else {
				if (water < 250) {
					System.out.println("Sorry, not enough water!");
				}
				if (coffee < 16) {
					System.out.println("Sorry, not enough coffee!");
				}
			}
		}
		if (option.contains("2")) {
			if (water > 350 && milk > 75 && coffee > 20) {
				System.out.println("I have enough resources, making you a coffee!");
				return true;
			} else {
				if (water < 350) {
					System.out.println("Sorry, not enough water!");
				}
				if (milk < 75) {
					System.out.println("Sorry, not enough milk!");
				}
				if (coffee < 20) {
					System.out.println("Sorry, not enough coffee!");
				}
			}
		}
		if (option.contains("3")) {
			if (water > 200  && milk > 100 && coffee > 12 ) {
				System.out.println("I have enough resources, making you a coffee!");
				return true;
			} else {
				if (water < 200) {
					System.out.println("Sorry, not enough water!");
				}
				if (milk < 100) {
					System.out.println("Sorry, not enough milk!");
				}
				if (coffee < 12) {
					System.out.println("Sorry, not enough coffee!");
				}
			}
		}
		return false;
	}

}
