package utilities;

import java.util.ArrayList;
import java.util.Scanner;
import entities.Account;


public class Menu {
	ArrayList<Account> users = new ArrayList<>();
	ArrayList<Message> messages = new ArrayList<>();
	ArrayList<Community> communities = new ArrayList<>();
	ArrayList<Feed> feed = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);
	
	public Menu() {
		Account teste = new Account("pri", "1", "pri");
		users.add(teste);
		teste = new Account("arthur", "2", "arthur");
		users.add(teste);
		teste = new Account("will", "3", "will");
		users.add(teste);
		teste = new Account("mesquita", "4", "mesquita");
		users.add(teste);
	}

	public void menu() {
	 while(true) {
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
	        	 if(!(account == null)) {
	        		 loggedMenu(account);
	        	 }  
                 break;
             case 3:
                 System.out.println("Closed.");
                 return;
             default:
                 System.out.println("Invalid Value");
                 break;
         }
      }
	}
	
	public void loggedMenu(Account account) {
		 while(true) {
	         System.out.println("1 - Edit account");
	         System.out.println("2 - Add friend");
	         System.out.println("3 - Send message");
	         System.out.println("4 - Show message");
	         System.out.println("5 - Acc friend");
	         System.out.println("6 - Create community");
	         System.out.println("7 - Manage members");
	         System.out.println("8 - Join a community");
	         System.out.println("9 - Get my informations");
	         System.out.println("10 - Send message to feed");
	         System.out.println("11 - Show feed");
	         System.out.println("12 - Exit");
	         
	         System.out.print("option: ");
	         int option = scan.nextInt();

	         switch (option) {
	             case 1:
	            	 editAccount(account);
	                 break;
	             case 2:
	            	 addFriend(account);
	                 break;
	             case 3:
	                 sendMessage(account);
	            	 break;
	             case 4:
	            	 showMessages(account);
	            	 break;
	             case 5: 
	            	 accFriend(account);
	            	 break;
	             case 6:
	            	 createCommunity(account); 
	            	 break;
	             case 7: 
	            	 manageCommunity(account);
	            	 break;
	             case 8:
	            	 joinCommunity(account);
	            	 break;
	             case 9:
	            	 getInformations(account);
	            	 break;
	             case 10: 
	            	 postFeed(account);
	            	 break;
	             case 11:
	            	 showFeed(account);
	            	 break;
	             case 12: 
	            	 System.out.println("See you soon, " + account.getLogin() + "!");
	            	 return;
	             default:
	                 System.out.println("Invalid Value");
	                 break;
	         }
	      }
	}
	
	public void createAccount() { 
		System.out.println("New login: ");
		String login = scan.next();
		
		for(Account user : users) {
			if(user.getLogin().equals(login)) {
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
		System.out.println(account.toString());
	}
	
	public Account login() {
		System.out.println("Login: ");
		String login = scan.next();
		
		for(Account user : users) {
			if(user.getLogin().equals(login)) {
				System.out.println("Password: ");
				String password = scan.next();
				if(user.getPassword().equals(password)) {
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
	
	public void editAccount(Account account) {
		System.out.println("What do you want to edit?");
		System.out.println("1 - About");
		System.out.println("2 - Age");
		System.out.println("3 - Address");
		System.out.println("4 - Password");
		System.out.println("5 - Close");
		
		int option = 0; 
		
		while(option != 5) {
			System.out.println("Insert option: ");
			option = scan.nextInt();
			
			switch(option) {
				case 1: 
					System.out.println("About: ");
					scan.nextLine();
					String about = scan.nextLine();
					account.setAbout(about);
					break;
				case 2: 
					System.out.println("Age: ");
					int age = scan.nextInt(); 
					account.setAge(age);
					break;
				case 3:
					scan.nextLine();
					System.out.println("Address: ");
					String address = scan.nextLine(); 
					account.setAddress(address);
					break;
				case 4: 
					System.out.println("Password: ");
					String password = scan.next();
					account.setPassword(password);
					break;
				case 5:
					System.out.println("Saved.");
					break;
				default:
					System.out.println("Invalid value.");
					break;
			}
					
		}
		
		System.out.println(account.toString());
		
	}
	
	public Account findAccount(String login) {
		for(Account account : users) {
			if(account.getLogin().equals(login)) {
				return account;
			}
		}
		return null;
	}
	
	public void addFriend(Account account) {
		System.out.println("Search for: ");
		Account friend = findAccount(scan.next());
		if(friend == null) {
			System.out.println("Doesn't exist.");
			return;
		} 
		
		if(account.getFriends().contains(friend.getLogin())) {
			System.out.println("You're already friends with " + friend.getLogin());
			return;
		} 
		
		if(account.getSendInvitation().contains(friend.getLogin())) {
			System.out.println("You're already sent invitation to " + friend.getLogin());
			return;
		} 
		
		friend.getReceivedInvitation().add(account.getLogin());
		account.getSendInvitation().add(friend.getLogin());
		
		System.out.println("Invite sent.");
		
	}
	
	public void accFriend(Account account) {
		System.out.println(account.getReceivedInvitation());
		System.out.println("Insert user who you want to manage: ");
		Account friend = findAccount(scan.next());
		if(friend == null) {
			System.out.println("Account doesn't exist.");
			return;
		}
		
		if(account.getReceivedInvitation().contains(friend.getLogin())) {
			System.out.println("Do you want to accept " + friend.getLogin() + "?");
			System.out.println("1 - Yes");
			System.out.println("2 - No");
			int option = scan.nextInt();
			
			if(option == 1) {
				account.getFriends().add(friend.getLogin());
				friend.getFriends().add(account.getLogin());
				System.out.println("You're friends with " + friend.getLogin() + "!");
			} else if(option == 2) {
				account.getReceivedInvitation().remove(friend.getLogin());
				friend.getSendInvitation().remove(account.getLogin());
			}
		} 
	}
		
		public void sendMessage(Account account) {
			System.out.println("Send message to: ");
			String receiver = scan.next();
			if(findAccount(receiver) != null) {
				System.out.println("Type your message: ");
				scan.nextLine();
				String msg = scan.nextLine();
				Message message = new Message(account.getLogin(), receiver, msg);
				messages.add(message);
			} else {
				System.out.println("Not found.");
			}

		}
		
		public void showMessages(Account account) {
			System.out.println("Who do you want to contact: ");
			String receiver = scan.next();
			if(findAccount(receiver) != null) {
				for(Message msg : messages) {
					if(msg.getSender().equals(receiver) || msg.getSender().equals(account.getLogin())) {
						if(msg.getReceiver().equals(account.getLogin()) || msg.getReceiver().equals(receiver)) {
							
							System.out.println(msg.getSender() + ": " + msg.getMessages());
							
						}
					} 
				}
				
			} else {
				System.out.println("Not found.");
			}
			
		}
		
		public void showAllMessages(Account account) {
			for(Message msg : messages) {
				System.out.println(msg.getSender() + ": " + msg.getMessages());
			}
		}
		
		public void createCommunity(Account account) {
			Community community = new Community();
			System.out.println("Community name: "); 
			scan.nextLine();
			String name = scan.nextLine(); 
			if(searchCommunity(name) != null) {
				System.out.println("Community already exists. Please, choose another name.");
			} else {
				community.setName(name);
				System.out.println("Description: ");
				community.setDescription(scan.nextLine());
				community.setCreator(account.getLogin());
				communities.add(community); 
				account.getCommunities().add(community);
				System.out.println(community.toString());
			}
		}
		
		public Community searchCommunity(String nameCommunity) {
			for(Community community : communities) {
				if(community.getName().equals((nameCommunity))) {
					return community;
				}
			} return null;
		}
		
		public void manageCommunity(Account account) {
			scan.nextLine();
			System.out.println("Search community: ");
			String nameCommunity = scan.nextLine();
			int option = 0;
			if(searchCommunity(nameCommunity)!=null) {
				if(searchCommunity(nameCommunity).getCreator().equals(account.getLogin())) {
					System.out.println("Search member you want to manage: ");
					String nameMember = scan.nextLine();
					if(searchCommunity(nameCommunity).getMembers().contains(nameMember)) {
						System.out.println("Do you want to delete? 1 - Yes / 2 - No");
						option = scan.nextInt();
						switch(option) {
						case 1:
							searchCommunity(nameCommunity).getMembers().remove(nameMember); 
							System.out.println("The user " + nameMember + " is not part of this community anymore.");
							break;
						case 2:
							System.out.println("Returning to menu.");
							break;
						default:
							System.out.println("Invalid value.");
							break;
						}
						
					} else {
						System.out.println("The user doesn't exist in this community. Do you want add? 1 - Yes / 2 - No");
						option = scan.nextInt();
						switch(option) {
						case 1:
							if(findAccount(nameMember)!=null) {
								searchCommunity(nameCommunity).getMembers().add(nameMember); 
								// adiciona o usuario na comunidade
								// FALTA ************* adiciona a comunidade no perfil do usuario 
							} else {
								System.out.println("User doesn't exists.");
							}
							break;
						case 2:
							System.out.println("Returning to menu.");
							break;
						default:
							System.out.println("Invalid value.");
							break;
						}
						
					}
					
					
				} else {
					System.out.println("You're not the host of this community.");
				}
			} else {
				return;
			}

		}
		
		public void joinCommunity(Account account) {
			System.out.println("Search community: ");
			scan.nextLine();
			String community = scan.nextLine();
			if(searchCommunity(community) != null) {
				Community aux = searchCommunity(community);
				
				for(Community c : account.getCommunities()) {
					if(c.getName().equals(community)) {
						System.out.println("You're already in this community.");
						return; 
					}
				}
				
				account.getCommunities().add(searchCommunity(community));
				System.out.println("You're now member of: " + community);
				System.out.println("List of communities: ");
				account.toStringCommunities();
				aux.getMembers().add(account.getLogin());
				return; 
			} 
			System.out.println("Community doesn't exist.");
		}
		
		public void getInformations(Account account) {
			System.out.println("------------- INFO --------------");
			System.out.println("Account: ");
			System.out.println("---------------------------");
			System.out.println(account.toString());
			System.out.println("---------------------------");
			System.out.println("Communities: ");
			System.out.println("---------------------------");
			account.toStringCommunities();
			System.out.println("---------------------------");
			System.out.println("Friends: ");
			account.toStringFriends();
			System.out.println("---------------------------");
			System.out.println("Messages: ");
			System.out.println("---------------------------");
			showAllMessages(account);
			System.out.println("---------------------------");
		}
		
		public void postFeed(Account account) { // corrigir pra caso o usuario seja inconveniente e digite != 1 ou 2
			System.out.println("Do you want to post (1) public or (2) private?"); 
			int option = scan.nextInt();
			scan.nextLine();
			System.out.println("Type your message: ");
			String message = scan.nextLine();
			Feed newMessage = new Feed(message, account.getLogin(), option);
			feed.add(newMessage);
		}
		
		public void showFeed(Account account) {
			for(Feed f : feed) {
				
				if(f.getPermission() == 1) {
					System.out.println("[PUBLIC] " + f.getSender() + ": " + f.getFeedMessages());
				}
				if(f.getPermission() == 2) { 
					if(f.getSender().equals(account.getLogin()) || account.getFriends().contains(f.getSender())) {
						System.out.println("[PRIVATE] " + f.getSender() + ": " + f.getFeedMessages());
						
					}
					
				}
					
			}
		}		
	}
