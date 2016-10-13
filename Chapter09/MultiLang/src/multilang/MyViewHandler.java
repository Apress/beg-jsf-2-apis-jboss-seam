package multilang;

import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sun.faces.application.view.MultiViewHandler;

public class MyViewHandler extends MultiViewHandler {
    public Locale calculateLocale(FacesContext context) {
        HttpSession session = (HttpSession) context.getExternalContext()
                .getSession(false);
        if (session != null) {
            String langCode = (String) session
                    .getAttribute("multilang.langCode");
            if (langCode != null) {
                return new Locale(langCode);
            }
        }
        return super.calculateLocale(context);
    }
}