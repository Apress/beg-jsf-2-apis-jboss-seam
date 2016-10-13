package stock;

import java.util.Date;

import javax.annotation.Named;
import javax.context.RequestScoped;
import javax.inject.Current;

@Named("b1")
@RequestScoped
public class QuoteRequest {
    private String sym = "MSFT";
    private Date quoteDate = new Date();
    @Current 
    private StockService stkSrv; 

    public QuoteRequest() {
        System.out.println("Creating b1");
    }
    public String getSym() {
        System.out.println("getting sym");
        return sym;
    }

    public void setSym(String sym) {
        System.out.println("setting sym to: " + sym);
        this.sym = sym;
    }

    public Date getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(Date quoteDate) {
        this.quoteDate = quoteDate;
    }

    public int getStockValue() {
        return stkSrv.getStockValue(this);

    }

}
