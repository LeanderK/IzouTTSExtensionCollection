package leanderk.izou.tts.commonextensions;

import intellimate.izou.activator.Activator;
import intellimate.izou.contentgenerator.ContentGenerator;
import intellimate.izou.events.EventController;
import intellimate.izou.output.OutputExtension;
import intellimate.izou.output.OutputPlugin;
import ro.fortsoft.pf4j.Extension;

/**
 * Created by LeanderK on 14/11/14.
 */
@Extension
public class AddOn extends intellimate.izou.addon.AddOn{
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
    public EventController[] registerEventController() {
        return new EventController[0];
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
    public OutputExtension[] registerOutputExtension() {
        OutputExtension[] outputExtensions = new OutputExtension[1];
        outputExtensions[0] = new WelcomeExtension(getPropertiesContainer());
        return outputExtensions;
    }
}
