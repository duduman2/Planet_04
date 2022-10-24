package trade.dao.face;

import java.sql.Connection;
import java.util.List;

import dto.BoardInfo;
import dto.Product;

public interface ProductDao {

	public int insert(Connection conn, Product product);

	public List<Product> selectBoardList(Connection conn, Product product, String cl);

	public Product selectBoardByProductno(Connection conn, Product product);




}
