package edu.fbansept.ecommerce.controllers;

import edu.fbansept.ecommerce.dao.CartLineDao;
import edu.fbansept.ecommerce.dao.OrderLineDao;
import edu.fbansept.ecommerce.dao.ProductOfferDao;
import edu.fbansept.ecommerce.dao.ProductOrderDao;
import edu.fbansept.ecommerce.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CartController {

    @Autowired
    private CartLineDao cartLineDao;

    @Autowired
    private OrderLineDao lineOrderDao;

    @Autowired
    private ProductOrderDao productOrderDao;


    @GetMapping("/cart-lines")
    public List<CartLine> findAll() {
        return cartLineDao.findAll();
    }

    @PostMapping("/add-cart-line")
    public void addCartLine(@RequestBody CartLine newCartLine) {
        Optional<CartLine> oldCartLineOptional = cartLineDao.findByCustomerIdAndProductIdAndSellerId(
                1,
                newCartLine.getProductId(),
                newCartLine.getSellerId());

        if(oldCartLineOptional.isEmpty()){
            cartLineDao.save(newCartLine);
        } else {
            CartLine oldCartLine = oldCartLineOptional.get();
            oldCartLine.setQuantity(oldCartLine.getQuantity() + newCartLine.getQuantity());
            cartLineDao.save(oldCartLine);
        }
    }

    @GetMapping("/confirm-cart")
    public void confirmCart() {

        //id customer fix : pour le moment 1, à remplacer par le JWT
        Customer aRemplacerParJwt = new Customer();
        aRemplacerParJwt.setId(1);

        //---- création d'une commande ----
        ProductOrder newProductOrder = new ProductOrder();
        newProductOrder.setCustomer(aRemplacerParJwt);
        productOrderDao.save(newProductOrder);

        //---- dupplication des lignes du panier dans les ligne de la commande ----
        List<CartLine> cartLineList = cartLineDao.findAllByCustomer(aRemplacerParJwt);

        List<OrderLine> lineOrderList = cartLineList.stream().map(cartLine -> {
            OrderLine line = new OrderLine();
            line.setPrice(cartLine.getProductOffer().getPrice());
            line.setQuantity(cartLine.getQuantity());
            line.setProductOrder(newProductOrder);
            line.setProductOffer(cartLine.getProductOffer());
            return line;
        }).collect(Collectors.toList());

        lineOrderDao.saveAll(lineOrderList);

        //---- suppression des lignes du panier dans les lignes de la commande ----
        cartLineDao.deleteByCustomer(aRemplacerParJwt);

    }

}
