package restful_webservice;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ProductDAO;
import model.Product;

@Path("/products")
public class ProductService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts_JSON() {
        ProductDAO productDAO = new ProductDAO();
        List<Product> productList = productDAO.GetAllProduct();
        return productList;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertProduct(Product product) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.InsertProduct(product);
    }

    @DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public void deleteProduct(@PathParam("id") String id) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.DeleteProduct(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduct(Product product) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.UpdateProduct(product);
    }


  
}
