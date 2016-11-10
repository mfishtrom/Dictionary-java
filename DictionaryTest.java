class DictionaryTest{

   public static void main(String[] args){
      Dictionary A = new Dictionary(); //creates a basic Dictionary
      System.out.println(A.isEmpty()); //should return true
      System.out.println(A.size()); //should return zero
      A.insert("1", "M"); //inserts value and key into Dictionary
      System.out.println(A.lookup("1")); //lookup should return M
      A.insert("2", "a"); //inserts a into Dictionary
      System.out.println(A.size()); //return 2
      System.out.println(A.toString()); //prints out Dictionary contents
      A.delete("2"); //deletes 2 and a from dictionary
      System.out.println(A.size()); //returns 1
      System.out.println(A.isEmpty()); //should return false

      try{
         A.insert("1", "Duplicate"); //thrwos DuplicateKeyException
      }catch(DuplicateKeyException e){
         System.out.println("Caught Exception " + e);
      }

      try{
        A.delete("5");
      }catch(KeyNotFoundException e){
         System.out.println("Caught Exception "+ e);
      }

      A.makeEmpty();//makes A empty
      System.out.println(A.isEmpty()); //should return true

   }

}

/*I left it uncommented in case you wanted to test it as well.
 *
 * output should be
 * true
 * M
 * 2
 * 1 M
 * 2 a
 *
 * 1
 * false
 * Caught Exception DuplicateKeyException: cannot insert duplicate keys
 * Caught Exception KeyNotFoundException: cannot delete non existent key
 * true
 */
