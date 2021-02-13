//package com.waterkemper.springsecurityjwt.model.persistmaps.mapkey;
//
//
//import com.waterkemper.springsecurityjwt.model.persistmaps.ItemType;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.Objects;
//
//@Entity
//@Table(name = "item")
//public class Item {
//    @Id
//    @GeneratedValue
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "name")
//    private String itemName;
//
//    @Column(name = "price")
//    private double itemPrice;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "item_type")
//    private ItemType itemType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "created_on")
//    private Date createdOn;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getItemName() {
//        return itemName;
//    }
//
//    public void setItemName(String itemName) {
//        this.itemName = itemName;
//    }
//
//    public double getItemPrice() {
//        return itemPrice;
//    }
//
//    public void setItemPrice(double itemPrice) {
//        this.itemPrice = itemPrice;
//    }
//
//    public ItemType getItemType() {
//        return itemType;
//    }
//
//    public void setItemType(ItemType itemType) {
//        this.itemType = itemType;
//    }
//
//    public Date getCreatedOn() {
//        return createdOn;
//    }
//
//    public void setCreatedOn(Date createdOn) {
//        this.createdOn = createdOn;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Item item = (Item) o;
//        return id == item.id &&
//                Double.compare(item.itemPrice, itemPrice) == 0 &&
//                Objects.equals(itemName, item.itemName) &&
//                itemType == item.itemType &&
//                Objects.equals(createdOn, item.createdOn);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, itemName, itemPrice, itemType, createdOn);
//    }
//}
