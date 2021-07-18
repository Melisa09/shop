package beans;


import entity.Products;
import facade.ProductsFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;



@Named(value = "productsManagedBean")
@SessionScoped
public class ProductsManagedBean implements Serializable {

   
   
    private Integer productID;
    private String name;
    private Integer quantity;
    private Integer price;
    private List<Products> _productsList;
    private List<Products> _cart = new ArrayList();
    
    @Inject
    ProductsFacadeLocal productsFacadeLocal;
    
    
   @PostConstruct
   private void init(){
       _productsList = productsFacadeLocal.findAll();
   }
    
    public ProductsManagedBean() {
        
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Products> getProductsList() {
        return _productsList;
    }

    public void setProductsList(List<Products> _productsList) {
        this._productsList = _productsList;
    }
   
    public String add(){
  
        Products product = new Products(name,quantity, price);
        productsFacadeLocal.create(product);
        init();
        return "admin";
    }
   

    public String delete(Integer productID) {

        Products product = productsFacadeLocal.find(productID);
        productsFacadeLocal.remove(product);
        init();
        return "admin";

    }

 
}
    
