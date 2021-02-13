//package com.waterkemper.springsecurityjwt.model.persistmaps.mapkeyenumerated;
//
//import com.waterkemper.springsecurityjwt.model.persistmaps.ItemType;
//import com.waterkemper.springsecurityjwt.model.persistmaps.mapkey.Item;
//
//import javax.persistence.*;
//import java.util.Map;
//
//@Entity
//@Table(name = "orders")
//public class Order {
//    @Id
//    @GeneratedValue
//    @Column(name = "id")
//    private int id;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "order_item_mapping", joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")})
//    @MapKeyEnumerated(EnumType.STRING)
//    private Map<ItemType, Item> itemMap;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Map<ItemType, Item> getItemMap() {
//        return itemMap;
//    }
//
//    public void setItemMap(Map<ItemType, Item> itemMap) {
//        this.itemMap = itemMap;
//    }
//}
