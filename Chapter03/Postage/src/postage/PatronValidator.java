package postage;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class PatronValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object convertedValue) throws ValidatorException {
        String patronCode = (String) convertedValue;
        Application app = context.getApplication();
        PostageService ps = (PostageService) app.evaluateExpressionGet(context,
                "#{ps}", PostageService.class);
        if (!ps.patronExists(patronCode)) {
            Locale locale = context.getViewRoot().getLocale();
            ResourceBundle b = ResourceBundle.getBundle("postage.Postage",
                    locale);
            String summary = b.getString("foo.v1.UNKNOWN_PATRON");
            String detail = MessageFormat.format(b
                    .getString("foo.v1.UNKNOWN_PATRON_detail"), patronCode);
            throw new ValidatorException(new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, summary, detail));
        }
    }

}
