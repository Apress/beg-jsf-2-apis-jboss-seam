package postage;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class RequestValidatingListener implements ActionListener {
    public void processAction(ActionEvent event)
            throws AbortProcessingException {
        FacesContext context = FacesContext.getCurrentInstance();
        Application app = context.getApplication();
        Request req = (Request) app.evaluateExpressionGet(context, "#{r}",
                Request.class);
        if (!req.isValid()) {
            context.addMessage("f:w", new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "weight too heavy for the patron", null));
            throw new AbortProcessingException();
        }
    }
}