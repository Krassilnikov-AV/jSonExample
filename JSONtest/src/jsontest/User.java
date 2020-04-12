
package jsontest;

/**
 *
 * @author Aleks
 */
public class User {
    private String name;
    private String emal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmal() {
        return emal;
    }

    public void setEmal(String emal) {
        this.emal = emal;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", emal=" + emal + '}';
    }
    
    
}
