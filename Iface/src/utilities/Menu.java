package utilities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Account;
import entities.Community;

public class Menu {
	private List<Account> users = new ArrayList<>();
	private List<Chat> messagesChat = new ArrayList<>();
	private List<CommunityMsg> commMessages = new ArrayList<>();
	private List<Feed> feed = new ArrayList<>();
	private List<Community> communities = new ArrayList<>();

	Scanner scan = new Scanner(System.in);

	public Menu() {

	}

	public void menu() {
		while (true) {
			try {
			System.out.println("1 - New Account");
			System.out.println("2 - Login");
			System.out.println("3 - Exit");

			System.out.print("option: ");
			int option = scan.nextInt();

			switch (option) {
			case 1:
				createAccount();
				break;
			case 2:
				Account account = login();
				if (!(account == null))
					loggedMenu(account);
				break;
			case 3:
				System.out.println("Closed.");
				return;
			default:
				System.out.println("Invalid value.");
				break;
			} } catch(InputMismatchException e) {
				System.out.println("Please, input a number.");
				scan.nextLine();
			}
		}
	}
	
	public void loggedMenu(Account account) {
		int opt = 0;
		while(true) {
			try {
				System.out.println("----------------- MENU -----------------");
				System.out.println("1 - Account");
				System.out.println("2 - Friends");
				System.out.println("3 - Communities");
				System.out.println("4 - Info");
				System.out.println("5 - Feed");
				System.out.println("6 - Log out");
				System.out.println("----------------------------------------");
				
				System.out.println("Option: ");
				
				opt = scan.nextInt();
				
				switch(opt) {
				case 1:
					if(accountArea(account) == false) {
						return;
					}
					break;
				case 2:
					friendArea(account);
					break;
				case 3:
					communityArea(account);
					break;
				case 4:
					infoArea(account);
					break;
				case 5: 
					feedArea(account);
					break;
				case 6:
					return;
				default:
					System.out.println("Invalid value.");
					break;
				}
				
			} catch(InputMismatchException e) {
				System.out.println("Please, choose a number.");
				scan.nextLine();
			}
		}
	}
	
	
	public boolean accountArea(Account account) {
		Integer option = 0;
		
		while(true) {
		try {
			System.out.println("------------ Account Area ---------------");
			System.out.println("1 - Edit Account");
			System.out.println("2 - Delete Account");
			System.out.println("3 - Return to menu");
			System.out.println("----------------------------------------");
			option = scan.nextInt(); 
			
			if(option.equals(1)) {
				while (option != -1) {
					try {
						System.out.println("What do you want to edit?");
						System.out.println("1 - Name");
						System.out.println("2 - About");
						System.out.println("3 - Age");
						System.out.println("4 - Address");
						System.out.println("5 - Password");
						System.out.println("6 - Back to account area");
					    System.out.println("Insert option: ");
					    option = scan.nextInt();
					    
					    switch (option) {
					case 1:
						System.out.println("Name: ");
						scan.nextLine();
						account.setName(scan.nextLine());
						break;
					case 2:
						System.out.println("About: ");
						scan.nextLine();
						account.setAbout(scan.nextLine());
						break;
					case 3:
						System.out.println("Age: ");
						account.setAge(scan.nextInt());
						break;
					case 4:
						System.out.println("Address: ");
						scan.nextLine();
						account.setAddress(scan.nextLine());
						break;
					case 5:
						System.out.println("Password: ");
						scan.nextLine();
						account.setPassword(scan.nextLine());
						break;
					case 6:
						System.out.println(account.toString());
						System.out.println("<---------------");
						option = -1;
						break;
					default:
						System.out.println("Invalid value.");
						break;
						}
					    
					} catch(InputMismatchException e) {
						System.out.println("Please, input a number.");
						scan.nextLine();
					}
					System.out.println(account.toString());
				}
				
			}else if(option.equals(2)) {
				System.out.println("Are you sure you want to leave us (y/n)?");
				String opt;
				opt = scan.next();
				switch (opt) {
				case "y":
					deleteCommunities(account);
					deleteCommunitiesMsg(account);
					deleteFeed(account);
					deleteMessages(account);
					deleteInvit(account);
					account.getFriends().clear();
					account.setLogin(null);
					account.setNickname(null);
					account.setPassword(null);
					account.setAbout(null);
					account.setAddress(null);
					account.setAge(0);
					getInformations(account);
					users.remove(account);
					/*System.out.println("------------- REMAINING USERS -------------");
					for (Account user : users) {
						System.out.println(user.getLogin());
					}
					System.out.println("--------------------------------------------");*/
					System.out.println("It was nice to meet you.");
					return false;
				case "n":
					System.out.println("We're happy that you will continue with us.");
					break;
				default:
					System.out.println("Invalid value.");
					break;
				}
			
			} 
			
			else if(option.equals(3)) {
				return true;
			} else {
				throw new IllegalArgumentException("Please, choose a valid option.");
			}
			
		} 
		
		catch(InputMismatchException e) {
			System.out.println("Please, choose a number.");
			scan.nextLine();
		}
		
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		}
	}
	
