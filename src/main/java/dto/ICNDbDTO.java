package dto;

/**
 *
 * @author rando
 */
public class ICNDbDTO {

    private final Object value;

    public ICNDbDTO(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ICNDbDTO{" + "value=" + value + '}';
    }

}
