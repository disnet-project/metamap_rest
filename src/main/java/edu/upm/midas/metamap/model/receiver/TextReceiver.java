package edu.upm.midas.metamap.model.receiver;
import javax.validation.constraints.NotNull;

/**
 * Created by gerardo on 04/07/2017.
 *
 * @author Gerardo Lagunes G. ${EMAIL}
 * @version ${<VERSION>}
 * @project metamap_rest
 * @className TextReceiver
 * @see
 */
public class TextReceiver {

    @NotNull
    private String id;
    @NotNull
    private String text;

    public TextReceiver() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
