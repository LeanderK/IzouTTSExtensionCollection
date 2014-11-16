package leanderk.izou.tts.commonextensions;

import intellimate.izou.addon.PropertiesContainer;
import intellimate.izou.contentgenerator.ContentData;
import leanderk.izou.tts.outputextension.TTSData;
import leanderk.izou.tts.outputextension.TTSOutputExtension;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by LeanderK on 14/11/14.
 */
public class WelcomeExtension extends TTSOutputExtension{
    public static final String ID = WelcomeExtension.class.getCanonicalName();
    public static final String TTS_Greeting_MORNING = "greetingMorning";
    public static final String TTS_Greeting_MIDDAY = "greetingMidday";
    public static final String TTS_Greeting_Evening = "greetingEvening";
    public static final String TTS_Greeting = "greeting";
    public static final String TTS_Salutation = "salutation";
    /**
     * creates a new outputExtension with a new id
     */
    public WelcomeExtension(PropertiesContainer propertiesContainer) {
        super(ID, propertiesContainer);
        addContentDataToWishList("leanderk.izou.personalinformation.InformationAddOn");
        setPluginId("leanderk.izou.tts.outputplugin.TTSOutputPlugin");
    }

    @Override
    public TTSData generateSentence() {
        List<ContentData> contentData = getContentDataList();
        StringBuilder words = new StringBuilder();
        if(isMorning()) {
            words.append(getWords(TTS_Greeting_MORNING, null));
        } else if(isEvening()) {
            words.append(getWords(TTS_Greeting_Evening, null));
        } else {
            words.append(getWords(TTS_Greeting, null));
        }
        if(contentData.isEmpty()) {
            words.append(".");
        }
        else {
            try {
                @SuppressWarnings("unchecked")
                HashMap<String, String> information = (HashMap<String, String>) contentData.get(0).getData();
                words.append(", ");
                words.append(getWords(TTS_Salutation, information));
            } catch (ClassCastException e) {
                words.append(".");
            }
        }
        TTSData ttsData =  TTSData.createTTSData(words.toString(), getLocale(), 0, ID);
        return ttsData;
    }

    @Override
    public boolean canGenerateForLanguage(String locale) {
        //support for german and english
        if(locale.equals(new Locale("de").getLanguage())) {
            return true;
        } else if (locale.equals(new Locale("en").getLanguage())) {
            return true;
        }
        return true;
    }

    public boolean isMorning() {
        Calendar upperLimit = Calendar.getInstance();
        upperLimit.set(Calendar.HOUR_OF_DAY, 12);
        upperLimit.set(Calendar.MINUTE, 00);
        Calendar lowerLimit = Calendar.getInstance();
        lowerLimit.set(Calendar.HOUR_OF_DAY, 04);
        lowerLimit.set(Calendar.MINUTE,00);
        Calendar now = Calendar.getInstance();
        return now.before(upperLimit) && now.after(lowerLimit);
    }

    public boolean isMidday() {
        Calendar upperLimit = Calendar.getInstance();
        upperLimit.set(Calendar.HOUR_OF_DAY, 14);
        upperLimit.set(Calendar.MINUTE, 00);
        Calendar lowerLimit = Calendar.getInstance();
        lowerLimit.set(Calendar.HOUR_OF_DAY, 12);
        lowerLimit.set(Calendar.MINUTE,00);
        Calendar now = Calendar.getInstance();
        return now.before(upperLimit) && now.after(lowerLimit);
    }

    public boolean isEvening() {
        Calendar upperLimit = Calendar.getInstance();
        upperLimit.set(Calendar.HOUR_OF_DAY, 20);
        upperLimit.set(Calendar.MINUTE, 00);
        Calendar lowerLimit = Calendar.getInstance();
        lowerLimit.set(Calendar.HOUR_OF_DAY, 18);
        lowerLimit.set(Calendar.MINUTE,00);
        Calendar now = Calendar.getInstance();
        return now.before(upperLimit) && now.after(lowerLimit);
    }
}
