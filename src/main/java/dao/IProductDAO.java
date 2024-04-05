package dao;

import java.util.List;

import model.Product;

public interface IProductDAO {
   public List<Product> GetAllProduct();

   public List<Product> GetProductByName(String name);

   public void InsertProduct(Product product);

    public void UpdateProduct(Product product);
    
    public void DeleteProduct(String id_product);
}
