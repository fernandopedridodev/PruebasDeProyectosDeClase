/*
* Este código pertence a @fernandopedridodev, para o seu uso ou modificación
* contactade en fernandopedridodev@gmail.com.
 */
package hangman;

/**
 *
 * @author fernandopedridodev <fernandopedridodev@gmail.com>
 */
public class WordGenerator {

    public HangMan hangMan;
    
    private String showInitMenu(){
        
        return null;
        
    }
    
    private void showGameMenu(){
        
    }
    
    private boolean showExitMenu() {
        
        return false;
        
    }
    
    public static void main(String[] args) {
        MenuGenerator menuGenerator = new MenuGenerator();
        
        do {
            menuGenerator.hangMan = new HangMan(menuGenerator.showInitMenu());
            menuGenerator.showGameMenu();   
        } while (!menuGenerator.showExitMenu());
    }
}
