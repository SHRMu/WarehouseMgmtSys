package Util;

import javax.swing.UIManager;
import java.awt.*;

public class MgmtSysUtil {

    private MgmtSysUtil(){

    }

    public static Font mainFrameFont = new Font("Serif", Font.PLAIN, 32);
    public static Font frameFont = new Font("Serif", Font.PLAIN, 28);
    public static Font btnFont = new Font("Serif",Font.ITALIC,40);

    public static void setUIFont (javax.swing.plaf.FontUIResource f){
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put (key, f);
        }
    }

}

