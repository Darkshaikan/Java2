package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.entidades.Producto;

public class connectionMainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection;
		
		try {
			connection = AdministradorDeConexiones.obtenerConexion();
			Collection<Producto> productos = selectAll(connection);
			//Producto p = new Producto("Test",110.10f,"TEST3",1l);
			//System.out.println(p); // id = null;
			
			//Producto productoConID = createProducto(connection, p);
			//System.out.println(productoConID);
			
			
			System.out.println("Conectado correctamente...");
			selectAll(connection);
			
			System.out.println("----------");
			System.out.println("------selectById-----");
			Producto pConId1 = selectById(connection, 1l);
			System.out.println(pConId1);
			String codigoBuscado = "000009";
			Producto pByCodigo = selectByCodigo(connection, codigoBuscado);
			System.out.println(pByCodigo);
			System.out.println("---Update----");
			Producto productoEditado = new Producto("Gorra", 110f,"000009",9l);
			Producto productoActualizado = updateProducto(connection , 9l, productoEditado);
			System.out.println(productoActualizado);
			System.out.println("---_Delete----");
			Producto productoBorrado = deleteProducto(connection, 10l);
			System.out.println(productoBorrado);
			connection.close();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// connection.close();
		} finally {
			// connection.close();
		}
	}
	
	public static Collection<Producto> selectAll(Connection connection) throws SQLException{
		
		String sqlSelect = "select * from productos";
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		
		Collection<Producto> productos = new ArrayList<Producto>();
		for(Producto producto : productos) {
			System.out.println(producto);
		}
		
		while(resultSet.next()) {
			Long id = resultSet.getLong(1);
			String titulo = resultSet.getString(2);
			Float precio = resultSet.getFloat(3);
			String codigo = resultSet.getString(4);
			Long tipoProducto = resultSet.getLong(5);
			
			Producto producto = new Producto(id,titulo,precio,codigo,tipoProducto);
			productos.add(producto);
			
			System.out.println(producto);
		}
		statement.close();
		return productos;
	}

	public static Producto selectById(Connection connection, Long idProducto) throws SQLException {

		String sqlSelect = "SELECT * FROM productos WHERE id = " + idProducto;
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		Producto producto = null;
		
		if (resultSet.next()) {
			Long id = resultSet.getLong(1);
			String titulo = resultSet.getString(2);
			Float precio = resultSet.getFloat(3);
			String codigo = resultSet.getString(4);
			Long tipoProducto = resultSet.getLong(5);
			
			producto = new Producto(id,titulo,precio,codigo,tipoProducto);
			//System.out.println(producto);
			
			
						
		}
		
		statement.close();
		
		return producto;
		
	}

	public static Producto createProducto(Connection connection, Producto producto) throws Exception{
		String sql = "INSERT INTO productos (titulo, precio, codigo, id_tipo_producto)" 
				+ "VALUES ('"+producto.getTitulo()+"', '"+producto.getPrecio()+"', '"+producto.getCodigo()+"', '"+producto.getTipoProducto()+"')";
		PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		statement.execute();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		if (resultSet.next()) {
			Long pk = resultSet.getLong(1);
			producto.setId(pk);
		}else {
			throw new Exception("Nose puede");
			}
		statement.close();
		return producto;
		
	
		}
	public static Producto updateProducto(Connection connection, Long idProducto, Producto producto) throws Exception {
		
		Producto productoBuscado = selectById(connection, idProducto);
		if (productoBuscado == null) {
			throw new Exception("No se encuentra" + idProducto);
		}
		String sqlSelect = "UPDATE productos "
				+ "SET titulo='"+producto.getTitulo() +"',"
				+ "precio='"+producto.getPrecio() +"',"
				+ "codigo='"+producto.getCodigo() +"',"
				+ "id_tipo_producto='"+producto.getTipoProducto() +"'"
				+ "WHERE id='"+ idProducto +"'";
		
		Statement statement = connection.createStatement();
		int updated = statement.executeUpdate(sqlSelect);
		statement.close();
		if (updated != 1 ) {
			throw new Exception("No se puede modificar");
			
		}
		producto = selectById(connection, idProducto);
		return producto;
	}
	public static Producto deleteProducto(Connection connection,Long id) throws Exception {
		Producto productoBuscado = selectById(connection,id);
		if(productoBuscado == null) {
			throw new Exception("No existe: " + id);
		}
		String sql = "DELETE FROM productos WHERE id = " + id;
		Statement statement = connection.createStatement();
		int deleted = statement.executeUpdate(sql);
		statement.close();
		if (deleted != 1 ) {
			throw new Exception("No se pudo borrar: " + id);
		}
		return productoBuscado;
		
	}

	public static Producto selectByCodigo(Connection connection, String codigoProducto) throws SQLException {
		
		String sqlSelect ="SELECT * FROM productos WHERE codigo = '" + codigoProducto + "'";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		Producto producto = null;
		if(resultSet.next()) {
			Long id = resultSet.getLong(1); // id
			String titulo = resultSet.getString(2);
			Float precio = resultSet.getFloat(3);
			String codigo = resultSet.getString(4);
			Long tipoProducto = resultSet.getLong(5);
			
			producto = new Producto(id, titulo, precio, codigo, tipoProducto);
			//System.out.println(producto);
		
		}
		statement.close();
		resultSet.close();
		return producto;
	}
	
	
}



