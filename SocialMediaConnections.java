import java.util.*;

class User{
    int userId, age;
    String name;
    List<Integer> friends;
    User next;

    public User(int userId, String name, int age){
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia{
    private User head;

    public void addUser(int userId, String name, int age){
        User newUser = new User(userId, name, age);
        if(head == null){
            head = newUser;
        }
		else{
            User temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public User findUser(int userId){
        User temp = head;
        while(temp != null){
            if(temp.userId == userId){
				return temp;
			}
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userId1, int userId2){
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if(user1==null || user2==null){
            System.out.println("User not found");
            return;
        }
        if(!user1.friends.contains(userId2)){
			user1.friends.add(userId2);
		}
        if(!user2.friends.contains(userId1)){
			user2.friends.add(userId1);
		}
    }

    public void removeFriend(int userId1, int userId2){
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if(user1==null || user2==null){
            System.out.println("User not found");
            return;
        }
        user1.friends.remove(Integer.valueOf(userId2));
        user2.friends.remove(Integer.valueOf(userId1));
    }

    public void displayFriends(int userId){
        User user = findUser(userId);
        if(user == null){
            System.out.println("User not found");
            return;
        }
        System.out.println(user.name + "'s Friends: " + user.friends);
    }

    public void findMutualFriends(int userId1, int userId2){
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if(user1==null || user2==null){
            System.out.println("User not found");
            return;
        }
        List<Integer> mutual = new ArrayList<>(user1.friends);
        mutual.retainAll(user2.friends);
        System.out.println("Mutual Friends: " + mutual);
    }

    public void searchUser(String name){
        User temp = head;
        while(temp != null){
            if(temp.name.equalsIgnoreCase(name)){
                System.out.println("User Found: ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found");
    }

    public void countFriends(int userId){
        User user = findUser(userId);
        if(user == null){
            System.out.println("User not found");
            return;
        }
        System.out.println(user.name + " has " + user.friends.size() + " friends");
    }
}

public class SocialMediaConnections{
    public static void main(String[] args){
        SocialMedia network = new SocialMedia();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n1. Add User\n2. Add Friend\n3. Remove Friend\n4. Display Friends\n5. Find Mutual Friends\n6. Search User\n7. Count Friends\n8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter User ID, Name, and Age: ");
                    network.addUser(sc.nextInt(), sc.next(), sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter User IDs to Connect as Friends: ");
                    network.addFriend(sc.nextInt(), sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter User IDs to Remove Friendship: ");
                    network.removeFriend(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter User ID to Display Friends: ");
                    network.displayFriends(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Two User IDs to Find Mutual Friends: ");
                    network.findMutualFriends(sc.nextInt(), sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter Name to Search: ");
                    network.searchUser(sc.next());
                    break;
                case 7:
                    System.out.print("Enter User ID to Count Friends: ");
                    network.countFriends(sc.nextInt());
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}