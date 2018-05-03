/* File: WordSalad.java - April 2018 */
package week09;

/**
 *  Skeleton implementation of the WordSalad class.
 *
 *  @author Michael Albert
 */
public class WordSalad implements Iterable<String> {
    /**WordNode object of the first element of the linked list.*/
    private WordNode first;
    /**WordNode object of the last element of the linked list.*/
    private WordNode last;
    
    /**Constructor of a WordSalad object that sets the first and last elements
     * of the WordNode linked list to null.*/
    public WordSalad() {
        this.first = null;
        this.last = null;
    }

    /**WordSalad constructor.
     * @param words is a word to be added to the end of the WordNode linked
     * list.*/
    public WordSalad(java.util.List<String> words) {
        for (String word : words) {
            addLast(word);
        }
    }

    /**Method to add a word to the start of the linked list.
     * @param word the word to be added to the linked list.*/
    public void add(String word) {
        //if the linked list is originally empty, create a new WordNode linked
        //list and add the word to the first element in the linked list.
        if (this.first == null) {
            this.first = new WordNode(word, null);
            this.last = this.first;
            return;
        }
        WordNode newFirst = new WordNode(word, this.first);
        this.first = newFirst;
    }

    /**Method to add a word to the end of a WordNode linked list.
     * If the list is empty, calls the add method on the word parameter to add
     * it to the beginning of the list
     * @param word the word to be added.*/
    public void addLast(String word) {
        if (this.first == null) {
            add(word);
            return;
        }
        WordNode newLast = new WordNode(word, null);
        this.last.next = newLast;
        this.last = newLast; 
    }
 
    /**Embedded class to build the singly linked list of words (nodes) and
     * their next pointer.*/
    private class WordNode {

        /**The string value of the word in this WordNode.*/
        private String word;
        /**The next node that will follow the current node in the linked
         * list.*/
        private WordNode next;
        
        /**The WordNode constructor builds a linked list of objects that
         * contain a string value and a pointer value.
         * @param word The string of the word to be added to the list.
         * @param next The WordNode object that will follow this node 
         * in the linked list.*/
        private WordNode(String word, WordNode next) {
            this.word = word;
            this.next = next;
        }
    }
 
    /**The iterator method is part of the Iterable interface implemented in the
     * program.
     * @return Iterator over elements of type <String>.*/
    public java.util.Iterator<String> iterator() {
        return new java.util.Iterator<String>() {
            private WordNode current = first;
      
            public boolean hasNext() {
                return current != null;
            }
      
            public String next() {
                String result = current.word;
                current = current.next;
                return result;
            }
      
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
           
    /**A toString method which is used to build a readable string of the
     * WordNode word values in the linked list.
     * @return String which appends all the words together seperated by commas
     * and [, ].*/
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        WordNode node = first;
        while (node != null) {
            result.append(node.word);
            result.append(node.next == null ? "" : ", ");
            node = node.next;
        }
        return result.toString() + "]";
    }


    // Method stubs to be completed for the assignment.
    // See the assignment description for specification of their behaviour.
    
    /**Distributes <code>this</code> into an array of k instances of
     * WordSalad objects. 
     * @param k is a positive integer that represents the number of instances.
     * @return WordSalad[] of the words rearranged using the distribute
     * method.
     *
     * Distribute method is:
     *      
     *      To distribute words into k blocks 
     *          1st word goes into 1st block,
     *          2nd word goes into 2nd block,
     *          kth word goes into kth block.
     *
     * If there's left over words, loop back to first block. This means that
     * the first few blocks can have more words than the others.
     * If we run out of words, just stop.
     *
     *          9 words split by k = 3
     *          [The quick brown fox jumps over the lazy dog]
     *
     *          [The, fox, the], [quick, jumps, lazy], [brown, over, dog]*/
    public WordSalad[] distribute(int k) {
        //output array
        WordSalad[] output = new WordSalad[k];
        WordNode current = this.first;
        
        //index of where to set current to start
        int index = 0;

        //for every object to create
        for(int i = 0; i < k; i++){
            
            //move current to the right index times
            for(int a = 0; a < index; a++){
                current = current.next;
            }

            //create a new WordSalad empty object
            WordSalad distObj = new WordSalad();
            
            //while moving hasn't pushed current off the end of the list
            while(current != null){
                distObj.addLast(current.word);

                //move current along k nodes
                //catch null pointer when reach end
                try{
                    for(int m = 0; m < k; m++){
                        current = current.next;
                    }
                }catch(NullPointerException e){}
            }
            
            //reset current to the start
            current = this.first;

            //increase index so index moves the current one more to the right
            index++;

            //add the final object to the array
            output[i] = distObj;
        }
        return output;
    }
       
    /**Chops the words into nearly equally sized blocks.
     * @param k The number of blocks to split the words into.
     * @return WordSalad[] of the words rearranged using the chop method.
     *
     * Chop method is:
     *
     *      To chop words into k blocks
     *          Chop the words into k number of blocks of nearly equal sizes
     *          Add the words into the blocks in order until that block is
     *          full, move onto the next block.
     *
     * If the number of words doesn't divide equally by k, the first few blocks
     * will be larger.
     *
     *      e.g. 
     *              17 words split by k = 5
     *              [4], [4], [3], [3], [3]
     *
     *              9 words split by k = 3
     *              [The quick brown fox jumps over the lazy dog]
     *
     *              [The, quick, brown], [fox, jumps, over], [the, lazy, dog]*/
    public WordSalad[] chop(int k) {
        return null;
    }
    
    
    public WordSalad[] split(int k) {
        return null;
    }
        
    public static WordSalad merge(WordSalad[] blocks) {
        return null;
    }
        
    public static WordSalad join(WordSalad[] blocks) {
        return null;
    }

    public static WordSalad recombine(WordSalad[] blocks, int k) {
        return null;
    }

}
