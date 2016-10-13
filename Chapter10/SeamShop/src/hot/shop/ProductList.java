package shop;

import shop.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("productList")
public class ProductList extends EntityQuery<Product> {

	private static final String EJBQL = "select product from Product product";

	private static final String[] RESTRICTIONS = {"lower(product.name) like concat(lower(#{productList.product.name}),'%')",};

	private Product product = new Product();

	public ProductList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Product getProduct() {
		return product;
	}
}
