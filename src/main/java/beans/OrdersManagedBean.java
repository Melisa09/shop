package beans;

import entity.Orders;
import entity.Products;
import facade.OrdersFacadeLocal;
import facade.ProductsFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.inject.Inject;

@Named(value = "ordersManagedBean")
@SessionScoped
public class OrdersManagedBean implements Serializable {
    
    int min=1;
    int max=20;
    private Integer ordernum= (int)Math.floor(Math.random()*(max-min+1)+min);
    private String customer;
    private String address;
    private List<Orders> _ordersList;

    
    private List<Products> cart = new ArrayList<>();
    private int quantityCart;
    
    
    @PostConstruct
    private void init() {
        _ordersList = ordersFacadeLocal.findAll();
    }


    @Inject
    OrdersFacadeLocal ordersFacadeLocal;

    @Inject
    ProductsFacadeLocal productsFacadeLocal;

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

    public int getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(int quantityCart) {
        this.quantityCart = quantityCart;
    }

    public List<Products> getCart() {
        return cart;
    }

    public void setCart(List<Products> cart) {
        this.cart = cart;
    }

    public String addTo(Products product) {
        cart.add(new Products(product.getProductID(), product.getName(), quantityCart, product.getPrice()));
        return "index";
    }

    public String buy() {
        
        return "orderConfirmed";
    }

}
