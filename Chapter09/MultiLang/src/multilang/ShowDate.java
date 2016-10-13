package multilang;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.Named;
import javax.context.RequestScoped;
import javax.faces.application.Application;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

@Named("showDate")
@RequestScoped
public class ShowDate {
    private String langCode;

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public List<SelectItem> getLangCodes() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        Application app = FacesContext.getCurrentInstance().getApplication();
        Locale locale = app.getDefaultLocale();
        String display = locale.getDisplayName(locale);
        items.add(new SelectItem(locale.toString(), display));
        Iterator<Locale> iter = app.getSupportedLocales();
        while (iter.hasNext()) {
            locale = iter.next();
            display = locale.getDisplayName(locale);
            items.add(new SelectItem(locale.toString(), display));
        }
        return items;
    }

    public String changeLangCode() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        if (session != null) {
            session.setAttribute("multilang.langCode", langCode);
        }
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        viewRoot.setLocale(new Locale(langCode));
        return null;
    }

    public Date getToday() {
        return new Date();
    }

}