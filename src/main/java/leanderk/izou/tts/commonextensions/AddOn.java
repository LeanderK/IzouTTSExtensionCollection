package leanderk.izou.tts.commonextensions;

import org.intellimate.izou.sdk.activator.Activator;
import org.intellimate.izou.sdk.contentgenerator.ContentGenerator;
import org.intellimate.izou.sdk.events.EventsController;
import org.intellimate.izou.sdk.output.OutputExtensionArgument;
import org.intellimate.izou.sdk.output.OutputPlugin;
import ro.fortsoft.pf4j.Extension;

/**
 * Created by LeanderK on 14/11/14.
 */
@Extension
public class AddOn extends org.intellimate.izou.sdk.addon.AddOn{
    public static final String ID = AddOn.class.getCanonicalName();
    /**
     * the default constructor for AddOns
     */
    public AddOn() {
        super(ID);
    }

    /**
     * use this method to build your instances etc.
     */
    @Override
    public void prepare() {

    }

    /**
     * use this method to register (if needed) your Activators.
     *
     * @return Array containing Instances of Activators
     */
    @Override
    public Activator[] registerActivator() {
        return new Activator[0];
    }

    /**
     * use this method to register (if needed) your ContentGenerators.
     *
     * @return Array containing Instances of ContentGenerators
     */
    @Override
    public ContentGenerator[] registerContentGenerator() {
        return new ContentGenerator[0];
    }

    /**
     * use this method to register (if needed) your EventControllers.
     *
     * @return Array containing Instances of EventControllers
     */
    @Override
    public EventsController[] registerEventController() {
        return new EventsController[0];
    }

    /**
     * use this method to register (if needed) your OutputPlugins.
     *
     * @return Array containing Instances of OutputPlugins
     */
    @Override
    public OutputPlugin[] registerOutputPlugin() {
        return new OutputPlugin[0];
    }

    /**
     * use this method to register (if needed) your Output.
     *
     * @return Array containing Instances of OutputExtensions
     */
    @Override
    public OutputExtensionArgument[] registerOutputExtension() {
        OutputExtensionArgument[] outputExtensions = new OutputExtensionArgument[1];
        outputExtensions[0] = new WelcomeExtension(getContext());
        return outputExtensions;
    }

    @Override
    public String getID() {
        return ID;
    }
}
