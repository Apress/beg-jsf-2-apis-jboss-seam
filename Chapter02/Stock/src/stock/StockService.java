package stock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Named;
import javax.context.ApplicationScoped;
import javax.faces.model.SelectItem;

@Named("b2")
@ApplicationScoped
public class StockService {
    private List<SelectItem> symbols;

    public StockService() {
        symbols = new ArrayList<SelectItem>();
        symbols.add(new SelectItem("MSFT", "Microsoft"));
        symbols.add(new SelectItem("IBM", "IBM"));
        symbols.add(new SelectItem("RHAT", "Red Hat"));
    }

    public List<SelectItem> getSymbols() {
        return symbols;
    }

    public int getStockValue(QuoteRequest r) {
        return Math.abs((r.getSym() + r.getQuoteDate().toString()).hashCode());
    }
}
