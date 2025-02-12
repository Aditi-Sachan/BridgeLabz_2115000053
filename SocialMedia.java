class Friend {
    int friendID;
    Friend next;
    
    Friend(int id) {
        this.friendID = id;
        this.next = null;
    }
}

class User {
    int userID;
    String name;
    int age;
    Friend friendList;
    User next;
    
    User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }
    
    void addFriend(int friendID) {
        Friend newFriend = new Friend(friendID);
        newFriend.next = friendList;
        friendList = newFriend;
    }
    
    void removeFriend(int friendID) {
        Friend current = friendList, prev = null;
        while (current != null && current.friendID != friendID) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            if (prev == null) friendList = current.next;
            else prev.next = current.next;
        }
    }
    
    boolean hasFriend(int friendID) {
        Friend current = friendList;
        while (current != null) {
            if (current.friendID == friendID) return true;
            current = current.next;
        }
        return false;
    }
    
    void displayFriends() {
        Friend current = friendList;
        while (current != null) {
            System.out.print(current.friendID + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    int countFriends() {
        int count = 0;
        Friend current = friendList;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

class SocialNetwork {
    User head;
    
    void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        newUser.next = head;
        head = newUser;
    }
    
    User findUserByID(int userID) {
        User current = head;
        while (current != null) {
            if (current.userID == userID) return current;
            current = current.next;
        }
        return null;
    }
    
    User findUserByName(String name) {
        User current = head;
        while (current != null) {
            if (current.name.equals(name)) return current;
            current = current.next;
        }
        return null;
    }
    
    void addFriendship(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);
        if (user1 != null && user2 != null) {
            user1.addFriend(userID2);
            user2.addFriend(userID1);
        }
    }
    
    void removeFriendship(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);
        if (user1 != null && user2 != null) {
            user1.removeFriend(userID2);
            user2.removeFriend(userID1);
        }
    }
    
    void findMutualFriends(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);
        if (user1 != null && user2 != null) {
            Friend f1 = user1.friendList;
            System.out.print("Mutual Friends: ");
            while (f1 != null) {
                if (user2.hasFriend(f1.friendID)) {
                    System.out.print(f1.friendID + " ");
                }
                f1 = f1.next;
            }
            System.out.println();
        }
    }
    
    void displayUserFriends(int userID) {
        User user = findUserByID(userID);
        if (user != null) {
            System.out.print("Friends of " + userID + ": ");
            user.displayFriends();
        }
    }
    
    void countUserFriends(int userID) {
        User user = findUserByID(userID);
        if (user != null) {
            System.out.println("User " + userID + " has " + user.countFriends() + " friends.");
        }
    }
    
    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();
        sn.addUser(1, "Alice", 25);
        sn.addUser(2, "Bob", 30);
        sn.addUser(3, "Charlie", 27);
        
        sn.addFriendship(1, 2);
        sn.addFriendship(1, 3);
        sn.displayUserFriends(1);
        sn.displayUserFriends(2);
        
        sn.findMutualFriends(1, 2);
        sn.removeFriendship(1, 2);
        sn.displayUserFriends(1);
        sn.countUserFriends(1);
    }
}
