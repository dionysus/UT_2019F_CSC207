package uoft.csc207.fishtank;

/**
 * Interface for Desetructible items to be destroyed.
 */
public interface Destructible {
    void destroyItem();

    boolean toBeDestroyed();
}
