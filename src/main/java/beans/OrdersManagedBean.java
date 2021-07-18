
package beans;


import entity.Orders;
import facade.OrdersFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;


@Named(value = "ordersManagedBean")
@SessionScoped
public class OrdersManagedBean implements Serializable {

    private Integer ordernum;
    private String customer;
    private String address;
   private String productID;
   private List<Orders> _ordersList;
   private String bill;
   
    @Inject
    OrdersFacadeLocal ordersFacadeLocal;
    
    @PostConstruct
    private void init(){
        _ordersList = ordersFacadeLocal.findAll();
    }
    
    public OrdersManagedBean() {
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public List<Orders> getOrdersList() {
        return _ordersList;
    }

    public void setOrdersList(List<Orders> _ordersList) {
        this._ordersList = _ordersList;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }
    
    
    public String buy(){
        return null;
      
}
    
}