	public void friendArea(Account account) {
		int option = 0;
		
		while(true) {
			try {
				System.out.println("------------- Manage Friends -----------");
				System.out.println("1 - Add friend");
				System.out.println("2 - Acc friend");
				System.out.println("3 - Send message to friend");
				System.out.println("4 - Show messages with a friend");
				System.out.println("5 - Return to menu");
				System.out.println("----------------------------------------");
				
				option = scan.nextInt();
				switch(option) {
				case 1:
					System.out.println("Search for: ");
					Account friend = searchAccount(scan.next());

					if (friend == null) {
						System.out.println("Doesn't exist.");
						return;
					}
					
					if (account.getFriends().contains(friend.getLogin())) {
						System.out.println("You're already friends with " + friend.getLogin() + ".");
						return;
					}

					if (account.getSendInvitation().contains(friend.getLogin())) {
						System.out.println("You're already sent invitation to " + friend.getLogin() + ".");
						return;
					}

					if (account.getReceivedInvitation().contains(friend.getLogin())) {
						System.out.println("The user " + friend.getLogin() + " already sent invitation to you.");
						return;
					}

					if (friend.getLogin().equals(account.getLogin())) {
						System.out.println("You can't add yourself.");
						return;
					}

					friend.getReceivedInvitation().add(account.getLogin());
					account.getSendInvitation().add(friend.getLogin());

					System.out.println("Invite sent.");
					break;
				case 2:
					System.out.println(account.getReceivedInvitation());
					System.out.println("Insert user who you want to manage: ");
					friend = searchAccount(scan.next());

					if (account.getReceivedInvitation().contains(friend.getLogin())) {
						System.out.println("Do you want to accept " + friend.getLogin() + "?");
						System.out.println("1 - Yes");
						System.out.println("2 - No");
					    option = scan.nextInt();

						if (option == 1) {
							account.getFriends().add(friend.getLogin());
							friend.getFriends().add(account.getLogin());
							System.out.println("You're friends with " + friend.getLogin() + "!");
							account.toStringFriends();
						} else if (option == 2) {
							System.out.println("You declined + " + friend.getLogin() + "'s invitation.");
						}
						account.getReceivedInvitation().remove(friend.getLogin());
						friend.getSendInvitation().remove(account.getLogin());
					} else {
						System.out.println("No user with that name has added you.");
						return;
					}
					break;
				case 3:
					System.out.println("Send message to: ");
					String receiver = scan.next();
					if (receiver.equals(account.getLogin())) {
						System.out.println("You can't send messages to yourself.");
						return;
					}
					if (searchAccount(receiver) != null) {
						System.out.println("Type your message: ");
						scan.nextLine();
						String msg = scan.nextLine();
						Chat message = new Chat(account.getLogin(), msg, receiver);
						messagesChat.add(message);
						System.out.println("Message sent successfully.");
					} else {
						System.out.println("Not found.");
					}
					break;
				case 4:
					System.out.println("Who do you want to see the messages: ");
					receiver = scan.next();
					if (searchAccount(receiver) != null) {
						for (Chat msg : messagesChat) {
							if (msg.getSender().equals(receiver) || msg.getSender().equals(account.getLogin())) {
								if (msg.getReceiver().equals(account.getLogin()) || msg.getReceiver().equals(receiver)) {
									System.out.println(msg.getSender() + ": " + msg.getMessage());
								}
							}
						}

					} else {
						System.out.println("Not found.");
					}
					break;
				case 5:
					return;
				default:
					throw new IllegalArgumentException("Please, choose a valid option.");
					//break;
				}
				
			} catch(InputMismatchException e) {
				System.out.println("Please, choose a number.");
				scan.nextLine();
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch(NullPointerException e) {
				System.out.println("No user with that nickname has added you.");
			}

		}
	}
	
	public void communityArea(Account account) {
		int option = 0;
		while(true) {
			Community community = new Community();
			System.out.println("---------- Manage Communities -----------");
			System.out.println("1 - Create community");
			System.out.println("2 - Manage members of my communities");
			System.out.println("3 - Add community");
			System.out.println("4 - Send message to community");
			System.out.println("5 - Return to menu");
			System.out.println("----------------------------------------");
			option = scan.nextInt();
			switch(option) {
			case 1:
				System.out.println("Community name: ");
				scan.nextLine();
				String name = scan.nextLine();
				if (searchCommunity(name) != null) {
					System.out.println("Community already exists. Please, choose another name.");
				} else {
					community.setName(name);
					System.out.println("Description: ");
					community.setDescription(scan.nextLine());
					community.setCreator(account.getLogin());
					communities.add(community);
					account.getCommunities().add(community);
					System.out.println(community.toString());
					account.printAll();
				}
				break;
			case 2: 
				scan.nextLine();
				System.out.println("Search community: ");
				String nameCommunity = scan.nextLine();
				option = 0;
				if (searchCommunity(nameCommunity) != null) {
					if (searchCommunity(nameCommunity).getCreator().equals(account.getLogin())) {
						System.out.println("Search member you want to manage: ");
						String nameMember = scan.nextLine();
						if (searchCommunity(nameCommunity).getMembers().contains(nameMember)) {
							System.out.println("Do you want to delete? 1 - Yes / 2 - No");
							option = scan.nextInt();
							switch (option) {
							case 1:
								searchCommunity(nameCommunity).getMembers().remove(nameMember);
								Account aux = searchAccount(nameMember);
								aux.getCommunities().remove(searchCommunity(nameCommunity));
								System.out.println("The user " + nameMember + " is not part of this community anymore.");
								searchCommunity(nameCommunity).printAll();
								return;
							case 2:
								System.out.println("Returning to menu.");
								return;
							default:
								System.out.println("Invalid value.");
								break;
							}

						} else {
							System.out.println("The user doesn't exist in this community. Do you want add? 1 - Yes / 2 - No");
							option = scan.nextInt();
							switch (option) {
							case 1:
								if (searchAccount(nameMember) != null) {
									searchCommunity(nameCommunity).getMembers().add(nameMember);
									Account aux = searchAccount(nameMember);
									aux.getCommunities().add(searchCommunity(nameCommunity));
									System.out.println("The user " + nameMember + " it's in your community.");
									searchCommunity(nameCommunity).printAll();

								} else {
									System.out.println("User doesn't exists.");
								}
								return;
							case 2:
								System.out.println("Returning to menu.");
								return;
							default:
								System.out.println("Invalid value.");
								break;
							}

						}

					} else {
						System.out.println("You're not the host of this community.");
						return;
					}
				}

				System.out.println("This community doesn't exists.");
				break;
			case 3:
				System.out.println("Search community: ");
				scan.nextLine();
				String comm = scan.nextLine();
				if (searchCommunity(comm) != null) {
					Community aux = searchCommunity(comm);
					for (Community c : account.getCommunities()) {
						if (c.getName().equals(comm)) {
							System.out.println("You're already in this community.");
							return;
						}
					}
					account.getCommunities().add(searchCommunity(comm));
					System.out.println("You're now member of: " + comm);
					account.printAll();
					aux.getMembers().add(account.getLogin());
					return;
				}
				System.out.println("Community doesn't exist.");
				break;
			case 4:
				System.out.println("------------MY COMMUNITIES--------------");
				for (Community c : account.getCommunities()) {
					System.out.println("-----> " + c.getName());
					System.out.println("------------------------------------");
				}
				System.out.println("Community you want to send a message: ");
				scan.nextLine();
				String communityName = scan.nextLine();
				if (searchCommunity(communityName) != null) {
					if (account.getCommunities().contains(searchCommunity(communityName))) {
						System.out.println("Send message to: " + communityName);
						String msg = scan.nextLine();
						CommunityMsg newmsg = new CommunityMsg(account.getLogin(), msg, communityName);
						commMessages.add(newmsg);
						System.out.println("Do you want to see community messages? 1 - Yes / 2 - No");
						Integer opt = scan.nextInt();
						if (opt.equals(1)) {
							for (CommunityMsg m : commMessages) {
								if (m.getCommunity().equals(communityName)) {
									System.out.println(m.getSender() + ": " + m.getMessage());
								}
							}
						} else if (opt.equals(2)) {
							System.out.println("Returning...");
							return;
						} else {
							System.out.println("Invalid option.");
							return;
						}

					} else {
						System.out.println("You're not member of  this community.");
						return;
					}
				} else {
					System.out.println("This community doesn't exist.");
				}
				break;
			case 5:
				return;
			default:
				System.out.println("Please, choose a valid option");
				break;
			}
		}
	}
	
	public void infoArea(Account account) {
		int opt = 0;
		while(true) {
			try {
			System.out.println("---------------- Get Info --------------");
			System.out.println("1 - Profile");
			System.out.println("2 - My Communities");
			System.out.println("3 - My Friends");
			System.out.println("4 - All Messages");
			System.out.println("5 - Return to menu");
			System.out.println("----------------------------------------");
			opt = scan.nextInt();
			switch(opt) {
			case 1:
				System.out.println("----------------------------------------");
				System.out.println(account.toString());
				System.out.println("----------------------------------------");
				break;
			case 2:
				System.out.println("----------------------------------------");
				account.printAll();
				System.out.println("----------------------------------------");
				break;
			case 3:
				System.out.println("----------------------------------------");
				account.toStringFriends();
				System.out.println("----------------------------------------");
				break;
			case 4:
				System.out.println("----------------------------------------");
				showAllMessages(account);
				System.out.println("----------------------------------------");
				break;
			case 5:
				return;
			default:
				throw new IllegalArgumentException("Please, choose a valid option.");
			}
			} catch(InputMismatchException e) {
				System.out.println("Please, choose a number.");
				scan.nextLine();
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void feedArea(Account account) {
		int opt = 0;
		while(true) {
			try {
				System.out.println("--------------- Feed ---------------");
			System.out.println("1 - Send message to feed");
			System.out.println("2 - Show feed's messages");
			System.out.println("3 - Return to menu");
			System.out.println("----------------------------------------");
			opt = scan.nextInt();
			
			switch(opt) {
			case 1:
				System.out.println("Do you want to post (1) public or (2) private?");
				Integer option = scan.nextInt();
				if (option.equals(1) || option.equals(2)) {
					System.out.println("Type your message: ");
					scan.nextLine();
					String message = scan.nextLine();
					Feed newMessage = new Feed(account.getLogin(), message, option);
					feed.add(newMessage);
				} else {
					System.out.println("Invalid value.");
				}
				break;
			case 2:
				if (feed.isEmpty()) {
					System.out.println("-------------------No Messages-------------------");
				}

				for (Feed f : feed) {
					if (f.getPermission() == 1) {
						System.out.println("[PUBLIC] " + f.getSender() + ": " + f.getMessage());
					}
					if (f.getPermission() == 2) {
						if (f.getSender().equals(account.getLogin()) || account.getFriends().contains(f.getSender())) {
							System.out.println("[PRIVATE] " + f.getSender() + ": " + f.getMessage());

						}

					}

				}
				break;
			case 3:
				return;
			default:
				throw new IllegalArgumentException("Please, choose a valid option.");
			}
			} catch(InputMismatchException e) {
				System.out.println("Please, choose a number.");
				scan.nextLine();
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void createAccount() {
		System.out.println("New login: ");
		String login = scan.next();

		for (Account user : users) {
			if (user.getLogin().equals(login)) {
				System.out.println("Login already used, please choose another.");
				return;
			}
		}
		System.out.println("New password: ");
		String password = scan.next();
		System.out.println("New nickname: ");
		String nickname = scan.next();

		Account account = new Account(login, password, nickname);
		users.add(account);
		//System.out.println(account.toString());
	}

	public Account login() {
		System.out.println("Login: ");
		String login = scan.next();

		for (Account user : users) {
			if (user.getLogin().equals(login)) {
				System.out.println("Password: ");
				String password = scan.next();
				if (user.getPassword().equals(password)) {
					System.out.println("Welcome to Iface, " + user.getNickname() + "!");
					return user;
				} else {
					System.out.println("Invalid password.");
				}
				return null;
			}
		}
		System.out.println("Not found.");
		return null;
	}

	public Account searchAccount(String login) {
		for (Account account : users) {
			if (account.getLogin().equals(login)) {
				return account;
			}
		}
		return null;
	}


	public void sendMessage(Account account) {
		System.out.println("Send message to: ");
		String receiver = scan.next();
		if (receiver.equals(account.getLogin())) {
			System.out.println("You can't send messages to yourself.");
			return;
		}
		if (searchAccount(receiver) != null) {
			System.out.println("Type your message: ");
			scan.nextLine();
			String msg = scan.nextLine();
			Chat message = new Chat(account.getLogin(), msg, receiver);
			messagesChat.add(message);
			System.out.println("Message sent successfully.");
		} else {
			System.out.println("Not found.");
		}

	}


	// p recuperar dado
	public void showAllMessages(Account account) {
		for (Chat msg : messagesChat) {
			System.out.println(msg.getSender() + ": " + msg.getMessage());
		}
	}

	public Community searchCommunity(String nameCommunity) {
		for (Community community : communities) {
			if (community.getName().equals((nameCommunity))) {
				return community;
			}
		}
		return null;
	}

	public void getInformations(Account account) {
		System.out.println("------------------INFO------------------");
		System.out.println(account.toString());
		System.out.println("----------------------------------------");
		System.out.println("Communities: ");
		System.out.println("----------------------------------------");
		account.printAll();
		System.out.println("----------------------------------------");
		System.out.println("Friends: ");
		account.toStringFriends();
		System.out.println("----------------------------------------");
		System.out.println("Messages: ");
		System.out.println("----------------------------------------");
		showAllMessages(account);
		System.out.println("----------------------------------------");
	}

	public void deleteCommunities(Account account) {
		List<Community> delete = new ArrayList<>();
		Account otherAccount = new Account();

		for (Community c : communities) {
			if (c.getCreator().equals(account.getLogin())) {
				c.getMembers().clear();
				delete.add(c);
			}
		}

		for (Account user : users) {
			otherAccount = searchAccount(user.getLogin());
			otherAccount.getCommunities().removeAll(delete);
		}
		communities.removeAll(delete);

	}

	public void deleteCommunitiesMsg(Account account) {
		List<CommunityMsg> delete = new ArrayList<>();
		for (CommunityMsg msg : commMessages) {
			if (msg.getSender().equals(account.getLogin())) {
				delete.add(msg);
			}
		}
		commMessages.removeAll(delete);
	}

	public void deleteFeed(Account account) {
		List<Feed> delete = new ArrayList<>();
		for (Feed f : feed) {
			if (f.getSender().equals(account.getLogin())) {
				delete.add(f);
			}
		}
		feed.removeAll(delete);
	}

	public void deleteMessages(Account account) {
		List<Chat> delete = new ArrayList<>();
		for (Chat m : messagesChat) {
			if (m.getSender().equals(account.getLogin()) || m.getReceiver().equals(account.getLogin())) {
				delete.add(m);
			}
		}
		messagesChat.removeAll(delete);
	}

	public void deleteInvit(Account account) {
		Account otherAccount = new Account();
		for (Account user : users) {
			otherAccount = searchAccount(user.getLogin());
			otherAccount.getReceivedInvitation().remove(user.getLogin());
		}
	}

}