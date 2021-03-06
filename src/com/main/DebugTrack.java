/*
 * Creation:    May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.main;

import com.parser.asset.Token;
import com.parser.instructions.actions.ActionInstruction;
import java.util.ArrayList;



/**
 * <h1>DebugTrack</h1>
 * <p>public class DebugTrack</p>
 *
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
public abstract class DebugTrack {
    //**************************************************************************
    // Constants - variables
    //**************************************************************************
    private static final boolean debug_mode         = true;
    private static final boolean debug_mode_brief   = true;
    
    
    //**************************************************************************
    // Functions Debug
    //**************************************************************************
    /**
     * Display data about a Token (Call toString)
     * @param pToken Token to display
     */
    public static void showToken(Token pToken){
        if(debug_mode == false){return;}
        if(pToken == null){
            System.err.println(" *** Debug in '"+DebugTrack.getfctName()+" : Token given is null!");
        } 
        else if (debug_mode_brief == true){
            System.out.println(pToken.toString());
        } else{
            System.out.println(" *** Debug in '"+DebugTrack.getfctName()+" : "+pToken.toString());
        }
    }
    
    /**
     * Display a message for tmp debug. Display which function called the track 
     * and show data
     * @param str 
     */
    public static void showDebugMsg(String str){
        if(debug_mode == false){return;}
        else if (debug_mode_brief == true){
            System.out.println(" *** "+str);
        } else{
            System.out.println(" *** Debug in '"+DebugTrack.getfctName()+"' -> "+str);
        }
    }
    
    /**
     * Display a list of ActionInstruction
     * @param pList list of ActionInstruction
     */
    public static void showActionInstructions(ArrayList<ActionInstruction> pList){
        if(debug_mode == false){return;}
        System.out.println();
        if (debug_mode_brief == true){
            for(ActionInstruction i : pList){
                System.out.println(" *** Action : "+i.getDescription());
            }
        } else{
            for(ActionInstruction i : pList){
                System.out.println(" *** Debug in '"+DebugTrack.getFctNameAtStackTrack(3)
                                   +"' -> "+i.getDescription());
            }
        }
        System.out.println();
    }
    
    
    //**************************************************************************
    // Error message
    //**************************************************************************
    /**
     * Display error message, then return line
     * @param str message to display
     */
    public static void showErrMsg(String str){
        if(debug_mode == false){return;}
        System.err.println(" Error in '"+DebugTrack.getfctName()+"' : "+str);
    }
    
    
    //**************************************************************************
    // Application debug for data
    //**************************************************************************
    /**
     * Get a message with all data about a Stack function child
     * @param nb function position in the stack
     * @return String str
     */
    private static String getStackTraceChild(int nb){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String  fctName     = stackTraceElements[nb].getClassName();
        String  fileName    = stackTraceElements[nb].getFileName();
        String  methodName  = stackTraceElements[nb].getMethodName();
        int     nbLine      = stackTraceElements[nb].getLineNumber();

        String msg = "Error data : \n"
                     +"\tFile : "+fileName+"\n"
                     +"\tMethod : "+methodName+"\n"
                     +"\tAt line : "+nbLine+"\n";
        DebugTrack.showErrMsg(msg);
        return msg;
    }
    
    /**
     * Return name of the function which has called the debug track
     * @return string name
     */
    private static String getfctName(){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getClassName();
    }
    
    /**
     * Get function name at a specific position in stackTrack
     * @param pValue position in stackTrack
     * @return String name of function
     */
    private static String getFctNameAtStackTrack(int pValue){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[pValue].getClassName();
    }
}
