// Madison Fishtrom
// mfishtro
// CMPS 12B
// pa3
// Dictionary.java
// Dictionary ADT with methods to look at size, find specific pairs, insert new pairs, delete a pair, empty the dictionary, and returns a string of the contents of the dictionary

class Dictionary implements DictionaryInterface{

   private class Node{
      String key;
      String value;
      Node next;

      Node(String key, String value){
         this.key = key;
         this.value = value;
         next = null;
      }
   }

   //variables only for Dictionary class
   private Node head;
   private int numItems;

   private Node findKey(String key){ //helper for lookup and other methods
      /*This method should return a reference to the Node containing its argument key, or return null if no such Node exists*/
      Node M = head;
      while(M != null){
         if(M.key != key){
            M = M.next;
         }else{
            return M;
         }
      }
      return null;
   }

   public boolean isEmpty(){
      //returns true if the Dictionary contains no pairs and returns false otherwise
      return (numItems == 0);
   }

   public int size(){
      /*Returns the number of (key, value) pairs in the Dictionary*/
      return numItems;
   }

   public String lookup(String key){
      /*If the Dictionary contains a pair whose key field matches the argument key,
lookup returns the associated value field. If no such pair exists in the Dictionary
a null reference is returned.*/
      Node M = findKey(key);
      while(M != null){
      if(M.key.equals(key)){
         return M.value;
      }
      M = M.next;
   }
   return null;
}

public void insert(String key, String value){
   /*If the Dictionary does not currently contain a pair whose key matches the argument key, then the pair (key, value) is added to the Dictionary. If such a pair does exist, a DuplicateKeyException will be thrown with the message: "cannot insert duplicate keys". Thus insert() has the precondition that the Dictionary does not currently contain the argument key. This precondition can be tested by the client module by doing lookup(key)==null.*/
   if(lookup(key) != null){ //makes sure key is null, throws exception otherwise
      throw new DuplicateKeyException("cannot insert duplicate keys");
   }else{
      if(head == null){
         Node M = new Node(key, value); //creates a new node to insert
         head = M;
      }else{
         Node M = head;
         while(M != null){
            if(M.next == null) break;
            M = M.next;
         }
         M.next = new Node(key, value);
      }
      numItems++; //increase items because you're adding a value
   }
}

public void delete(String key){
   /*If the Dictionary currently contains a pair whose key field matches the argument key, then that pair is removed form the Dictionary. If no such pair exists, then a KeyNotFoundException is thrown with the message: "cannot delete non-existent key". Thus delete() has the precondition that the Dictionary currently contains the argument key. This precondition can be tested by the client module by doing lookup(key)!=null.*/
  if(lookup(key) == null){
     throw new KeyNotFoundException("cannot delete non-existent key");
  }else{
      if(numItems <= 1){
         Node M = head;
         head = head.next;
         M.next = null; //deletes item
      }else{
         Node M = head;
         if(M.key.equals(key)){
            head = M.next; //deletes item
         }else{
            while(!M.next.key.equals(key)){
               M = M.next;
            }
            M.next = M.next.next;
         }
      }
      numItems--; //if item is deleted, there is one less value stored
   }
}

public void makeEmpty(){
   /*Resets the Dictionary to the empty state.*/
   head = null; //head is dictionary-- nullifying makes it empty
   numItems = 0; //if empty, it has no items
}

public String toString(){
   /*Returns a String representation of the current state of the Dictionary. Keys will be separated from values by a single space, and consecutive pairs will be separated by newline characters. The return String will be terminated by a newline character. Pairs will occur in the return String in the same order they were inserted into the Dictionary.*/
   String str = "";
   Node M = head;
   while(M != null){ //goes through until M is empty
      str += M.key + " " + M.value + "\n"; //prints on a line
      M = M.next;
   }
   return str;
}
}
