/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipraktikumpbo;

/**
 *
 * @author Agil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ViewMovie view = new ViewMovie();
        ModMovie model = new ModMovie();
        Cont controller = new Cont(model, view);
    }
    
}
