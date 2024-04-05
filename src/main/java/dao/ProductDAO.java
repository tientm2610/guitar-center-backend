package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO implements IProductDAO {

    // ket noi MySQL
    Connection conn = null;
    // Dua cau lenh querry sang MySQL
    PreparedStatement ps = null;
    // nhan ket qua tra ve
    ResultSet rs = null;
    @Override
    public List<Product> GetAllProduct() {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from product";

        try {
            // mo ket noi voi mysql
            conn = new ConnectMySQL().getConnection();
            // dua cau lenh querry sang MySQL
            ps = conn.prepareStatement(sql);
            // ket qua khi chay cau lenh querry
            rs = ps.executeQuery();
            while (rs.next()) {
                String id_product = rs.getString("id_product");
                String name_product = rs.getString("name");
                int unit = rs.getInt("unit");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                String description = rs.getString("description");
                Product product = new Product(id_product, name_product, unit, price, image,description);
                productList.add(product);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> GetProductByName(String name_product) {
        // TODO Auto-generated method stub
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from product where name =?";

        try {
            conn = new ConnectMySQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name_product);// set name vào dấu ? thứ nhất
            rs = ps.executeQuery();

            while (rs.next()) {
                String id_product = rs.getString("id_product");
                String name = rs.getString("name");
                int unit = rs.getInt("unit");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                String description = rs.getString("description");
               Product product = new Product(id_product, name, unit, price, image,description);
               productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public void InsertProduct(Product product) {
        String sql = "INSERT INTO PRODUCT(id_product,name,unit,price,image,description) VALUES(?,?,?,?,?,?)";

        try {
            conn = new ConnectMySQL().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,product.getId_product());
            ps.setString(2, product.getName_product());
            ps.setInt(3, product.getUnit());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getImage());
            ps.setString(6, product.getDescription());
           ps.executeUpdate();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    @Override
    public void UpdateProduct(Product product) {
        String sql = "UPDATE PRODUCT SET name = ?,unit = ?,price = ?,image = ?, description = ? WHERE id_product = ?";

        try {
            conn = new ConnectMySQL().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(6,product.getId_product());
            ps.setString(1, product.getName_product());
            ps.setInt(2, product.getUnit());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getImage());
            ps.setString(5, product.getDescription());
           ps.executeUpdate();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    @Override
    public void DeleteProduct( String id_product) {
        String sql = "delete from product where id_product=?";
    	
    	try {
    		conn = new ConnectMySQL().getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setString(1, id_product);
        	ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

  
}

