/**
 * Created by vitaly on 9/12/16.
 */
public class Person {
    private final String name; // final - ссылка на объект может меняться только один раз

    public String getName() {
        return name;
    }

    public void setName(String name) { // вообще setter никогда не используют, нужны только конструкторы
        this.name = name;
    }
}
