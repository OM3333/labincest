public interface Food extends Cloneable {
    default boolean isCookable() {
        return false;
    }
}
