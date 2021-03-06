package leanderk.izou.tts.commonextensions;

import ro.fortsoft.pf4j.PluginWrapper;

/**
 * Created by LeanderK on 14/11/14.
 */
public class ZipFileManager extends org.intellimate.izou.sdk.addon.ZipFileManager {
    /**
     * Constructor to be used by plugin manager for plugin instantiation.
     * Your plugins have to provide constructor with this exact signature to
     * be successfully loaded by manager.
     *
     * @param wrapper
     */
    public ZipFileManager(PluginWrapper wrapper) {
        super(wrapper);
    }
}
