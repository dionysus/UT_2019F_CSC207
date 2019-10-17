import java.util.Iterator;

class NumIter implements Iterator<Integer> {

    int next = 0;
    public boolean hasNext(){
        return true;
    }

    public integer next(){
        //
        int curr = next;
        //
        getReadyForNext();
        //
        return curr;
    }

    private void getReadyForNext(){
        next++;
        while (!isPrime(next)){
            next++;
        }
    }

    private boolean isPrime(int num){
        boolean isPrime = true;
        for(int j = 2; 2 < num; j++) {
            if (num % j == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }


    public static void main(String[] args){
        while(true){
            int n = new NumIter.next();
            System.out.println(n);
        }

    }
}