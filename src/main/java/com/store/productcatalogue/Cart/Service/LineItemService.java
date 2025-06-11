package com.store.productcatalogue.Cart.Service;

 

import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.store.productcatalogue.Cart.Exception.DataNotFound;
import com.store.productcatalogue.Cart.Exception.InvalidInput;
import com.store.productcatalogue.Cart.Model.Cart;
import com.store.productcatalogue.Cart.Model.LineItem;
import com.store.productcatalogue.Cart.Repository.CartRepository;
import com.store.productcatalogue.Cart.Repository.LineItemRepository;

 

 

@Service
public class LineItemService {

 

    @Autowired
    LineItemRepository lineitemrepository;

    @Autowired
    CartRepository cartrepository;

    public LineItem searchLineItemById(int id) throws DataNotFound {
        LineItem founditem = null;
        Optional<LineItem> founditems = lineitemrepository.findById(id);

 

        if (founditems.isPresent()) {
            founditem = founditems.get();
        } else {
            throw new DataNotFound("No LineItem with id: " + id);
        }
        return founditem;
}


      public LineItem createitem(LineItem item,int id) throws InvalidInput, DataNotFound
        {
            if(item.getItemId()<1 || item.getPrice()<1.00 || item.getProductId()<1 || item.getProductName()==null || item.getQuantity()<1 )
            {
                throw new InvalidInput("Invalid Input");
            }
            else if(cartrepository.findById(id).isEmpty())
            {
                throw new DataNotFound("No Cart with id: "+id);
            }
            else
            {
                Cart cart=cartrepository.findById(id).get();
                List<LineItem> founditems=cart.getLineitem();
                founditems.add(item);
                cart.setLineitem(founditems);
                cartrepository.save(cart);
                return item;
            }
        }
      public LineItem updateitem(LineItem item,int id) throws InvalidInput, DataNotFound 
        {
            if(lineitemrepository.findById(item.getItemId()).isEmpty() || item.getPrice()<1.00 || item.getProductId()<1 || item.getProductName()==null || item.getQuantity()<1 )
            {
                throw new InvalidInput("Invalid Input");
            }
            else if(cartrepository.findById(id).isEmpty())
            {
                throw new DataNotFound("No Order with id: "+id);
            }
            else
            {
                Cart cart=cartrepository.findById(id).get();
                List<LineItem> founditems=cart.getLineitem();
                int index=founditems.indexOf(searchLineItemById(item.getItemId()));
                founditems.set(index,item);
                cart.setLineitem(founditems);
                cartrepository.save(cart);
                return item;
            }
        }
      public void deleteLineItemById(int id) throws DataNotFound
        {
            if(lineitemrepository.findById(id).isPresent())
            {
                lineitemrepository.deleteById(id);
            }
            else
            {
                throw new DataNotFound("No LineItem with id: "+id);
            }
        }

}