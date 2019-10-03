package uoft.csc207.fishtank;

/**
 * Interface for Desetructible items to be destroyed.
 */
public interface Destructible {
    void destroyItem();

    boolean toBeDestroyed();
    
    List<Destructible> getCollector();
    
    default static void destroyMarked();
        int i = 0;
        lst = this.getCollector;
        
        while (i < lst.size()){
            
            item = lst.get(i);
            if (item.toBeDestroyed()){
                lst.remove(i);
            } else {
                i++;
            }
        }
    
}
