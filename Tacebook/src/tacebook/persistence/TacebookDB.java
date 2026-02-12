/*
* Este código pertence a @fernandopedridodev, para o seu uso ou modificación
* contactade en fernandopedridodev@gmail.com.
 */
package tacebook.persistence;

import java.util.ArrayList;
import tacebook.model.Profile;

/**
 * Garda un arraylist estático de Profiles como persistencia 
 * @author fernandopedridodev <fernandopedridodev@gmail.com>
 */
public class TacebookDB {
    public static final ArrayList<Profile> profiles = new ArrayList<>();
}