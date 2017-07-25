package edu.upm.midas.metamap.model.receiver;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gerardo on 06/07/2017.
 *
 * @author Gerardo Lagunes G. ${EMAIL}
 * @version ${<VERSION>}
 * @project metamap_rest
 * @className ConfigReceiver
 * @see
 */
public class ConfigReceiver {

    @NotNull
    private HashMap<String, String> semanticTypes;
    @NotNull
    private HashMap<String, String> sources;


    public HashMap<String, String> getSemanticTypes() {return semanticTypes;}

    public void setSemanticTypes(HashMap<String, String> semanticTypes) {
        this.semanticTypes = semanticTypes;
    }

    public HashMap<String, String> getSources() {
        return sources;
    }

    public void setSources(HashMap<String, String> sources) {
        this.sources = sources;
    }
}
