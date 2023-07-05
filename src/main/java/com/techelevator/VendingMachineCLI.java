package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	public static void main(String[] args) throws IOException {

		VendingMachine vendomatic800 = new VendingMachine();
		Scanner userInput = new Scanner(System.in);
		String inputPath = "vendingmachine.csv";
		File inputFile = new File(inputPath);
		Map<String, Slot> allSlots = new HashMap<>();
		//TODO Lead in
		File outputFile = new File("log.txt");
		try (PrintWriter writer = new PrintWriter(outputFile)) {
			try (Scanner reader = new Scanner(inputFile)) {
				while (reader.hasNextLine()) {
					String slotInfo = reader.nextLine();
					String[] slotSplit = slotInfo.split("\\|");
					if (slotSplit[3].equals("Duck")) {
						BigDecimal num = new BigDecimal(slotSplit[2]);
						Duck duck = new Duck(slotSplit[1], num);
						Slot slot = new Slot(slotSplit[0], duck, vendomatic800);
						allSlots.put(slot.getSlotName(), slot);
					}
					if (slotSplit[3].equals("Penguin")) {
						BigDecimal num = new BigDecimal(slotSplit[2]);
						Penguin penguin = new Penguin(slotSplit[1], num);
						Slot slot = new Slot(slotSplit[0], penguin, vendomatic800);
						allSlots.put(slot.getSlotName(), slot);
					}
					if (slotSplit[3].equals("Cat")) {
						BigDecimal num = new BigDecimal(slotSplit[2]);
						Cat cat = new Cat(slotSplit[1], num);
						Slot slot = new Slot(slotSplit[0], cat, vendomatic800);
						allSlots.put(slot.getSlotName(), slot);
					}
					if (slotSplit[3].equals("Pony")) {
						BigDecimal num = new BigDecimal(slotSplit[2]);
						Pony pony = new Pony(slotSplit[1], num);
						Slot slot = new Slot(slotSplit[0], pony, vendomatic800);
						allSlots.put(slot.getSlotName(), slot);
					}
				}
				boolean isOn = true;
				while (isOn) {
					System.out.println("(1) Display Vending Machine Items \n(2) Purchase \n(3) Exit");
					String option = userInput.nextLine();
					while (!option.equals("1") && !option.equals("2") && !option.equals("3")) {
						System.out.println("Invalid! Please enter 1, 2, or 3!");
						System.out.println("(1) Display Vending Machine Items \n(2) Purchase \n(3) Exit");
						option = userInput.nextLine();
					}
					if (option.equals("1")) {
						for (Map.Entry<String, Slot> slot : allSlots.entrySet()) {

							System.out.println(slot.getValue().getSlotInfo());
							continue;
						}
					}
					boolean isPurchasing;
					if (option.equals("2")) {
						isPurchasing = true;
						while (isPurchasing) {
							System.out.println("Current Money Provided: $" + vendomatic800.getInsertedFunds());
							System.out.println("(1) Feed Money \n(2) Select Product \n(3) Finish Transaction");
							option = userInput.nextLine();
							String logTransaction;
							LocalDateTime ldt;
							while (!option.equals("1") && !option.equals("2") && !option.equals("3")) {
								System.out.println("Invalid! Please enter 1, 2, or 3!");
								System.out.println("(1) Display Vending Machine Items \n(2) Purchase \n(3) Exit");
								option = userInput.nextLine();
							}
							if (option.equals("1")) {
								System.out.println("Please insert money in dollar amounts");
								BigDecimal moneyInserted = new BigDecimal(userInput.nextLine());
								vendomatic800.takeMoney(moneyInserted);
								ldt = LocalDateTime.now();
								logTransaction = ldt + " FEED MONEY: $" + moneyInserted + " $" + vendomatic800.getInsertedFunds();
								writer.println(logTransaction);


								//writer.append(logTransaction);
								//continue;
							} else if (option.equals("2")) {

								for (Map.Entry<String, Slot> slot : allSlots.entrySet()) {
									System.out.println(slot.getValue().getSlotInfo());
								}
								System.out.println("Please Select Slot Location: ");
								option = userInput.nextLine();

//								String [] slotArray = new String[allSlots.size()];
//								for (int i = 0; i<allSlots.size(); i++){
//									slotArray[i]
//								}
								while (!allSlots.containsKey(option)) {

									System.out.println("Invalid! Please enter a slot location!");
									option = userInput.nextLine();

								}


								//for (Map.Entry<String, Slot> slot : allSlots.entrySet()) {

								BigDecimal itemPrice = allSlots.get(option).getCurrentAnimal().getItemPrice();
								vendomatic800.makeSale(itemPrice);
								allSlots.get(option).dispenseAnimal();

								ldt = LocalDateTime.now();
								logTransaction = ldt + " " + allSlots.get(option).getCurrentAnimal().getItemName()+ " " + option + " " + itemPrice + " " + vendomatic800.getInsertedFunds();
								writer.println(logTransaction);

//									if (option.equals(slot.getKey())) {
//										vendomatic800.makeSale(slot.getValue().getCurrentAnimal().getItemPrice());
//										slot.getValue().dispenseAnimal();
//									}
//
//								continue;

							}else{
							//if(option.equals("3")) {
								isPurchasing = false;
								ldt = LocalDateTime.now();
								logTransaction = ldt + " GIVE CHANGE: $" + vendomatic800.getInsertedFunds() + " $0.00";
								writer.println(logTransaction);

								System.out.println(vendomatic800.giveChange());

								//break;
							}
						}

					}
					else {
						writer.close();
						System.exit(1);
					}
				}

			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
				//throw new RuntimeException(e);
			}
		}catch(IOException e){
			System.out.println("Path not available.");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}