/*
 * Creation:    May 8, 2015
 * 
 */

package com.main;

import com.app.data.AppController;
import com.app.data.AppData;
import com.app.view.Application;
import com.exceptions.AppError;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * <h1>Main</h1>
 * <p>public class Main</p>
 *
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
public class Main {

    /**
     * Main function
     * Call and display the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    AppData         model       = new AppData();
                    AppController   controller  = new AppController(model);
                    Application     app         = new Application(controller);
                    app.pack();
                    app.setLocationRelativeTo(null);
                    app.setVisible(true);
                } catch(AppError ex) {
                    DebugTrack.showErrMsg("Unable to start program!");
                }
            }
        });
    }
    
    /*
    if (args.length < 1) {
        System.out.println("Wrong parameter : java Main <namefile>");
        //System.exit(1);
    }
    Grammar1    gr  = new Grammar1();
    Parser      p   = new Parser(gr);
    p.startParser(Parser.MODE_GENERAL, "data/testFiles/good/good1.txt");
    */
}
