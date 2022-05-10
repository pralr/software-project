package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Account;

public class Menu {
	List<Account> users = new ArrayList<>();
	List<Chat> messagesChat = new ArrayList<>();
	List<CommunityMsg> commMessages = new ArrayList<>();
	List<Feed> feed = new ArrayList<>();
	List<Community> communities = new ArrayList<>();

	
	Scanner scan = new Scanner(System.in);
	
	public Menu() {
		Account account = new Account("pri", "1", "pri");
		users.add(account);
		account = new Account("arthurfeiao", "2", "arthur");
		users.add(account);
		account = new Account("willfalso", "3", "will");
		users.add(account);
		account = new Account("mesquitafofo", "4", "mesquita");
		users.add(account);
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
	        	 if(!(account == null))
	        		 loggedMenu(account);
                 break;
             case 3:
                 System.out.println("Closed.");
                 return;
             default:
                 System.out.println("Invalid value.");
                 break;
         }
      }
	}
	
	public void loggedMenu(Account account) {
		 while(true) {
	         System.out.println("1 - Edit account");
	         System.out.println("2 - Add friend");
	         System.out.println("3 - Acc friend");
	         System.out.println("4 - Send message");
	         System.out.println("5 - Chat");
	         System.out.println("6 - Join community");
	         System.out.println("7 - Create community");
	         System.out.println("8 - Manage members of my communities");
	         System.out.println("9 - Send message to communities");
	         System.out.println("10 - Recover data");
	         System.out.println("11 - Send message to feed");
	         System.out.println("12 - Show feed");
	         System.out.println("13 - Delete account");
	         System.out.println("14 - Exit");
	         
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
	            	 accFriend(account);
	            	 break;
	             case 4:
	            	 sendMessage(account);
	            	 break;
	             case 5: 
	            	 showMessages(account);
	            	 break;
	             case 6:
	            	 joinCommunity(account);
	            	 break;
	             case 7: 
	            	 createCommunity(account);
	            	 break;
	             case 8:
	            	 manageCommunity(account);
	            	 break;
	             case 9:
	            	 sendMessagetoCommunity(account);
	            	 break;
	             case 10: 
	            	 getInformations(account);
	            	 break;
	             case 11:
	            	 postFeed(account);
	            	 break;
	             case 12:
	            	 showFeed(account);
	            	 break;
	             case 13:
	            	 Integer opt = deleteAccount(account);
	            	 if(opt.equals(1)) { 
	            		 return;
	            	 }
	            	 if(opt.equals(2)) { 
	            		 break;
	            	 }
	             case 14: 
	            	 System.out.println("See you soon, " + account.getLogin() + "!");
	            	 return;
	             default:
	                 System.out.println("Invalid value.");
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
	
	public Account searchAccount(String login) {
		for(Account account : users) {
			if(account.getLogin().equals(login)) {
				return account;
			}
		}
		return null;
	}
	
	public void addFriend(Account account) {
		System.out.println("Search for: ");
		Account friend = searchAccount(scan.next());
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
		
		if(account.getReceivedInvitation().contains(friend.getLogin())) {
			System.out.println("The user " + account.getLogin() + " already sent invitation to you.");
			return;
		}
		
		friend.getReceivedInvitation().add(account.getLogin());
		account.getSendInvitation().add(friend.getLogin());
		
		System.out.println("Invite sent.");
		
	}
	
	public void accFriend(Account account) {
		System.out.println(account.getReceivedInvitation());
		System.out.println("Insert user who you want to manage: ");
		Account friend = searchAccount(scan.next());
		if(friend == null) {
			System.out.println("No user with that name has added you.");
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
				System.out.println("You declined + " + friend.getLogin() + "'s invitation.");
			}
			account.getReceivedInvitation().remove(friend.getLogin());
			friend.getSendInvitation().remove(account.getLogin());
		} 
	}
		
		public void sendMessage(Account account) {
			System.out.println("Send message to: ");
			String receiver = scan.next();
			if(searchAccount(receiver) != null) {
				System.out.println("Type your message: ");
				scan.nextLine();
				String msg = scan.nextLine();
				Chat message = new Chat(account.getLogin(), msg, receiver);
				messagesChat.add(message);
			} else {
				System.out.println("Not found.");
			}

		}
		
		public void showMessages(Account account) {
			System.out.println("Who do you want to contact: ");
			String receiver = scan.next();
			if(searchAccount(receiver) != null) {
				for(Chat msg : messagesChat) {
					if(msg.getSender().equals(receiver) || msg.getSender().equals(account.getLogin())) {
						if(msg.getReceiver().equals(account.getLogin()) || msg.getReceiver().equals(receiver)) {
							System.out.println(msg.getSender() + ": " + msg.getMessage());
						}
					} 
				}
				
			} else {
				System.out.println("Not found.");
			}
			
		}
		
		public void showAllMessages(Account account) {
			for(Chat msg : messagesChat) {
				System.out.println(msg.getSender() + ": " + msg.getMessage());
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
							Account aux = searchAccount(nameMember);
							aux.getCommunities().remove(searchCommunity(nameCommunity));
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
							if(searchAccount(nameMember)!=null) {
								searchCommunity(nameCommunity).getMembers().add(nameMember); 
							    Account aux = searchAccount(nameMember); 
								aux.getCommunities().add(searchCommunity(nameCommunity));
								System.out.println("The user " + nameMember + " it's in your community.");
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
					return;
				}
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
		
		public void sendMessagetoCommunity(Account account) {
			System.out.println("------------MY COMMUNITIES--------------");
			for(Community c : account.getCommunities()) {
				System.out.println("-----> " + c.getName());
			}
			System.out.println("Community you want to send a message: ");
			scan.nextLine();
			String communityName = scan.nextLine();
			if(searchCommunity(communityName)!=null) {
				if(account.getCommunities().contains(searchCommunity(communityName))) {
					System.out.println("Send message to: " + communityName);
					String msg = scan.nextLine();
					CommunityMsg newmsg = new CommunityMsg(account.getLogin(), msg, communityName);
					commMessages.add(newmsg);
					System.out.println("Do you want to see community messages? 1 - Yes / 2 - No");
					Integer option = scan.nextInt();
					if(option.equals(1)) {
						for(CommunityMsg m : commMessages) {
							if(m.getCommunity().equals(communityName)) {
								System.out.println(m.getSender() + ": " + m.getMessage());
							}
						}
					} else if (option.equals(2)) {
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
		}
		
		public void getInformations(Account account) {
			System.out.println("------------- INFO --------------");
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
		
		public void postFeed(Account account) { 
			System.out.println("Do you want to post (1) public or (2) private?"); 
			Integer option = scan.nextInt();
			if(option.equals(1) || option.equals(2)) {
				System.out.println("Type your message: ");
				scan.nextLine();
				String message = scan.nextLine();
				Feed newMessage = new Feed(account.getLogin(), message, option);
				feed.add(newMessage);
				return;
			}
			System.out.println("Invalid value.");
		}
		
		public void showFeed(Account account) {
			for(Feed f : feed) {
				
				if(f.getPermission() == 1) {
					System.out.println("[PUBLIC] " + f.getSender() + ": " + f.getMessage());
				}
				if(f.getPermission() == 2) { 
					if(f.getSender().equals(account.getLogin()) || account.getFriends().contains(f.getSender())) {
						System.out.println("[PRIVATE] " + f.getSender() + ": " + f.getMessage());
						
					}
					
				}
					
			}
		}
		
		
		public void deleteCommunities(Account account) { 
			List<Community> delete = new ArrayList<>();
			Account otherAccount = new Account();
			
			for(Community c : communities) {
				if(c.getCreator().equals(account.getLogin())) {
					c.getMembers().clear(); 
					delete.add(c);
				}
			}
	
			for(Account user : users) {
					otherAccount = searchAccount(user.getLogin());
					otherAccount.getCommunities().removeAll(delete);
			}
			communities.removeAll(delete);
			
		}
		
		public void deleteCommunitiesMsg(Account account) {
			List<CommunityMsg> delete = new ArrayList<>();
			for(CommunityMsg msg : commMessages) {
				if(msg.getSender().equals(account.getLogin())) {
					delete.add(msg);
				}
			}
			commMessages.removeAll(delete);
		}
		
		public void deleteFeed(Account account) {
			List<Feed> delete = new ArrayList<>();
			for(Feed f : feed) {
				if(f.getSender().equals(account.getLogin())) {
					delete.add(f);
				}
			} feed.removeAll(delete);
		}
		
		public void deleteMessages(Account account) {
			List<Chat> delete = new ArrayList<>();
			for(Chat m : messagesChat) {
				if(m.getSender().equals(account.getLogin()) || m.getReceiver().equals(account.getLogin())) {
					delete.add(m);
				}
			}
			messagesChat.removeAll(delete);
		}
		
		public void deleteInvit(Account account) {
			Account otherAccount = new Account();
			for(Account user : users) {
				otherAccount = searchAccount(user.getLogin());
				otherAccount.getReceivedInvitation().remove(user.getLogin());
			}
		}
		
		public int deleteAccount(Account account) {
			System.out.println("Are you sure you want to leave us? 1 - Yes / 2 - No");
			int option = scan.nextInt(); 
			switch(option) {
			case 1:
				deleteCommunities(account);
				deleteCommunitiesMsg(account);
				deleteFeed(account);
				deleteMessages(account);
				deleteInvit(account);
				account.setLogin(null);
				account.setNickname(null);
				account.setPassword(null);
				account.setAbout(null);
				account.setAddress(null);
				account.setAge(0);
				getInformations(account);
				users.remove(account);
				System.out.println("------------- REMAINING USERS -------------");
				for(Account user : users) {
					System.out.println(user.getLogin());
				}
				System.out.println("--------------------------------------------");
				return 1;
			case 2:
				System.out.println("We're happy that you will continue with us.");
				return 2;
			default:
				System.out.println("Invalid value.");
				return -1;
			}
		} 
	}

