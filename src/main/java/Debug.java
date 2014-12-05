import intellimate.izou.addon.AddOn;
import intellimate.izou.main.Main;

import java.util.LinkedList;

/**
 * Use this class to debug
 */
public class Debug {
    public static void main(String[] args) {
        LinkedList<AddOn> addOns = new LinkedList<>();
        addOns.add(new leanderk.izou.tts.TTS());
        addOns.add(new leanderk.izou.tts.commonextensions.AddOn());
        Main main = new Main(addOns, true);
    }
}
