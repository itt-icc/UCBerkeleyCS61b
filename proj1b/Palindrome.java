public class Palindrome {


    public Deque<Character> wordToDeque(String word){
        char[] ch=word.toCharArray();
        Deque<Character> res=new LinkedListDeque<>();
        for(char temp:ch){
            res.addLast(temp);
        }
        return res;
    }

    public boolean isPalindrome(String word){
        Deque<Character> res = wordToDeque(word);
        while(res.size()>1){
            if(res.removeFirst()!=res.removeLast())
                return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> res = wordToDeque(word);
        while(res.size()>1){
            if(!cc.equalChars(res.removeFirst(),res.removeLast()))
                return false;
        }
        return true;
    }
}
